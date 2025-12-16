import java.util.Arrays;
import java.util.stream.IntStream;

public class SumElements {
    public static void main(String[] args) {
        
        int[] arr={1,2,3,4,5};
        int sum=Arrays.stream(arr).sum();
        System.out.println("sum of the numbers is"+sum);

        //second method
        int sum1=IntStream.of(arr).sum();
        System.out.println(sum1);

        //third method
        int sum2=Arrays.stream(arr).reduce((x,y)->x+y).getAsInt();
        System.out.println(sum2);

        //fourth method
        int sum3=Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        System.out.println(sum3);
    }
    
}
