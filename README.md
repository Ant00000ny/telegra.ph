## telegra.ph

This is a Kotlin version of [telegra.ph](https://telegra.ph/) API wrapper, based
on [telegraph](https://github.com/rubenlagus/Telegraph).

### Usage

```kotlin
fun main() {
    // Create account
    val account: Account = CreateAccount()
        .apply {
            authorName = "TelegraphApi"
            shortName = "shortName"
        }
        .sendRequest()

    // Edit account
    var editedAccount: Account = EditAccountInfo(account.accessToken)
        .apply {
            authorName = "Default user"
            shortName = "Short name"
        }
        .sendRequest()

    // Get account info
    editedAccount = GetAccountInfo(account.accessToken)
        .sendRequest()

    val contentNode: Node = TextNode("My content")
    val content: MutableList<Node> = ArrayList()
    content.add(contentNode)

    // Create new account
    var page: Page = CreatePage(account.accessToken, "My title", content)
        .apply {
            authorName = "Random author"
            returnContent = true
        }
        .sendRequest()

    // Get page
    page = GetPage(page.path)
        .apply {
            returnContent = true
        }
        .sendRequest()

    val tagNode: Node = ElementNode("p", mutableMapOf(), content)
    val tagContent: MutableList<Node> = ArrayList()
    tagContent.add(tagNode)

    // Edit page
    val editedPage: Page = EditPage(account.accessToken, page.path, page.title, tagContent)
        .apply {
            authorName = "New Author"
        }
        .sendRequest()

    // Get page list
    val pageList: PageList = GetPageList(account.accessToken)
        .apply {
            limit = 10
        }
        .sendRequest()

    // Get page view
    val views: PageViews = GetViews(page.path)
        .apply {
            year = 2016
        }
        .sendRequest()

    // Revoke account token
    val revokedAccount: Account = RevokeAccessToken(account.accessToken ?: "")
        .sendRequest()
}
```
