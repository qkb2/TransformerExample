package com.example.transformerexample.logic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class InverseDecoratorTest {
    private lateinit var mockTransformer: TextTransformer

    @BeforeEach
    fun setUp() {
        mockTransformer = Mockito.mock(TextTransformer::class.java)
    }

    @Test
    fun testTransform() {
        Mockito.`when`(mockTransformer.transform()).thenReturn("Hello World")
        val transformer = InverseTextDecorator(mockTransformer)
        val result = transformer.transform()
        Assertions.assertEquals("Dlrow Olleh", result)
    }

    @Test
    fun testEmpty() {
        Mockito.`when`(mockTransformer.transform()).thenReturn("")
        val transformer = InverseTextDecorator(mockTransformer)
        val result: String = transformer.transform()
        Assertions.assertEquals("", result)
    }

    // Test with special characters
    @Test
    fun testSpecialCharacters() {
        Mockito.`when`(mockTransformer.transform()).thenReturn("Hello World @#$%^&*()_+|}{:?><")
        val transformer = InverseTextDecorator(mockTransformer)
        val result: String = transformer.transform()
        Assertions.assertEquals("<>?:{}|+_)(*&^%$#@ dlroW olleH", result)
    }
}