package `object`

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import serialize.NodeDeserializer

@JsonDeserialize(using = NodeDeserializer::class)
abstract class Node {
}
