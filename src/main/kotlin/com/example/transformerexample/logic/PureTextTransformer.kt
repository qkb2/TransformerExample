package com.example.transformerexample.logic

class PureTextTransformer(private val str: String) : TextTransformer {

    override fun transform(): String {
        return str
    }
}