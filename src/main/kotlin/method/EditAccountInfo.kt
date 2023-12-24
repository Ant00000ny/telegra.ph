package method

import com.fasterxml.jackson.annotation.JsonProperty

data class EditAccountInfo(
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("short_name")
    val shortName: String,
    @field:JsonProperty("author_name")
    val authorName: String,
    @field:JsonProperty("author_url")
    val authorUrl: String,
) : Method {
    override fun getUrlPath() = "editAccountInfo"
}
