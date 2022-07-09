import java.util.HashMap;

public class Hex {

    // remainder corresponds to key
    private static final String[] key = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    private static final HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
    }};

    public static String getHex(int num) {
        if(num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int temp = num;

        if(num < 0) {
            temp *= -1;
        }

        while(temp > 0) {
            sb.append(key[temp%16]);    // O(log base 16(n)), n being how big the number is
            temp /= 16;
        }

        if(num < 0) {
            sb.append(" 1");
        }
        return sb.reverse().toString();
    }

    public static boolean isHex(String hex) {
        if(hex.isEmpty()) {
            return false;
        }
        hex = hex.toUpperCase();
        for(int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            if(!Character.isDigit(c) && !(c >= 'A' && c <= 'F')) {
                return false;
            }
        }
        return true;
    }

    // TODO: check if num is too large/small to be int type, need to implement for binary too
    public static int getDecimal(String hex) {
        int start = 0;
        while(hex.charAt(start) == '0') {
            start++;
        }
        hex = hex.substring(start);

        int num = 0;
        hex = hex.toUpperCase();
        // reads binary backwards, adding 2^power
        for(int i = hex.length()-1, power = 0; i >= 0; i--, power++) {
            char c;
            if((c=hex.charAt(i)) > '0') {
                num += map.get(c) * Math.pow(16, power);
            }
        }
        return num;
    }

}
