//相比较于Solution4，匿名类实现后，优先队列中可以只存Integer类元素，相当于只存nums链表中的元素，
// 不存频率，但是比较时按照频率进行比较
import java.util.*;

public class Solution5 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        //使用匿名类，实现自定义比较器
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>(){
            @Override
            public int compare(Integer a , Integer b){
                return map.get(a) - map.get(b) ;
            }
        });
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(key);
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove());
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

