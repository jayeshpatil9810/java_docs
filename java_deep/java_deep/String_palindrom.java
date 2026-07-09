//if original string and reverse string are same as per alphabetical order we say string is palindrome.

import java.util.Scanner;

public class String_palindrom {
    public static void main(String[] args) {
        
        String reverse="";
        System.out.println("enter the input string");
        Scanner sc=new Scanner(System.in);
        String original=sc.nextLine();
        for(int i=original.length()-1;i>=0;i--){
            reverse=reverse+original.charAt(i);
                
            }
            if (original.equals(reverse)) {
                System.out.println("the given string is palindrom");
            }
                else{
                    System.out.println("the given string is not palindrome");
                }            
            
        }
    
    
    }
    