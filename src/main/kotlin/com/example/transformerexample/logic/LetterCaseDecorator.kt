package com.example.transformerexample.logic

import java.util.*

class LetterCaseDecorator(transformer: TextTransformer, private val mode: LetterCaseOptions = LetterCaseOptions.UPPER) :
    TextTransformerDecorator(transformer) {
    override fun transform(): String {
        return letterCaseDecorate(super.transform())
    }

    /**
     * Decorates the string by changing the letter-case based on the mode.
     * For UPPER/LOWER uses toUpper/LowerCase() on whole string.
     * For CAPITALIZE splits string into words (split on spaces)
     * and capitalizes first letter of each word.
     *
     * @param s the string to be decorated
     * @return the decorated string
     */
    private fun letterCaseDecorate(s: String): String {
        when (mode) {
            LetterCaseOptions.UPPER -> return s.uppercase(Locale.getDefault())
            LetterCaseOptions.LOWER -> return s.lowercase(Locale.getDefault())
            LetterCaseOptions.CAPITALIZE -> {
                val words =
                    s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val transformedWords: MutableList<String> =
                    ArrayList()
                for (word in words) {
                    transformedWords.add(
                        word.substring(0, 1).uppercase(Locale.getDefault()) + word.substring(1)
                            .lowercase(Locale.getDefault())
                    )
                }
                return transformedWords.joinToString(separator = " ")
            }
        }
    }
}