package method

import com.fasterxml.jackson.annotation.JsonProperty

data class GetPageList(
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("offset")
    val offset: Int,
    @field:JsonProperty("limit")
    val limit: Int,
) : Method {
    override fun getUrlPath() = "getPageList"
}
