import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {


        List<String> names = Arrays.asList(
        "Java",
        "SpringBoot",
        "Microservices",
        "API",
        "Hibernate"
    );

    String largest= names.stream().max(Comparator.comparingInt(String::length)).orElseThrow(null);
    System.out.println("the largst length is :"+largest);

    

        String s="aabbcddee";
        Map<Character, Integer> freq=new LinkedHashMap<>();
        for(char c:s.toCharArray()){
        freq.put(c, freq.getOrDefault(c,0)+1);
}
        for(Map.Entry<Character,Integer> entry: freq.entrySet()){
        if(entry.getValue()==1){
        System.out.println(entry.getKey());
        break;
        }
        }
    }


        
        








             










        // int[] arr = {10, 45, 23, 67, 89};
        // int largest = Integer.MIN_VALUE;
        // int secondLargest = Integer.MIN_VALUE;

        // for (int i = 0; i < arr.length; i++) {
        //     int n = arr[i];
        //     if (n > largest) {
        //         secondLargest = largest;
        //         largest = n;
        //     } 
        //     else if (n > secondLargest && n != largest) {
        //         secondLargest = n;
        //     }
        // }
        // System.out.println(secondLargest);




        // int[] arr1 = {10, 45, 23, 67, 89};
        // int number= Arrays.stream(arr1).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElseThrow("");

        
        
        // int[] arr ={1,2,3,2,4,1,5};
        // List<Integer> list=Arrays.stream(arr).boxed().collect(Collectors.groupingBy(
        //     n->n,Collectors.counting()))
        //     .entrySet()
        //     .stream()
        //     .filter(e->e.getValue()>1)
        //     .map(Map.Entry::getKey)
        //     .collect(Collectors.toList());

        //     System.out.println("the duplicate element is"+list);

        //List<Integer> i= Arrays.stream(arr).distinct().collect(Collectors.toList()); 







    }
    
// }
