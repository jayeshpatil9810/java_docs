//how to reverse words in string in java.

public class Reverse_words {

    public static void main(String[] args) {
        
        String str="welcome to the java world";
        String splitArray[]= str.split(" ");
        for(int i=splitArray.length-1;i>=0;i--){
            System.out.println(splitArray[i]);
        }
    }
    
}
