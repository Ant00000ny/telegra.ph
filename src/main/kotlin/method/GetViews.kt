package method

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import `object`.PageViews
import `object`.TelegraphResponse
import util.BASE_URL
import util.objectMapper

data class GetViews(
    @field:JsonProperty("path")
    var path: String? = null,
    @field:JsonProperty("year")
    var year: Int? = null,
    @field:JsonProperty("month")
    var month: Int? = null,
    @field:JsonProperty("day")
    var day: Int? = null,
    @field:JsonProperty("hour")
    var hour: Int? = null,
) : Method<PageViews> {
    override fun urlPath() = "${BASE_URL}getViews"
    override fun deserializeResponse(responseJson: String): TelegraphResponse<PageViews> {
        return objectMapper.readValue(responseJson, object : TypeReference<TelegraphResponse<PageViews>>() {})
    }
}
