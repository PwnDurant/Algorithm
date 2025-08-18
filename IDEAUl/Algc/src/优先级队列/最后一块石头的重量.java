package 优先级队列;

import java.util.PriorityQueue;

public class 最后一块石头的重量 {

    public int lastStoneWeight(int[] stones){
        // 创建一个大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> (b - a));
        // 把所有的石头放进堆中
        for (int stone : stones) {
            heap.offer(stone);
        }
        // 模拟
        while(heap.size() > 1){
            int a = heap.poll();
            int b = heap.poll();
            if(a > b) heap.offer(a - b);
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }


    public static void main(String[] args) {


    }

}
