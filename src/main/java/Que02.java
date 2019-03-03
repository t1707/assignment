/**
  * To check 3Sum brute force worst case time complexity would result in O(n^3),
  * so we try to optimize that. First ,we sort the array(O(nlongn)).
  * For every element(one loop here), we take two 
  * pointers, one from start and one from end(one array traverse here) and 
  * caculate the sum of all three valuse. If sum is equal to zero then we
  * store the tuple in res and to keep only unique results, we put this tuple
  * into a set. If our sum is less than zero then increment the left pointer(sorting the
  * array helps here) and if it's greater than zero then we reduce the right pointer.
  *
  * Time complexity: O(n^2)
  * Space complexity: O(n) for extra set
*/


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
