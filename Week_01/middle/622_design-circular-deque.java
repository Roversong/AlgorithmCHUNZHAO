// 方法一 数组
// 对于一个固定大小的数组，任何位置都可以是队首，只要知道队列长度，就可以根据下面公式计算出队尾位置：
// tailIndex = headIndex + count - 1) mod capacity
// 其中 capacity 是数组长度，count 是队列长度，headIndex 和 tailIndex 分别是队首 head 和队尾 tail 索引。下图展示了使用数组实现循环的队列的例子。
// 复杂度分析
// • 时间复杂度：O(1)。该数据结构中，所有方法都具有恒定的时间复杂度。
// • 空间复杂度：O(N)，其中 N 是队列的预分配容量。循环队列的整个生命周期中，都持有该预分配的空间。

class MyCircularQueue {

    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;
  
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }
  
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.count == this.capacity)
            return false;
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }
  
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.count == 0)
            return false;
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count -= 1;
        return true;
    }
  
    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0)
            return -1;
        return this.queue[this.headIndex];
    }
  
    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0)
            return -1;
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }
  
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.count == 0);
    }
  
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.count == this.capacity);
    }
  }