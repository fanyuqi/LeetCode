//相比较于Solution2，自定义一个类的比较器，而不是在类中覆盖 ccompareTo()方法，这样可以在某些Java类中，也可以进行自定义比较
import java.util.*;

public class Solution3 {

    private class Freq{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }
//  自定义一个比较器，定义Freq类如何进行比较
    private class FreqComparator implements Comparator<Freq>{ //创建一个比较器，传给优先队列进行比较

        @Override
        public int compare(Freq a, Freq b){
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
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

