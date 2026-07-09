import java.util.Arrays;

public class Find_Median {
    public static void main(String[] args) {

        int[] array={12,44,33,89,56};
        double findM= findMedian(array);
        System.out.println("the element is "+ findM);
    }

    public static double findMedian(int[] array){
        Arrays.sort(array);
        int n = array.length;

        if(n % 2 == 0){
            return (array[n/2] + array[n/2 - 1]) / 2.0;
        } else {
            return array[n/2];
        }
    }
}
