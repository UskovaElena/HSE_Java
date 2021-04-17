import java.util.Map;
import java.util.HashMap;

public class LettersCounter {
    private String data;

    public LettersCounter(String data) {
        this.data = data;
    }
    public Map<Character, Integer> count() {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] data_arr = this.data.toCharArray();
        for (char c : alphabet) {
            int num = 0;
            for (char value : data_arr) {
                if (value == c || value == Character.toUpperCase(c)) {
                    num++;
                }
            }
            map.put(c, num);
        }
        return map;
    }
}
