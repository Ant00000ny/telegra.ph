package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.Account
import `object`.TelegraphResponse
import util.BASE_URL
import util.objectMapper

data class RevokeAccessToken(
    @field:JsonProperty("access_token")
    val accessToken: String,
) : Method<Account> {
    override fun urlPath() = "${BASE_URL}revokeAccessToken"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<Account> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<Account>>() {})
    }
}
