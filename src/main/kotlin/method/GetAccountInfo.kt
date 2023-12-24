package method

import com.fasterxml.jackson.annotation.JsonProperty
import `object`.Account
import util.objectMapper

data class GetAccountInfo(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("fields")
    var fields: List<String>? = null,
) : Method<Account> {
    override fun urlPath() = "getAccountInfo"
    override fun deserializeResponse(response: String): Account {
        return objectMapper.readValue(response, Account::class.java)
    }
}
