// 思路一 暴力
// 暴力法：for i:0 -> n-1 {  result *= x}   O(n)
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        
        double res = 1.0;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        
        return res;
    }
}

// 思路二 递归、分治
// 分治。
// 递归模板：1.terminator  2.process (split your big problem)  3.drill down(subproblems), merge(subresult)
// 4. reverse states(大部分情况不用)
// x^n --> 2^10 : 2^5(乘自己) -> (2^2)*2（通过判断指数的奇偶性来判断是否补这个2）
// pow(x, n):
//   subproblem:  subresult = pow(x, n/2)
// merge:
//   if n % 2 == 1 { //奇数
//     result = subresult * subresult * x;
//   } else { //偶数
//     result = subresult * subresult;
//   }
// 如果n是负数，就把n变成正数，最后用1除以最后得到的结果
// 时间复杂度：O(logn)
class Solution {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}

// 思路三 牛顿迭代法
// 牛顿迭代法。

// 总结
// 1. 这里要注意的一点是，n次幂的n的范围是 [−231, 231 − 1] ，要注意n为负数时的越界问题，所以要把n先转换为长整型long，这里需要记住Java的八种基本类型，及其位数和范围。
// 2. n的正负
// 3. n的奇偶性造成的两种情况