import java.util.Arrays;

public class Count_Words {
    public static void main(String[] args) {
        
        String str="hello world this is java programming";
        long i = Arrays.stream(str.split(" ")).count();
        System.out.println("the number of count is"+i);
        
    }
    
}
