package util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient

const val TELEGRAPH_API_BASE_URL = "https://api.telegra.ph/"
const val TELEGRAPH_BASE_URL = "https://telegra.ph/"
const val UPLOAD_BASE_URL = "${TELEGRAPH_BASE_URL}upload/"

val defaultClient = OkHttpClient.Builder()
    .build()

val objectMapper: ObjectMapper = jacksonObjectMapper()
    .registerKotlinModule()
    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
