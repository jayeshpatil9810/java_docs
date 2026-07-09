import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {       

    //occurences
    public static Map<Character, Long> charCount(String s) {
        Map<Character, Long> charcount= new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            charcount.put(c, charcount.getOrDefault(c,0L)+1);{
                for(Map.Entry<Character,Long> maps: charcount.entrySet()){
                    System.out.println(maps.getKey()+""+maps.getValue());
                }
                
            }
        }
            }
  public  static void main(String[] agrs){
    String s="jayeshpatil";

  }
}

    Map<Character,Long> maps=s1.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(
        c->c, LinkedHashMap::new, Collectors.counting()));
        


    String s = "aabbccddee";
    Map<Character, Integer> counts = new LinkedHashMap<>();{
    for(char frequency: s.toCharArray()){
        counts.put(frequency, counts.getOrDefault(frequency,0)+1);
        }
        for(Map.Entry<Character,Integer> couunt1: counts.entrySet()){
            System.out.println(couunt1.getKey()+"="+couunt1.getValue());
            }
        
                    
  }
               




    //second largest number
    int[] arr = {12,35,1,10,34,1};  
    int secondLargest = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
    System.out.println(secondLargest);

    int largest = Integer.MIN_VALUE;
    int secondlargest= Integer.MIN_VALUE;
    
    for(int i=0;i<arr.length;i++){
        int n=arr[i];
        if(n>largest){
            secondlargest=largest;
            largest=n;
        }
        else if(n> secondlargest && n!=largest){
            secondlargest=n;
    }
  }
    System.out.println(secondlargest);
  


    //saparate the even odd 
    List<Integer> EvenOdd = Arrays.asList(1,2,3,4,5,6);
    Map<Boolean,List<Integer>> partitioned = EvenOdd.stream().collect(Collectors.partitioningBy(x->x%2==0));
    System.out.println(partitioned);

    Map<Boolean, List<Integer>> EvenOddPartitioned = new HashMap<>();
    EvenOddPartitioned.put(true, new ArrayList<>());
    EvenOddPartitioned.put(false, new ArrayList<>());
    for(int x:EvenOdd){
        if(x%2==0){
            EvenOddPartitioned.get(true).add(x);
        }else{
            EvenOddPartitioned.get(false).add(x);
        }
    }
    


    //find the longest string in the array
    List<String> list = Arrays.asList("java","springboot","api","microservices");
    String longest= list.stream().max(Comparator.comparingInt(String::length)).orElse(null);
    System.out.println("the longest string is"+longest);

    String longest1="";
    for(String s:list){
        if (s.length()>longest1.length()){
            longest1=s;
        }
    }
    System.out.println(longest1);
    



    String s = "swiss";
    List<Character> s1= s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(x->x, Collectors.counting()))
    .entrySet()
    .stream()
    .filter(x->x.getValue()>1)
    .map(Map.Entry::getKey)
    .collect(Collectors.toList());
    System.out.println(s1);

    //find first non repeated character.
    String occurences = "swiss";
    Map<Character, Long> result=new LinkedHashMap<>();
    for(char c: occurences.toCharArray()){
        result.put(c, result.getOrDefault(c, 0L)+1);
    }
    for(Map.Entry<Character, Long>entry: result.entrySet()){
        if(entry.getValue()==1){
            System.out.println(entry.getKey());
        }
    }


    

    //with stream
    int[] arr1 = {1,2,3,2,4,1,5};
    List<Integer> list1= Arrays.stream(arr1)
    .boxed()
    .collect(Collectors.groupingBy(n->n, Collectors.counting()))
    .entrySet()
    .stream()
    .filter(x->x.getValue()>1)
    .map(Map.Entry::getKey).
    collect(Collectors.toList());
    System.out.println("list"+list1);
  
    
    //find the duplicate elements in array.
    int[] arr2 = {1,2,3,2,4,1,5};
    Map<Integer,Integer> map= new LinkedHashMap<>();
    for(int element:arr2){
        map.merge(element, 1, Integer::sum);
    }
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        if(entry.getValue()>1){
            System.out.println(entry.getKey()+"is repeated"+entry.getValue()+"times");
    
        }
    }
}