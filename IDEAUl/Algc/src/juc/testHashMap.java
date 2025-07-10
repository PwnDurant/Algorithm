package juc;

import java.util.HashMap;

public class testHashMap {

    public static void main(String[] args) {
        int aHundredMillion = 10000000;
        HashMap<Integer, Integer> map = new HashMap<>();
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i,i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("未初始化容量，耗时：" + (s2 - s1));
        HashMap<Integer, Integer> hashMap = new HashMap<>(aHundredMillion / 2);
        long s5 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            hashMap.put(i,i);
        }
        long s6 = System.currentTimeMillis();
        System.out.println("初始化容量为 5000000，耗时：" + (s6 - s5));
        HashMap<Integer, Integer> hashMap1 = new HashMap<>(aHundredMillion);
        long s3 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            hashMap1.put(i,i);
        }
        long s4 = System.currentTimeMillis();
        System.out.println("初始化容量为 10000000，耗时：" + (s4 - s3));

    }

}
