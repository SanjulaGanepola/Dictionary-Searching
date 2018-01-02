/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsorthelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sanjula
 */
public class dictionarySearch {

    static SearchSortHelper search = new SearchSortHelper();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Array with each element being a word from the dictionary file
        String[] data = arrayOfFile("dictionary.txt");

        //Test the word "about"
        System.out.println("a) about");
        word(data, "about");
        //Test the word "header"
        System.out.println("b) header");
        word(data, "header");
        //Test the word "yours"
        System.out.println("c) yours");
        word(data, "yours");

    }

    /**
     * Read and file and create an array where each line in the file is an
     * element in the array.
     *
     * @param fileName The name of the file
     * @return The array with each line the file being an element in the array.
     */
    public static String[] arrayOfFile(String fileName) {
        //Temporary arraylist for holding the file's information
        ArrayList<String> tempInfo = new ArrayList<String>();
        //Initialize file using the given file name
        File f = new File(fileName);
        Scanner s = null;
        try {
            //Scanner for reading the file
            s = new Scanner(f);
            //Add each line as an element into the array
            while (s.hasNextLine()) {
                tempInfo.add(s.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        //Array of all he file's information
        return tempInfo.toArray(new String[tempInfo.size()]);
    }

    /**
     * Do a linear and binary search through an array given a word.
     *
     * @param data The array to search
     * @param word The word to search for
     */
    public static void word(String[] data, String word) {
        System.out.println("Linear");
        testIterations(data, word, "linear");
        System.out.println("Binary");
        testIterations(data, word, "binary");
    }

    /**
     * Run three tests with 100000,1000000, and 10000000 searches
     *
     * @param data The array to search
     * @param word The word to search for
     * @param type The type of search to conduct
     */
    public static void testIterations(String[] data, String word, String type) {
        //Run 100000 searches
        iterations(data, word, type, 100000);
        //Run 1000000 searches
        iterations(data, word, type, 1000000);
        //Run 10000000 searches
        iterations(data, word, type, 10000000);
    }

    /**
     * Search through an array a given number of times
     *
     * @param data The array to search
     * @param word The word to search for
     * @param type The type of search to conduct
     * @param iterations Number of searches to preform
     */
    public static void iterations(String[] data, String word, String type, int iterations) {
        long start;
        //Linear search
        if (type.equals("linear")) {
            //Starting time
            start = System.currentTimeMillis();
            for (int i = 0; i <= iterations; i++) {
                search.linear(data, word);
            }
        } //Binary search
        else {
            //Start Time
            start = System.currentTimeMillis();
            for (int i = 0; i <= iterations; i++) {
                search.binary(data, word);
            }
        }
        //Ending time
        long finish = System.currentTimeMillis();
        //Output results
        System.out.println(iterations + " searches: " + (finish - start));
    }
}
