package com.example.transformerexample.rest

import com.fasterxml.jackson.core.JsonProcessingException
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/text")
class TextTransformerController {
    private val logger = LoggerFactory.getLogger(TextTransformerController::class.java)

    /**
     * Default GET request.
     * @param text text to be transformed
     * @param transforms list of transforms to be applied
     * @return JSON string
     * @throws JsonProcessingException if critical failure
     */
    @RequestMapping(value = ["/{text}"], method = [RequestMethod.GET], produces = ["application/json"])
    @Throws(JsonProcessingException::class)
    operator fun get(
        @PathVariable text: String?,
        @RequestParam(value = "transforms", defaultValue = "UPPER") transforms: Array<String?>?
    ): String {
        return transformText(text, transforms)
    }

    private fun transformText(text: String?, transforms: Array<String?>?): String {
        TODO("Not yet implemented")
    }

}