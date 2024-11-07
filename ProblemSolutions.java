/******************************************************************
 *
 *   Mohammed Khursiwala / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for (int i = 0; i < list1.length; i++) {
            hashTable.put(list1[i], 0);
        }

        int count = 0;
        for (int i = 0; i < list2.length; i++) {
            if (hashTable.containsKey(list2[i])) {
                hashTable.put(list2[i], count++);
            }
        }

        return count == list2.length;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
               if (array[i] > array[j]) {
                   int temp = array[j];
                   array[j] = array[i];
                   array[i] = temp;
               }
            }
        }

        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            count++;
            if (count == k) {
                return array[i];
            }
        }

        return 0;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            list.add(array2[i]);
        }
        Collections.sort(list);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}