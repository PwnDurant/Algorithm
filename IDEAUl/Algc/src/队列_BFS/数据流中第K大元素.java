package 队列_BFS;


import java.util.PriorityQueue;

public class 数据流中第K大元素 {

     PriorityQueue<Integer> heap;
     int _k;

    public void KthLargest(int k, int[] nums) {
        _k = k;
        heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if(heap.size() < _k){
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.offer(val);
        if(heap.size() > _k){
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {


    }

}
