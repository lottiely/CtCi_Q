/*
 *      1.1 IsUnique: Implement an algorithm to determine if a string has all unique characters.
 *      What if you cannot use additional data structures?
 *
 */
import java.util.Arrays;

public class IsUnique {

    //my solution
    /*
     *  Sort the string and then check the neighbors to see if they match.
     */
    public static void isUnique(String input){
        if(input.length() > 128){
            System.out.println("false");
            return;
        }

        input = input.toLowerCase();
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        for(int i = 1; i < arr.length -1; i++){
            if(arr[i] == arr[i-1]){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    /*
     *  Book solution: Creates a boolean array of size 128. Using the character's ASCII integer as the array index,
     *  the boolean is set to true. If a true is found, there the character was already found previously.
     *
     */
    public static boolean isUniqueChars(String str){
        if(str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){//Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String args[]){
        String uniqueString = "String"; //true
        String notUnique = "Twinsies";  //false

        isUnique(uniqueString);
        isUnique(notUnique);
    }
}
