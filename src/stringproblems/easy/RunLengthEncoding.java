package src.stringproblems.easy;

public class RunLengthEncoding {

    public static void main(String[] args) {

        System.out.println(encode("aabbcffgd"));
    }

    public static String encode(String str) {

        if (str.length() == 1) return str + 1;

        StringBuilder sb = new StringBuilder();
        int counter = 1;
        char currChar = ' ';
        char nextChar = ' ';

        for (int i = 0; i < str.length() - 1; i++) {
            currChar = str.charAt(i);
            nextChar = str.charAt(i + 1);
            if (currChar == nextChar) counter++;
            else {
                sb.append(currChar).append(counter);
                counter = 1;
            }
        }

        sb.append(nextChar).append(counter);

        return sb.toString();
    }
}
