package com.excalibur.funwithgles.opgl1_airhockey;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES10.glClear;
import static android.opengl.GLES10.glClearColor;
import static android.opengl.GLES10.glViewport;
import static android.opengl.GLES20.glEnableVertexAttribArray;
import static javax.microedition.khronos.opengles.GL10.GL_COLOR_BUFFER_BIT;

public class AirHockeyRenderer implements GLSurfaceView.Renderer {

    private static final String U_COLOR = "u_Color";
    private static final String A_POSITION = "a_Position";
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int BYTES_PER_FLOAT = 4;
    private FloatBuffer vertexData= null;
    private Context context = null;
    private int program;
    private int uColorLocation;
    private int aPositionLocation;


    public AirHockeyRenderer(Context context) {
        this.context = context;

        /*
		float[] tableVertices = {
			0f,  0f,
			0f, 14f,
			9f, 14f,
			9f,  0f
		};
         */
        /*
		float[] tableVerticesWithTriangles = {
			// Triangle 1
			0f,  0f,
			9f, 14f,
			0f, 14f,

			// Triangle 2
			0f,  0f,
			9f,  0f,
			9f, 14f
			// Next block for formatting purposes
			9f, 14f,
			, // Comma here for formatting purposes

			// Line 1
			0f,  7f,
			9f,  7f,

			// Mallets
			4.5f,  2f,
			4.5f, 12f
		};
         */
        float[] tableVerticesWithTriangles = {
                // Triangle 1
                -0.5f, -0.5f,
                0.5f,  0.5f,
                -0.5f,  0.5f,

                // Triangle 2
                -0.5f, -0.5f,
                0.5f, -0.5f,
                0.5f,  0.5f,

                // Line 1
                -0.5f, 0f,
                0.5f, 0f,

                // Mallets
                0f, -0.25f,
                0f,  0.25f
        };

        vertexData = ByteBuffer
                .allocateDirect(tableVerticesWithTriangles.length * BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();

        vertexData.put(tableVerticesWithTriangles);
    }





    @Override
    public void onSurfaceCreated(GL10 glUnused, EGLConfig config) {
       /*
		// Set the background clear color to red. The first component is red,
		// the second is green, the third is blue, and the last component is
		// alpha, which we don't use in this lesson.
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
         */

//        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//
//        String vertexShaderSource = TextResourceReader
//                .readTextFileFromResource(context, R.raw.simple_vertex_shader);
//        String fragmentShaderSource = TextResourceReader
//                .readTextFileFromResource(context, R.raw.simple_fragment_shader);
//
//        int vertexShader = ShaderHelper.compileVertexShader(vertexShaderSource);
//        int fragmentShader = ShaderHelper.compileFragmentShader(fragmentShaderSource);
//
//        program = ShaderHelper.linkProgram(vertexShader, fragmentShader);
//
//        if (LoggerConfig.ON) {
//            ShaderHelper.validateProgram(program);
//        }
//
//        glUseProgram(program);
//
//        uColorLocation = glGetUniformLocation(program, U_COLOR);
//
//        aPositionLocation = glGetAttribLocation(program, A_POSITION);
//
//        // Bind our data, specified by the variable vertexData, to the vertex
//        // attribute at location A_POSITION_LOCATION.
//        vertexData.position(0);
//        glVertexAttribPointer(aPositionLocation, POSITION_COMPONENT_COUNT, GL_FLOAT,
//                false, 0, vertexData);
//
//        glEnableVertexAttribArray(aPositionLocation);
    }

    @Override
    public void onSurfaceChanged(GL10 glUnused, int width, int height) {
        // Set the OpenGL viewport to fill the entire surface.
        glViewport(0, 0, width, height);
        Log.e("HVV1312","onSurfaceChanged : "+width + " and "+height);
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        // Clear the rendering surface.
        glClear(GL_COLOR_BUFFER_BIT);
        //Log.e("HVV1312","onDrawFrame");
    }

}