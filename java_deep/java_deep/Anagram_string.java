//write a java program to check two strings are anagrams are not using arrays comparison.
//both strings are same it means anagram.

import java.util.Arrays;
public class Anagram_string {

    public static void main(String[] args) {
        String str1="java";
        String str2="avaj";
        System.out.println("both the strings are anagram"+anagramCheck(str1, str2));
        

    }
    public static boolean anagramCheck(String str1,String str2){
        char[] charArrayFromString1=str1.toCharArray();
        char[] charArrayFromString2=str2.toCharArray();
        Arrays.sort(charArrayFromString1);
        Arrays.sort(charArrayFromString2);

        return Arrays.equals(charArrayFromString1,charArrayFromString2); 


    }
    
}
