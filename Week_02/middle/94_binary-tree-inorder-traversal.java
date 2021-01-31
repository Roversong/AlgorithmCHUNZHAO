// 思路一 递归
// 复杂度分析
// 时间复杂度：O(n)。递归函数 T(n) =2⋅T(n/2)+1。
// 空间复杂度：最坏情况下需要空间O(n)，平均情况为O(logn)。
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}


// 思路二 迭代
// 递归实现时，是函数自己调用自己，一层层的嵌套下去，操作系统/虚拟机自动帮我们用栈来保存了每个调用的函数，现在我们需要自己模拟这样的调用过程。递归的调用过程是不断往左边走，当左边走不下去了，就打印节点，并转向右边，然后右边继续这个过程。我们在迭代实现时，就可以用栈来模拟上面的调用过程。
// 复杂度分析
// 时间复杂度:O(n)
// 空间复杂度:O(h)，h是树的高度，也是O(logn)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size()>0 || root!=null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if(root!=null) {
                stack.add(root);
                root = root.left;
            //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
            //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }
}