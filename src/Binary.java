import java.util.LinkedList;

public class Binary {
    // returns string value of binary
    public static String getBinary(int num) {
        if(num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int temp = num;

        if(num < 0) {
            temp *= -1;
        }

        while(temp > 0) {
            sb.append(temp % 2);
            temp /= 2;
        }

        if(num < 0) {
            sb.append(" 1");
        }
        return sb.reverse().toString(); // stringbuilder reverse() I think is O(n/2), O(n)
    }

    public static boolean isBinary(String binary) {
        if(binary.isEmpty()) {
            return false;
        }
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    public static int getDecimal(String binary) {
        // ignore leading 0's
        int start = 0;
        while(binary.charAt(start) == '0') {
            start++;
        }
        binary = binary.substring(start);

        int num = 0;
        // reads binary backwards, adding 2^power
        for(int i = binary.length()-1, power = 0; i >= 0; i--, power++) {
            if(binary.charAt(i) == '1') {
                num += Math.pow(2, power);
            }
        }
        return num;
    }
}
