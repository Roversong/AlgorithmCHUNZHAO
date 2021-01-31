// 思路一 递归
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }        
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}


// 思路二 迭代
// 本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈。
// 从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
// 在这个算法中，输出到最终结果的顺序按照 Top->Bottom 和 Left->Right，符合前序遍历的顺序。
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollLast();
      output.add(node.val);
      if (node.right != null) {
        stack.add(node.right);
      }
      if (node.left != null) {
        stack.add(node.left);
      }
    }
    return output;
  }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) return res;
        
        stack.add(root);
        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) 
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        
        return res;
    }
}