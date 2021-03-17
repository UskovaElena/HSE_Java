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
        for(int i = 0; i < alphabet.length; i++) {
            String c = Character.toString(alphabet[i]);
            char C_ = Character.toUpperCase(alphabet[i]);
            String C = Character.toString(C_);
            int len = this.data.length();
            this.data = this.data.replaceAll(c, "");
            int newLen = this.data.length();
            this.data = this.data.replaceAll(C, "");
            int newLen2 = this.data.length();
            int num = len - newLen2;
            map.put(alphabet[i], num);
        }
        return map;
    }
}
