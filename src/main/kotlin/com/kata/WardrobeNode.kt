package com.kata

class WardrobeNode(
    var value: Size?,
    var children: List<WardrobeNode> = listOf()
) {
    companion object {
        fun hasChildren(node: WardrobeNode) = node.children.isNotEmpty()
    }
}