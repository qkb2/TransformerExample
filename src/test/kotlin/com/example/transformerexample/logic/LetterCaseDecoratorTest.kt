package com.example.transformerexample.logic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class LetterCaseDecoratorTest {
    private lateinit var mockStringTransformer: TextTransformer

    @BeforeEach
    fun setUp() {
        mockStringTransformer = Mockito.mock(TextTransformer::class.java)
    }

    @Test
    fun testTransformToUpperCase() {
        // Arrange
        val input = "This is a test string."
        Mockito.`when`(mockStringTransformer.transform()).thenReturn(input)
        val letterCaseTransformer = LetterCaseDecorator(mockStringTransformer, LetterCaseOptions.UPPER)

        // Act
        val result: String = letterCaseTransformer.transform()

        // Assert
        Assertions.assertEquals("THIS IS A TEST STRING.", result)
    }

    @Test
    fun testTransformToLowerCase() {
        // Arrange
        val input = "This Is A Test String."
        Mockito.`when`(mockStringTransformer.transform()).thenReturn(input)
        val letterCaseTransformer = LetterCaseDecorator(mockStringTransformer, LetterCaseOptions.LOWER)

        // Act
        val result: String = letterCaseTransformer.transform()

        // Assert
        Assertions.assertEquals("this is a test string.", result)
    }

    @Test
    fun testTransformToCapitalize() {
        // Arrange
        val input = "this is a test string."
        Mockito.`when`(mockStringTransformer.transform()).thenReturn(input)
        val letterCaseTransformer = LetterCaseDecorator(mockStringTransformer, LetterCaseOptions.CAPITALIZE)

        // Act
        val result: String = letterCaseTransformer.transform()

        // Assert
        Assertions.assertEquals("This Is A Test String.", result)
    }

    @Test
    fun testTransformToCapitalizeAllUppercase() {
        // Arrange
        val input = "THIS IS A TEST STRING."
        Mockito.`when`(mockStringTransformer.transform()).thenReturn(input)
        val letterCaseTransformer = LetterCaseDecorator(mockStringTransformer, LetterCaseOptions.CAPITALIZE)

        // Act
        val result: String = letterCaseTransformer.transform()

        // Assert
        Assertions.assertEquals("This Is A Test String.", result)
    }

    // Test with special characters
    @Test
    fun testTransformToCapitalizeSpecialCharacters() {
        // Arrange
        val input = "this is a test string with special characters: !@#$%^&*()_+"
        Mockito.`when`(mockStringTransformer.transform()).thenReturn(input)
        val letterCaseTransformer = LetterCaseDecorator(mockStringTransformer, LetterCaseOptions.CAPITALIZE)

        // Act
        val result: String = letterCaseTransformer.transform()

        // Assert
        Assertions.assertEquals("This Is A Test String With Special Characters: !@#$%^&*()_+", result)
    }
}