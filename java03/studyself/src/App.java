import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>(Map.of("null", 1));
        System.out.println(map.get("null"));
        System.out.println(map.getOrDefault("null",3));
        
    }
}
