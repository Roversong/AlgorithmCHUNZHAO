// 思路一 广度优先搜索（队列）
// 我们要构造一个 sub-lists 列表，其中每个 sub-list 是树中一行的值。行应该按从上到下的顺序排列。
// 因为我们从根节点开始遍历树，然后向下搜索最接近根节点的节点，这是广度优先搜索。我们使用队列来进行广度优先搜索，队列具有先进先出的特性。
// 在这里使用栈是错误的选择，栈应用于深度优先搜索。
// 让我们在树上使用基于队列的遍历算法，看看它的作用。这是你应该记住的一个基本算法。
List<Integer> values = new ArrayList<>();
Queue<Node> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
    Node nextNode = queue.remove();
    values.add(nextNode.val);
    for (Node child : nextNode.children) {
        queue.add(child);
    }
}

// 复杂度分析
// • 时间复杂度：O(n)。n 指的是节点的数量。
// • 空间复杂度：O(n)。
class Solution {
    public List<List<Integer>> levelOrder(Node root) {      
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
}


// 还有一个简化的广度优先搜索，有时间看看。。
// 思路二 递归
// 我们可以使用递归来解决这个问题，通常我们不能使用递归进行广度优先搜索。这是因为广度优先搜索基于队列，而递归运行时使用堆栈，适合深度优先搜索。但是在本题中，我们可以以不同的顺序添加到最终列表中，只要我们知道节点在哪一层并确保在那一层的列表顺序正确就可以了。
// 复杂度分析
// 时间复杂度：O(n)。n 指的是节点的数量
// 空间复杂度：正常情况 O(logn)，最坏情况 O(n)。运行时在堆栈上的空间。
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }
    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
}