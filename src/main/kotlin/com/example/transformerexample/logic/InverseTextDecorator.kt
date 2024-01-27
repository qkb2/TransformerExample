package com.example.transformerexample.logic

class InverseTextDecorator(transformer: TextTransformer) : TextTransformerDecorator(transformer) {
    override fun transform(): String {
        return inversionDecorate(super.transform())
    }

    /**
     * Decorates the string by inverting a string and changing the letter case
     * of the letter at every index i in inverted string to be the same as letter case
     * of the letter at that index in original string.
     *
     * @param s the string to be decorated
     * @return the decorated string
     */
    private fun inversionDecorate(s: String): String {
        var result = ""
        for (i in s.indices) {
            val c = s[i]
            var reverseC = s[s.length - 1 - i]
            if (Character.isUpperCase(c)) {
                reverseC = reverseC.uppercaseChar()
            } else if (Character.isLowerCase(c)) {
                reverseC = reverseC.lowercaseChar()
            }
            result += reverseC
        }
        return result
    }
}