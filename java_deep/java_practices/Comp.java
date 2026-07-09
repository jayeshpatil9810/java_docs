import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Comp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Character.compare(o1.charAt(0), o2.charAt(0));

    }


    public static void main(String[] args) {

        List<String> list = Arrays.asList("banana", "apple", "chanana");
        list.sort(new Comp());
        System.out.println(list);
    

    }


}    

