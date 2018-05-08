/*
 *  1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 *  A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement
 *  of letters. The palindrome does not need to be limited to just dictionary words.
 *
 */

public class PalindromePermutation {
    public static boolean output = false;
    /*
     *  Takes a char array and returns true if it is a palindrome
     */
    public static boolean isPalindrome(char[] input){
        for(int i = 0; i < input.length/2; i++){
            if(input[i] != input[input.length-i-1])
                return false;
        }
        return true;
    }

    public static boolean checkPermutations(String input){
        permutation("", input);
        return output;
    }

    public static void permutation(String prefix, String remaining){
        if(remaining.equals("")){
            if(isPalindrome(prefix.toCharArray())) {
                output=true;
            }
        }
            //System.out.println(prefix);

        String lostSoul = ""; //prefix: c; rem: at
        for(int i = 0; i < remaining.length(); i++){
            permutation(prefix + remaining.charAt(i), remaining.substring(i+1,remaining.length()) + lostSoul);
            lostSoul = lostSoul + remaining.charAt(i);
        }
    }

    /*
     *  Will output to console the boolean value given as input
     */
    public static void test(boolean input){
        if(input)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static void main(String[] args){
        //palindrome tests
        String test1 = "tacocat"; //true
        String test2 = "notPalindrome"; //false;

        //test(isPalindrome(test1.toLowerCase().toCharArray()));
        //test(isPalindrome(test2.toLowerCase().toCharArray()));
        //checkPermutations("tacocat");
        test(checkPermutations("tacocat"));
    }
}
