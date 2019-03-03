import java.util.*;

public class Que02 {
    public static List<List<Integer>> sumZero(int[] arr){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        TreeSet<String> set = new TreeSet<String>();
        int n =arr.length;
        for(int i=0;i<n-1;i++){
            int l = i+1;
            int r = n-1;
            int temp = arr[i];
            while(l < r){
                List<Integer> tuple = new ArrayList<Integer>();
                int sum = temp+arr[l]+arr[r];
                if(sum==0){
                    String str = temp + ": " + arr[l] + ":" + arr[r];
                    if(!set.contains(str)){
                        tuple.add(temp);
                        tuple.add(arr[l]);
                        tuple.add(arr[r]);
                        res.add(tuple);
                        set.add(str);
                    }
                    l++;
                    r--;
                }
                else if (sum<0) l++;
                else r--;
            }
        }
        return res;
    }
}
