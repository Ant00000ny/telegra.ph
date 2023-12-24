package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class PageViews(
    @field:JsonProperty("views")
    val views: Int?,
)
