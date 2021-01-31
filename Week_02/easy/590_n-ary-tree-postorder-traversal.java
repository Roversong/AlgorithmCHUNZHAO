// 思路一 递归
public List<Integer> preorder1(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    helper(root, res);
    return res;
}
private void helper(Node root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    for (Node node : root.children) {
        helper(node, res);
    }
}


// 思路二 迭代
// 我们使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点。我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点。随后每次我们从栈顶取出一个节点 u，它是我们当前遍历到的节点，并把 u 的所有子节点逆序推入栈中。例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v3, v2, v1，这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。
// 复杂度分析
// • 时间复杂度：时间复杂度：O(M)，其中 M 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。
// • 空间复杂度：O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。将根节点推出栈后，需要将这些节点都放入栈，共有 M−1 个节点，因此栈的大小为 O(M)
class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}