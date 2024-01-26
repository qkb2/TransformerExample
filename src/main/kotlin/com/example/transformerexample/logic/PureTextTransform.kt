package com.example.transformerexample.logic

class PureTextTransform(private val str: String) : TextTransform {

    override fun transform(): String {
        return str
    }
}