package com.excalibur.funwithgles.models

open class MyMedia(open val name :String, open val path:String,open val typeMedia:TypeMedia=TypeMedia.NONE)

enum class TypeMedia{
    VIDEO,IMAGE,AUDIO,NONE
}