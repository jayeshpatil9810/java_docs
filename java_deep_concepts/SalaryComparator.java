import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SalaryComparator implements Comparator<Employee>{
        
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.salary, o2.salary);

        }
 
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(3, "jay", 5000));
        list.add(new Employee(1,"amit", 7000));
        list.add(new Employee(2, "rahul", 6000));
        Collections.sort(list, new SalaryComparator());

        

    }
}
