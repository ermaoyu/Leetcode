package leetcode;

public class FindMedianSortedArrays {
    /**
     *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
     * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
     * 你可以假设 nums1 和 nums2 不同时为空。
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 中位数是 2.0
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1 == null|| nums1.length == 0 ){
          int index = nums2.length;
          if (((index)&1)==1){
              double rs1 = nums2[(index ) / 2];
              double rs2 = nums2[((index ) / 2)-1];
              return (rs1 + rs2)/2;
          }else {
              return (double) nums2[(nums2.length - 1) / 2];
          }
      }
      if (nums2 == null|| nums2.length == 0 ){
          int index = nums1.length;
          if (((index)&1)==1){
              double rs1 = nums1[(index ) / 2];
              double rs2 = nums1[((index ) / 2)-1];
              return (rs1 + rs2)/2;
          }else {
              return nums1[(nums1.length - 1)/2];
          }

      }
      if (nums1.length == nums2.length){
          return getMid(nums1,0,nums1.length -1 ,nums2,0,nums2.length -1);
      }
      int[] shorts = nums1.length < nums2.length ? nums1 : nums2;
      int[] longs = nums1.length > nums2.length ? nums1 : nums2;
      int s = shorts.length ;
      int l = longs.length ;
      int k = 0;
      if (((l + s) & 1) == 1){
          k = ((l+s)/2)+1;
      }else {
          k = (l + s) / 2;
      }
      //只可能是第二种情况
        if(longs[k - s - 1] >= shorts[s - 1]){
            return (double) longs[k - s - 1];
        }
        return getMid(shorts,0,s -1 ,longs, k  -s,l - 1);
    }

    public static double getMid(int[] shorts,int s1,int e1,int[] longs,int s2,int e2){
        int mid1 = 0;
        int mid2 = 0;
        int index = 0;
        int len = shorts.length + longs.length;
        while ( s1 < e1){
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            index = ((e1 - s1 + 1) & 1)^1;
            if (shorts[mid1] > longs[mid2]){
                e1 = mid1;
                s2 = mid2 + index;
            }else if (shorts[mid1] < longs[mid2]){
                s1 = mid1 + index;
                e2 = mid2;
            }else {
                return (double) shorts[mid1];
            }
        }
        double rs1 = (double) shorts[s1];
        double rs2 = (double) longs[s2];
        double res3 = 0;
        if ((len&1)==0){
            res3 = (rs1+rs2)/2;
        }else {
            res3 = Math.min(rs1,rs2);
        }
        return res3;
    }

//    public static void main(String[] args) {
//        int[] a = {1,2};
//        int[] b = {-1,3};
//        System.out.println(findMedianSortedArrays(a,b));
//    }
}
