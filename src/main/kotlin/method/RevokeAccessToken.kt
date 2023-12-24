package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Account
import util.objectMapper

data class RevokeAccessToken(
    @field:JsonProperty("access_token")
    val accessToken: String,
) : Method<Account> {
    override fun urlPath() = "revokeAccessToken"
    override fun deserializeResponse(response: String): Account {
        return objectMapper.readValue(response, Account::class.java)
    }
}
