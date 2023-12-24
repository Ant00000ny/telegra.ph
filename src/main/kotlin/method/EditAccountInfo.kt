package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.Account
import `object`.TelegraphResponse
import util.TELEGRAPH_API_BASE_URL
import util.objectMapper

data class EditAccountInfo(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("short_name")
    var shortName: String? = null,
    @field:JsonProperty("author_name")
    var authorName: String? = null,
    @field:JsonProperty("author_url")
    var authorUrl: String? = null,
) : Method<Account> {
    override fun urlPath() = "${TELEGRAPH_API_BASE_URL}editAccountInfo"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<Account> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<Account>>() {})
    }
}
