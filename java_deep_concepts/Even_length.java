//write a program to print even length words in string.
//example
//hell wold
//hell-4
//world-5

import java.util.Arrays;

public class Even_length {

    public static void main(String[] args) {
        
        String str="hell world";
        for(String s:str.split(" ")){
            if(s.length()%2==0){
                System.out.println(s);

                //output will be hell because this is the even number length length is 4 and 4 is even number
            }

            //convert string to character array and sort it.
            String s1="java";
            char ch[] =s1.toCharArray();
            Arrays.sort(ch);
            String sortedstr=new String(ch);
            System.out.println(sortedstr);
                }
    }



    
}
