package jv.leet.list

import java.util.*


/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 解题关键：
 * <p>
 * 1 递归
 * <p>
 *
 * <p>
 * 2 迭代
 * <p>
 * 两两一组，创建一个 dummyHead ,指向每组的第1个node， 交换 两个node，并将 dummyHead.next 指向 node2的next
 */
class SwapNodesInPairs {

    companion object {

        fun swapNode(head: ListNode?): ListNode? {

            ListNode.printNode(head)
            //
            var dummyHead = ListNode()
            dummyHead.next = head
            var temp = dummyHead
            // 设置 terminal
            while (temp.next != null && temp.next?.next != null) {

                // 获取 node1 node2
                var node1 = temp.next;
                var node2 = temp.next?.next
                // handle current level
                temp.next = node2
                node1?.next = node2?.next
                node2?.next = node1
                // jump next level, reset clause
                if (node1 != null) {
                    temp = node1
                }
            }
            ListNode.printNode(dummyHead.next)
            return dummyHead.next

        }
    }

}

fun main() {

    var node1 = ListNode()
    var node2 = ListNode(node1)
    var node3 = ListNode(node2)
    var nodeHead = ListNode(node3)
    SwapNodesInPairs.swapNode(nodeHead)

}