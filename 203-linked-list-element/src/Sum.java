public class Sum {
    /**
     * 计算arr[l...n]这个区间内所有数字的和
     * @param arr
     * @param l
     * @return
     */
    public static int sum(int[] arr , int l){
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr , l + 1);
    }

}
