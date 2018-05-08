/*
 *  1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 *  has sufficient space at the end to hold the additional characters, and that you are given the "true"
 *  length of the string. (Note: If implementing in Java, please use a character array so that you can
 *  perform this operation in place.)
 *
 */

public class URLify {
    //Without Googling regex: Brute force method
    public static String bruteForce(char[] input, int trueLength){
        char[] output = new char[input.length];
        int outputIndex = 0;
        for(int i = 0; i < trueLength; i++){
            if(input[i]==' '){
                output[outputIndex] = '%';
                outputIndex++;
                output[outputIndex] = '2';
                outputIndex++;
                output[outputIndex] = '0';
                outputIndex++;
            }else {
                output[outputIndex] = input[i];
                outputIndex++;
            }
        }
        return(new String(output));
    }

    public static void main(String[] args){
        String inputString = "Mr John Smith      ";
        int trueLength = 13;

        System.out.println("Input: "+ inputString);
        System.out.println(bruteForce(inputString.toCharArray(), trueLength));
    }
}
