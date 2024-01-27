package com.example.transformerexample.logic

abstract class TextTransformerDecorator(private val transformer: TextTransformer) : TextTransformer {
    override fun transform(): String {
        return transformer.transform()
    }
}