package method

import com.fasterxml.jackson.annotation.JsonProperty

data class RevokeAccessToken(
    @field:JsonProperty("access_token")
    val accessToken: String,
) : Method {
    override fun getUrlPath() = "revokeAccessToken"
}
