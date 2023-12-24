package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.Account
import `object`.TelegraphResponse
import util.TELEGRAPH_API_BASE_URL
import util.objectMapper

data class GetAccountInfo(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("fields")
    var fields: List<String>? = null,
) : Method<Account> {
    override fun urlPath() = "${TELEGRAPH_API_BASE_URL}getAccountInfo"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<Account> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<Account>>() {})
    }
}
