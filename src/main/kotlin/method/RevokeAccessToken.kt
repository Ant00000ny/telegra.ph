package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.Account
import `object`.TelegraphResponse
import objectMapper

data class RevokeAccessToken(
    @field:JsonProperty("access_token")
    val accessToken: String,
) : Method<Account> {
    override fun urlPath() = "revokeAccessToken"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<Account> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<Account>>() {})
    }
}
