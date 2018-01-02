/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsorthelper;

/**
 *
 * @author 348676487
 */
public class SearchSortHelper {

    /**
     * Search for a given comparable in an array of comparables using a binary
     * algorithm.
     *
     * @param list The array of comparables to search through.
     * @param target The comparable you are looking for
     * @return The index of the array at which the comparable exists or -1 if it
     * does not exist.
     */
    public int binary(Comparable[] list, Comparable target) {
        //Minimum index to search
        int low = 0;
        //Maximum index to search
        int high = list.length;
        //Middle index of the range between min and max
        int mid = 0;
        //Loop until min and max meet
        while (low <= high) {
            //Determine the middle index
            mid = (low + high) / 2;
            //Comparable at index equals the target in search
            if (list[mid].compareTo(target) == 0) {
                //The index of the array the comparable exists at
                return mid;
            } //Comparable at index is greater than the target in search
            else if (list[mid].compareTo(target) > 0) {
                //Move the maximum to one less than the middle index
                high = mid - 1;
            } //Comparable at index is less than the target in search
            else {
                //Move the minimum to one more than the middle index
                low = mid + 1;
            }
        }
        //Target not found in array
        return -1;
    }

    /**
     * Search for a given comparable in an array of comparables using a linear
     * algorithm.
     *
     * @param list The array of comparables to search through.
     * @param target The comparable you are looking for
     * @return The index of the array at which the comparable exists or -1 if it
     * does not exist.
     */
    public int linear(Comparable[] list, Comparable target) {
        //Loop through each element in the array
        for (int i = 0; i < list.length; i++) {
            //Check if the comparable is equal to the target at that index
            if (list[i].compareTo(target) == 0) {
                //The index of the array the comparable exists at
                return i;
            }
        }
        //Target not found in array
        return -1;
    }
}
