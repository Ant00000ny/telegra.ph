package method

import com.fasterxml.jackson.annotation.JsonProperty

data class GetPage(
    @field:JsonProperty("path")
    val path: String,
    @field:JsonProperty("return_content")
    val returnContent: Boolean,
) : Method {
    override fun getUrlPath() = "getPage"
}
