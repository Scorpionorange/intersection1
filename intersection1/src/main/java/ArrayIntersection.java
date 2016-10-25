import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ScorpionOrange on 2016/10/23.
 */
public class ArrayIntersection {
    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution s = new Solution();
        int[] out = s.intersection(nums1, nums2);

        for(int i : out){
            System.out.print(i + ", ");
        }
    }
}

class Solution{
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */

    public int[] intersection(int[] nums1, int[] nums2){
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> A = new ArrayList<Integer>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length ){
            if(nums1[i] == nums2[j]){
                A.add(nums1[i]);
                i++;
                j++;

            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
            int tmpi = i;
            int tmpj = j;
            // 去重
            while(i+1<nums1.length && nums1[i]==nums1[i+1]) i++;
            while(j+1<nums2.length && nums2[j]==nums2[j+1]) j++;
            // 没有重复，按照上面更新的i 和 j
            if(tmpi<nums1.length && tmpi ==i){
                i= tmpi;
            }
            if(tmpj<nums2.length && tmpj ==j){
                j = tmpj;
            }
        }
        int[] res = new int[A.size()];
        for( i=0;i<A.size();i++){
            res[i] = (int)A.get(i);
        }
        return res;
    }
}
