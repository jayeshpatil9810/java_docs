import java.util.Arrays;
import java.util.List;
import java.util.Map; // Explicitly import java.util.Map
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Product {

    private String Name;
    private String category;

    // 1. ADDED CONSTRUCTOR: Needed to use "new Product(name, category)"
    public Product(String Name, String category) {
        this.Name = Name;
        this.category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // 2. ADDED TOSTRING: Needed so the print statement displays readable text instead of hashcodes
    @Override
    public String toString() {
        return "Product{Name='" + Name + "', category='" + category + "'}";
    }

    // 3. MOVED BRACKET: The main method must be INSIDE the Product class brackets
    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> findFirstthreeevenSquare = numbers.stream()
               .filter(number -> number % 2 == 0)
               .limit(3)
               .map(x -> x * x)
               .collect(Collectors.toList());
        System.out.println(findFirstthreeevenSquare);

        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics"),
            new Product("Shirt", "Clothing"),
            new Product("Phone", "Electronics"), // Fixed your typo "Electornics"
            new Product("Jeans", "Clothing")
        );
        Stream<Product> stream = products.stream();

        Map<String, List<Product>> categoryMap = stream.collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(categoryMap);


        //string with stream
        String s1 = "jayesh patil";
        IntStream stream1 = s1.chars();
        Map<Character, Long> countings = stream1.mapToObj((x)-> (char)x ).
        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countings);
    }
}
