//使用Java 默认的 优先队列。Java中默认的优先队列 ，底层实现 为最小堆
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
public class Solution2 {
    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){ //最小堆，
            if(this.freq < another.freq)//需要取出频次最低的元素，最终留下的都是频次高的值
                return -1;
            else if(this.freq > another.freq)
                return  1;
            else
                return 0;
        }
    }

    //映射TreeMap中存的是 类型为Freq 的元素
    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k) //优先队列不足k个元素
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){//当前遍历到的元素的频次高于优先队列队首元素的频次（优先队列队首是优先级最高，最先出队，频次最低的元素）
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}


