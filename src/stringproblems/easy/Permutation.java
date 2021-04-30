package src.stringproblems.easy;

public class Permutation {

    public static void main(String[] args) {

        permutation("ABC");

    }

    private static void permutation(String s) {

        perm("", s);
    }

    private static void perm(String perm, String inputWord) {

        if (inputWord.isEmpty()) System.out.println(perm + inputWord);
        else {
            for (int i = 0; i < inputWord.length(); i++) {
                perm(perm + inputWord.charAt(i),
                        inputWord.substring(0, i) + inputWord.substring(i + 1));
            }
        }
    }
}
