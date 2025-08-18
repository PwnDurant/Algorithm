package 队列_BFS;


import java.util.*;

public class 前K个高频单词 {

    public List<String> topKFrequent(String[] words, int k) {
        // 统计一卡每个单词出现的频率
        Map<String,Integer> hash = new HashMap<>();
        for (String word : words) {
            hash.put(word,hash.getOrDefault(word,0) + 1);
        }

        // 创建一个大小为 k 的堆
        PriorityQueue<Pair<String,Integer>> heap = new PriorityQueue<>(
                (a,b) -> {
                    if (a.getValue().equals(b.getValue())){
                        return b.getKey().compareTo(a.getKey());
                    }// 频次相同的时候，字典序按照大根堆方式排列
                    return a.getValue() - b.getValue();
                }
        );

        // TopK 的主逻辑
        for (Map.Entry<String, Integer> e : hash.entrySet()) {
            heap.offer(new Pair<>(e.getKey(),e.getValue()));
            if(heap.size() > k){
                heap.poll();
            }
        }

        // 提取结果
        List<String> ret = new ArrayList<>();
        while(!heap.isEmpty()){
            ret.add(heap.poll().getKey());
        }

        // 逆序数组
        Collections.reverse(ret);
        return ret;

    }

    public static void main(String[] args) {

    }

}

