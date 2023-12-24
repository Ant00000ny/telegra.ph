package method

import com.fasterxml.jackson.annotation.JsonProperty

data class GetAccountInfo(
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("fields")
    val fields: List<String>,
) : Method {
    override fun getUrlPath() = "getAccountInfo"
}
