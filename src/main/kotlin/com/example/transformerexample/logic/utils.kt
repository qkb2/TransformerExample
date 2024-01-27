package com.example.transformerexample.logic

/**
 * This method goes through all the transforms in transforms.
 * @param text text to transform
 * @param transforms list of commands corresponding to different transformers
 * @return a built StringTransformer
 */
fun composeTransform(text: String, transforms: Array<String>) : TextTransformer {
    var base: TextTransformer = PureTextTransformer(text)
    for (transform in transforms) {
        base = when (transform) {
            "UPPER" -> LetterCaseDecorator(base, LetterCaseOptions.UPPER)
            "LOWER" -> LetterCaseDecorator(base, LetterCaseOptions.LOWER)
            "CAPITALIZE" -> LetterCaseDecorator(base, LetterCaseOptions.CAPITALIZE)
            "INVERSE" -> InverseTextDecorator(base)
            else -> continue // skip if a transform requested doesn't exist
        }
    }
    return base
}