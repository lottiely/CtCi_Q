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

    /*
     * Book solution
     */

    void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0, index = 0;

        //counting spaces in Mr John Smith
        //spaceCount = 2
        for(int i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2; //the length of the whole string with %20
        //if(trueLength < str.length) str[truelength] = '\0'; //End array
        for(int i = trueLength - 1; i >=0; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else{
                str[index-1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args){
        String inputString = "Mr John Smith   ";
        int trueLength = 13;

        System.out.println(inputString.length());
        //System.out.println("Input: "+ inputString);
        //System.out.println(bruteForce(inputString.toCharArray(), trueLength));
    }
}
