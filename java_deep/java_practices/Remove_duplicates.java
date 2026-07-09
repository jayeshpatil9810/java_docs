//write program to remove duplicates from string array.

import java.util.HashSet;
import java.util.Set;

public class Remove_duplicates {
    public static void main(String[] args) {

    public static String removeDuplicate(String str){
        Set<Character> set=new HashSet<>();
        StringBuffer bf=new StringBuffer();

        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                bf.append(c);
            }

        }
      return bf.toString();
    }
    }