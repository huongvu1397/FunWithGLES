package com.excalibur.funwithgles.models

data class MyVideo(override val name: String, override val path: String, override val typeMedia: TypeMedia=TypeMedia.VIDEO): MyMedia(name, path
)