package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.PageList
import `object`.TelegraphResponse
import util.TELEGRAPH_API_BASE_URL
import util.objectMapper

data class GetPageList(
    @field:JsonProperty("access_token")
    var accessToken: String? = null,
    @field:JsonProperty("offset")
    var offset: Int? = null,
    @field:JsonProperty("limit")
    var limit: Int? = null,
) : Method<PageList> {
    override fun urlPath() = "${TELEGRAPH_API_BASE_URL}getPageList"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<PageList> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<PageList>>() {})
    }
}
