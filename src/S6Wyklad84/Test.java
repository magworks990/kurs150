package S6Wyklad84;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("POLAND", "WARSAW");
        countries.put("RUSSIA", "MOSCOW");
        countries.put("BELARUS", "MINSK");

        for (Map.Entry<String, String> country : countries.entrySet()) {
            System.out.println("Kraj: "+country.getKey());
        }
    }
}
