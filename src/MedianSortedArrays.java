/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106


Follow up: The overall run time complexity should be O(log (m+n)).

 */

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int[] bigArr = {};
        int[] smallArr = {};
        int i = 0, j = 0;
        List<Integer> finalList = new ArrayList<Integer>();
        List<Integer> tempList = new ArrayList<Integer>();
        int[] nonEmptyList = {};
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        else if(nums1.length == 0 || nums2.length == 0){
            nonEmptyList = nums1.length == 0 ? nums2 : nums1;
            int mid = nonEmptyList.length/2;
            if(nonEmptyList.length % 2 == 0){
                return (nonEmptyList[mid] + nonEmptyList[mid+1])/2;
            }
            else{
                return nonEmptyList[mid];
            }
        }

        int fullSize = nums1.length + nums2.length;
        if(nums1[0] > nums2[0]){
            bigArr = nums2;
            smallArr = nums1;
        }
        else{
            bigArr = nums1;
            smallArr = nums2;
        }
        while(i < bigArr.length-1 && j < smallArr.length){
            if(bigArr[i] <= smallArr[j] && smallArr[j] <= bigArr[i+1]) {
                tempList.add(smallArr[j]);
                j++;
            }
            else {
                if(!tempList.isEmpty()) {
                    finalList.addAll(tempList);
                    tempList.clear();
                }
                    if(i == bigArr.length-2){
                        finalList.add(bigArr[i+1]);
                    }
                    i++;
                }
            }

        for(int k = 0; k < finalList.size(); k++){
            System.out.println(finalList.get(k));
        }
        if(tempList.size() != 0){
            finalList.addAll(tempList);
        }

        if(j < smallArr.length){
            while(j < smallArr.length){
                finalList.add(smallArr[j]);
                j++;
            }
        }
        System.out.println(finalList.size());
        for(int k = 0; k < finalList.size(); k++){
            System.out.println(finalList.get(k));
        }

        int mid = finalList.size()/2;
        if(finalList.size() % 2 == 0){
            return (finalList.get(mid) + finalList.get(mid+1))/2;
        }
        else{
            return finalList.get(mid);
        }
    }

    public static void main(String[] args){
        int[] a = {1,3}, b = {2};

        System.out.println(findMedianSortedArrays(a,b));
    }
}
