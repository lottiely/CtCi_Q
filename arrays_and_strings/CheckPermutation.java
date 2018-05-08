/*
 *  1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */

import java.util.Arrays;

public class CheckPermutation {
    //my solution
    public static char[] convert(String str1){
        //converts strings to char arrays
        return str1.toCharArray();
    }

    public static void isPermutation(char[] arr1, char[] arr2){
        if(arr1.length != arr2.length){
            System.out.println("false");
            return;
        }

        //sort arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //check if they're equal
        if(Arrays.equals(arr1, arr2))
            System.out.println("true");
        else
            System.out.println("false");
    }

    /*
     *  Book had 2 solution. One was similar to the one I made, but was written better. Converted and sorted in one
     *  method and then checked for equality.
     */

    //solution 2
    //Check if the two strings have identical character counts

    public static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] letters = new int[128]; //assumption

        char[] s_array = s.toCharArray();
        for(char c : s_array){
            letters[c]++;
        }

        for(int i = 0; i < t.length(); i++){
            int c = (int) t.charAt(i);
            letters[c]--;
            if(letters[c] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        //test set 1: true
        String str1 = "abcde";
        String str2 = "bcdea";

        //test set 2: false
        String str3 = "abcde";
        String str4 = "abcdf";

        isPermutation(convert(str1), convert(str2));
        isPermutation(convert(str3), convert(str4));

    }
}
