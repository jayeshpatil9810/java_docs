public class AnagramChecker {
           
        public static boolean isAnagram(String str1, String str2){
            if(str1.length()!=str2.length()){
                return false;
            }

            String sorted1= str1.toLowerCase().chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            String sorted2= str2.toLowerCase().chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            return sorted1.equals(sorted2);
        }
 
        public static void main(String[] args) {
            
          String str1="Silent";
          String str2="Listen";
          boolean result=isAnagram(str1, str2);
          if(result){
            System.out.println("str1 and str2 is anagram");
          }else{
            System.out.println("str1 and str2 is not anagram");
        }

    }

}
        