package com.example.transformerexample.logic

abstract class TextTransformDecorator(private val transform: TextTransform) : TextTransform {
    override fun transform(): String {
        return transform.transform()
    }
}