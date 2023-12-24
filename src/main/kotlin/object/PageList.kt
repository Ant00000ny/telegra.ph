package `object`

import com.fasterxml.jackson.annotation.JsonProperty

data class PageList(
    @field:JsonProperty("total_count")
    val totalCount: Int?,
    @field:JsonProperty("pages")
    val pages: List<Page>?,
)
