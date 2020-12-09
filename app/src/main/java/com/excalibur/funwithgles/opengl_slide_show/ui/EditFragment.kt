package com.excalibur.funwithgles.opengl_slide_show.ui

import android.media.MediaCodec
import android.media.MediaExtractor
import android.media.MediaFormat
import android.opengl.GLES20
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import com.excalibur.funwithgles.App
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.opengl_slide_show.adapter.InfoPathAdapter
import com.excalibur.funwithgles.opengl_slide_show.base.BaseFragment
import com.excalibur.funwithgles.opengl_slide_show.glbase.EglCore
import com.excalibur.funwithgles.opengl_slide_show.glbase.WindowSurface
import kotlinx.android.synthetic.main.fragment_edit.*
import java.io.File
import java.io.FileNotFoundException

class EditFragment : BaseFragment(), SurfaceHolder.Callback {

    private lateinit var infoPathAdapter: InfoPathAdapter

    private var mSurfaceView: SurfaceView? = null
    private var mSurfaceHolderReady = false

    private val mThread: Thread? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSurfaceView()
        initLinkAdapter()
        //initTextureView()
        //updateSizeTexture()
        btnPlay.setOnClickListener {
            if(mSurfaceHolderReady){
                play()
            }else{
                Toast.makeText(App.self(),"Surface Holder Not Ready!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initSurfaceView() {
        mSurfaceView = playMovie_surface
        mSurfaceView?.holder?.addCallback(this)
    }

    private fun initLinkAdapter() {
        infoPathAdapter = InfoPathAdapter()
        rcvList.adapter = infoPathAdapter
        infoPathAdapter.submitList(mainViewModel.listPath.value)
    }

    //Declare variable
    private var mBufferInfo: MediaCodec.BufferInfo = MediaCodec.BufferInfo()

    // May be set/read by different threads.
    @Volatile
    private var mIsStopRequested: Boolean = false

    private var mSourceFile: File? = null
    private var mOutputSurface: Surface? = null
    var mFrameCallback: FrameCallback? = null
    private var mLoop = false
    private var mVideoWidth = 0
    private var mVideoHeight = 0

    private fun setupVideo(pathVideo: String) {
        val holder = mSurfaceView?.holder
        val surface = holder?.surface
        if (surface != null)
            clearSurface(surface)
        //Step 1 : Constucts a MoviePlayer
        // sourceFile : The video file to open.
        // outputSurface : The Surface where frames will be sent.
        // frameCallback : Callback object, used to pace output.
        mSourceFile = File(pathVideo)
        mOutputSurface = surface
        mFrameCallback = ControlCallback()
        //Step 2 :

        // Pop the file open and pull out the video characteristics.
        var extractor: MediaExtractor? = null
        try {
            extractor = MediaExtractor()
            extractor.setDataSource(mSourceFile.toString())
            val trackIndex: Int = selectTrack(extractor)
            if (trackIndex < 0) {
                throw RuntimeException("No video track found in $mSourceFile")
            }
            extractor.selectTrack(trackIndex)
            val format = extractor.getTrackFormat(trackIndex)
            mVideoWidth = format.getInteger(MediaFormat.KEY_WIDTH)
            mVideoHeight = format.getInteger(MediaFormat.KEY_HEIGHT)
            Log.e("HVV1312", "Video size is " + mVideoWidth + "x" + mVideoHeight)
        } finally {
            extractor?.release()
        }

        playMovie_afl.setAspectRatio((mVideoWidth / mVideoHeight).toDouble())

    }


    override fun surfaceCreated(holder: SurfaceHolder?) {
        mSurfaceHolderReady = true
        setupVideo(mainViewModel.listPath.value!![0])

        Log.e("HVV1312", "surfaceCreated")
        //play()
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        Log.e("HVV1312", "surfaceChanged fmt=" + format + " size=" + width + "x" + height)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        Log.e("HVV1312", "surfaceDestroyed")
    }

    /**
     * Decodes the video stream, sending frames to the surface.
     * <p>
     * Does not return until video playback is complete, or we get a "stop" signal from
     * frameCallback.
     */
    private fun play() {
        var extractor: MediaExtractor? = null
        var decoder: MediaCodec? = null
        // The MediaExtractor error messages aren't very useful.  Check to see if the input
        // file exists so we can throw a better one if it's not there.

        // The MediaExtractor error messages aren't very useful.  Check to see if the input
        // file exists so we can throw a better one if it's not there.
        if (mSourceFile?.canRead() == false) {
            throw FileNotFoundException("Unable to read $mSourceFile")
        }

        try {
            extractor = MediaExtractor()
            extractor.setDataSource(mSourceFile.toString())
            val trackIndex: Int = selectTrack(extractor)
            if (trackIndex < 0) {
                throw java.lang.RuntimeException("No video track found in $mSourceFile")
            }
            extractor.selectTrack(trackIndex)
            val format: MediaFormat = extractor.getTrackFormat(trackIndex)

            // Create a MediaCodec decoder, and configure it with the MediaFormat from the
            // extractor.  It's very important to use the format from the extractor because
            // it contains a copy of the CSD-0/CSD-1 codec-specific data chunks.
            val mime = format.getString(MediaFormat.KEY_MIME)
            decoder = MediaCodec.createDecoderByType(mime)
            decoder.configure(format, mOutputSurface, null, 0)
            decoder.start()
            doExtract(extractor, trackIndex, decoder, mFrameCallback)
        } finally {
            // release everything we grabbed
            if (decoder != null) {
                decoder.stop()
                decoder.release()
                decoder = null
            }
            if (extractor != null) {
                extractor.release()
                extractor = null
            }
        }

    }

    /**
     * Work loop.  We execute here until we run out of video or are told to stop.
     */
    private fun doExtract(
        extractor: MediaExtractor,
        trackIndex: Int,
        decoder: MediaCodec,
        frameCallback: FrameCallback?
    ) {
        val TIMEOUT_USEC = 10000
        val decoderInputBuffers = decoder.inputBuffers
        var inputChunk = 0
        var firstInputTimeNsec = -1L
        var outputDone = false
        var inputDone = false

        while (!outputDone) {
            Log.e("HVV1312", "loop")
            if (mIsStopRequested) {
                Log.e("HVV1312", "Stop requested")
                return
            }
            // Feed more data to the decoder.
            if (!inputDone) {
                var inputBufIndex = decoder.dequeueInputBuffer(TIMEOUT_USEC.toLong())
                if (inputBufIndex >= 0) {
                    if (firstInputTimeNsec == -1L) {
                        firstInputTimeNsec = System.nanoTime()
                    }
                    val inputBuf = decoderInputBuffers[inputBufIndex]
                    var chunkSize = extractor.readSampleData(inputBuf, 0)
                    if (chunkSize < 0) {
                        //
                        decoder.queueInputBuffer(
                            inputBufIndex,
                            0,
                            0,
                            0L,
                            MediaCodec.BUFFER_FLAG_END_OF_STREAM
                        )
                        inputDone = true
                        Log.e("HVV1312", "sent input EOS")
                    } else {
                        if (extractor.sampleTrackIndex != trackIndex) {
                            Log.e(
                                "HVV1312",
                                "WEIRD : got sample from track : ${extractor.sampleTrackIndex}, expected : $trackIndex"
                            )
                        }
                        var presentationTimeUs = extractor.sampleTime
                        decoder.queueInputBuffer(inputBufIndex, 0, chunkSize, presentationTimeUs, 0)
                        Log.e("HVV1312", "submitted frame : $inputChunk to dec, size= $chunkSize")
                        inputChunk++
                        extractor.advance()
                    }
                } else {
                    Log.e("HVV1312", "input buffer not available")
                }
            }

            if (!outputDone) {
                var decoderStatus = decoder.dequeueOutputBuffer(mBufferInfo, TIMEOUT_USEC.toLong())
                if (decoderStatus == MediaCodec.INFO_TRY_AGAIN_LATER) {
                    // no output availabe yet
                } else if (decoderStatus == MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED) {
                    // not important for us, since we're using Surface
                } else if (decoderStatus == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                    val newFormat = decoder.outputFormat
                    Log.e("HVV1312", "decoder output format changed: $newFormat")
                } else if (decoderStatus < 0) {
                    throw java.lang.RuntimeException(
                        "unexpected result from decoder.dequeueOutputBuffer: " +
                                decoderStatus
                    )
                } else {
                    if (firstInputTimeNsec != 0L) {
                        // Log the delay from the first buffer of input to the first buffer
                        // of output.
                        val nowNsec = System.nanoTime()
                        Log.e(
                            "HVV1312",
                            "startup lag " + (nowNsec - firstInputTimeNsec) / 1000000.0 + " ms"
                        )
                        firstInputTimeNsec = 0
                    }
                    var doLoop = false
                    Log.e(
                        "HVV1312",
                        "surface decoder given buffer $decoderStatus (size=${mBufferInfo.size})"
                    )
                    if (mBufferInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM != 0) {
                            Log.e("HVV1312", "output EOS")
                        if (mLoop) {
                            doLoop = true
                        } else {
                            outputDone = true
                        }
                    }

                    var doRender = (mBufferInfo.size != 0)

                    // As soon as we call releaseOutputBuffer, the buffer will be forwarded
                    // to SurfaceTexture to convert to a texture.  We can't control when it
                    // appears on-screen, but we can manage the pace at which we release
                    // the buffers.
                    if(doRender && frameCallback != null){
                        frameCallback.preRender(mBufferInfo.presentationTimeUs)
                    }
                    decoder.releaseOutputBuffer(decoderStatus,doRender)
                    if(doRender && frameCallback != null){
                        frameCallback.postRender()
                    }

                    if(doLoop){
                        Log.e("HVV1312","Reached EOS, looping")
                        extractor.seekTo(0,MediaExtractor.SEEK_TO_CLOSEST_SYNC)
                        inputDone = false
                        decoder.flush() // reset decoder state
                        frameCallback?.loopReset()
                    }

                }
            }
        }
        //while()
    }


    /**
     * Selects the video track, if any.
     *
     * @return the track index, or -1 if no video track is found.
     */
    private fun selectTrack(extractor: MediaExtractor): Int {
        // Select the first video track we find, ignore the rest.
        val numTracks = extractor.trackCount
        for (i in 0 until numTracks) {
            val format = extractor.getTrackFormat(i)
            val mime = format.getString(MediaFormat.KEY_MIME)
            if (mime.startsWith("video/")) {
                Log.e(
                    "HVV1312",
                    "Extractor selected track $i ($mime): $format"
                )
                return i
            }
        }
        return -1
    }

    //Callback
    inner class ControlCallback : FrameCallback {
        private var CHECK_SLEEP_TIME = false
        private var ONE_MILLION = 1000000L
        private var mPrevPresentUsec: Long = 0
        private var mPrevMonoUsec: Long = 0
        private var mFixedFrameDurationUsec: Long = 0
        private var mLoopReset = false

        /**
         * Sets a fixed playback rate.  If set, this will ignore the presentation time stamp
         * in the video file.  Must be called before playback thread starts.
         */
        fun setFixedPlaybackRate(fps: Int) {
            mFixedFrameDurationUsec = ONE_MILLION / fps
        }

        // runs on decode thread
        override fun preRender(presentationTimeUsec: Long) {
            // For the first frame, we grab the presentation time from the video
            // and the current monotonic clock time.  For subsequent frames, we
            // sleep for a bit to try to ensure that we're rendering frames at the
            // pace dictated by the video stream.
            //
            // If the frame rate is faster than vsync we should be dropping frames.  On
            // Android 4.4 this may not be happening.
            if (mPrevMonoUsec == 0L) {
                // Latch current values, then return immediately.
                mPrevMonoUsec = System.nanoTime() / 1000
                mPrevPresentUsec = presentationTimeUsec
            } else {
                // Compute the desired time delta between the previous frame and this frame.
                var frameDelta: Long
                if (mLoopReset) {
                    // We don't get an indication of how long the last frame should appear
                    // on-screen, so we just throw a reasonable value in.  We could probably
                    // do better by using a previous frame duration or some sort of average;
                    // for now we just use 30fps.
                    mPrevPresentUsec =
                        presentationTimeUsec - ONE_MILLION / 30
                    mLoopReset = false
                }
                frameDelta = if (mFixedFrameDurationUsec != 0L) {
                    // Caller requested a fixed frame rate.  Ignore PTS.
                    mFixedFrameDurationUsec
                } else {
                    presentationTimeUsec - mPrevPresentUsec
                }
                if (frameDelta < 0) {
                    Log.w(
                        "HVV1312",
                        "Weird, video times went backward"
                    )
                    frameDelta = 0
                } else if (frameDelta == 0L) {
                    // This suggests a possible bug in movie generation.
                    Log.i(
                        "HVV1312",
                        "Warning: current frame and previous frame had same timestamp"
                    )
                } else if (frameDelta > 10 * ONE_MILLION) {
                    // Inter-frame times could be arbitrarily long.  For this player, we want
                    // to alert the developer that their movie might have issues (maybe they
                    // accidentally output timestamps in nsec rather than usec).
                    Log.i(
                        "HVV1312",
                        "Inter-frame pause was " + frameDelta / ONE_MILLION +
                                "sec, capping at 5 sec"
                    )
                    frameDelta = 5 * ONE_MILLION
                }
                val desiredUsec = mPrevMonoUsec + frameDelta // when we want to wake up
                var nowUsec = System.nanoTime() / 1000
                while (nowUsec < desiredUsec - 100 /*&& mState == RUNNING*/) {
                    // Sleep until it's time to wake up.  To be responsive to "stop" commands
                    // we're going to wake up every half a second even if the sleep is supposed
                    // to be longer (which should be rare).  The alternative would be
                    // to interrupt the thread, but that requires more work.
                    //
                    // The precision of the sleep call varies widely from one device to another;
                    // we may wake early or late.  Different devices will have a minimum possible
                    // sleep time. If we're within 100us of the target time, we'll probably
                    // overshoot if we try to sleep, so just go ahead and continue on.
                    var sleepTimeUsec = desiredUsec - nowUsec
                    if (sleepTimeUsec > 500000) {
                        sleepTimeUsec = 500000
                    }
                    try {
                        if (CHECK_SLEEP_TIME) {
                            val startNsec = System.nanoTime()
                            Thread.sleep(
                                sleepTimeUsec / 1000,
                                (sleepTimeUsec % 1000).toInt() * 1000
                            )
                            val actualSleepNsec = System.nanoTime() - startNsec
                            Log.e(
                                "HVV1312",
                                "sleep=" + sleepTimeUsec + " actual=" + actualSleepNsec / 1000 +
                                        " diff=" + Math.abs(actualSleepNsec / 1000 - sleepTimeUsec) +
                                        " (usec)"
                            )
                        } else {
                            Thread.sleep(
                                sleepTimeUsec / 1000,
                                (sleepTimeUsec % 1000).toInt() * 1000
                            )
                        }
                    } catch (ie: InterruptedException) {
                    }
                    nowUsec = System.nanoTime() / 1000
                }

                // Advance times using calculated time values, not the post-sleep monotonic
                // clock time, to avoid drifting.
                mPrevMonoUsec += frameDelta
                mPrevPresentUsec += frameDelta
            }
        }

        // runs on decode thread
        override fun postRender() {

        }

        override fun loopReset() {

        }

    }


    /**
     * Callback invoked when rendering video frames.  The MoviePlayer client must
     * provide one of these.
     */
    interface FrameCallback {
        /**
         * Called immediately before the frame is rendered.
         * @param presentationTimeUsec The desired presentation time, in microseconds.
         */
        fun preRender(presentationTimeUsec: Long)

        /**
         * Called immediately after the frame render call returns.  The frame may not have
         * actually been rendered yet.
         * TODO: is this actually useful?
         */
        fun postRender()

        /**
         * Called after the last frame of a looped movie has been rendered.  This allows the
         * callback to adjust its expectations of the next presentation time stamp.
         */
        fun loopReset()
    }

    /**
     * Clears the playback surface to black.
     */
    // Don't leave the last frame of the previous video hanging on the screen.
    // Looks weird if the aspect ratio changes.
    private fun clearSurface(surface: Surface) {
        // We need to do this with OpenGL ES (*not* Canvas -- the "software render" bits
        // are sticky).  We can't stay connected to the Surface after we're done because
        // that'd prevent the video encoder from attaching.
        //
        // If the Surface is resized to be larger, the new portions will be black, so
        // clearing to something other than black may look weird unless we do the clear
        // post-resize.
        val eglCore = EglCore()
        val win = WindowSurface(eglCore, surface, false)
        win.makeCurrent()
        GLES20.glClearColor(0f, 0f, 0f, 0f)
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
        win.swapBuffers()
        win.release()
        eglCore.release()
    }

    /*
    https://stackoverflow.com/questions/29009210/texture-view-video-and-bitmap-display
    private fun initTextureView(){
        surfaceView.surfaceTextureListener = surfaceTextureListener
    }

    private fun updateSizeTexture(){
        surfaceView.layoutParams.width = 720
        surfaceView.layoutParams.height = 720
    }

    private val surfaceTextureListener = object : SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(
            surfaceTexture: SurfaceTexture?,
            width: Int,
            height: Int
        ) {
            l = Surface(surfaceTexture)
            val bm = BitmapFactory.decodeFile(mainViewModel.listPath.value!![0])
            val canvas = l?.lockCanvas(Rect(0, 0, width, height))
            canvas?.drawBitmap(
                bm,
                (width / 2) - (bm.width / 2).toFloat(),
                (height / 2) - (bm.height / 2).toFloat(),
                null
            )
            l?.unlockCanvasAndPost(canvas)
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureAvailable $width - $height")
        }

        override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture?, p1: Int, p2: Int) {
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureSizeChanged $p1 - $p2")
    }

        override fun onSurfaceTextureDestroyed(p0: SurfaceTexture?): Boolean {
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureDestroyed")
            return false
        }

        override fun onSurfaceTextureUpdated(p0: SurfaceTexture?) {
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureUpdated")
        }

    }
 */

}