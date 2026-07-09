//how to find non-repeated characters in a string in java
//steps to resolev
//1. it first get character array from the givem string
//2.build linked hashmap with character as key and their count as value.if key already exist increment the value store 1 for that corresponding key.
//3. in the next step it loop through linkedHashmap to find an entry with value 1.thats your first non-repeated character,because linkedhashmap,maintain insertion order and we iterate through character array from beginning to end.

import java.util.LinkedHashMap;
import java.util.Map;

public class Non_repeated_characters {
    public static void main(String[] args) {

        char c=getFirstNonRepeatedChracter("aabbddef");
        System.out.println("Non repeated character="+c);
        
    }

    public static char getFirstNonRepeatedChracter(String str){
        Map<Character,Integer> CountMap=new LinkedHashMap<Character,Integer>();
        for(char ch:str.toCharArray()){ 
            CountMap.put(ch, CountMap.containsKey(ch)?CountMap.get(ch)+1:1);
        }
        for(java.util.Map.Entry<Character,Integer> entry:CountMap.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        throw new RuntimeException("no non-repeated character found");
        }
    }




    

