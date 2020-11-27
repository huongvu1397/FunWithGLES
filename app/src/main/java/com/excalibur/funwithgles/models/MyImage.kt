package com.excalibur.funwithgles.models

data class MyImage(override val name: String, override val path: String, override val typeMedia: TypeMedia=TypeMedia.IMAGE): MyMedia(name, path
)