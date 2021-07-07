package playground;

import java.util.*;

public class JavaPlayGround {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("Is it Sunny");
        inputs.add("Sunny it is");
        inputs.add("Hello World");
        inputs.add("hello world");
        inputs.add("Sunny it is");

        //iterating it backwards because, last seen string is needed
        Set<Input> unique = new LinkedHashSet<>();
        for (int i = inputs.size() - 1; i >= 0; i--) {
            String s = inputs.get(i);
            unique.add(new Input(s));
        }

        for (Input i : unique) System.out.println(i.getStr());
    }
}

class Input {
    private final String str;

    public Input(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object otherInput) {
        if (this == otherInput) return true;
        if (!(otherInput instanceof Input)) return false;
        Input input = (Input) otherInput;

        return hasSameWords(input);
    }

    private boolean hasSameWords(Input otherInput) {
        List<String> thisWords = new ArrayList<>();
        for (String s : this.str.split(" ")) thisWords.add(s.toLowerCase());
        List<String> otherWords = new ArrayList<>();
        for (String s : otherInput.str.split(" ")) otherWords.add(s.toLowerCase());
        thisWords.removeAll(otherWords);

        return thisWords.isEmpty();
    }

    @Override
    public int hashCode() {
        List<String> list = new ArrayList<>();
        for (String s : str.split(" ")) list.add(s.toLowerCase());
        Collections.sort(list);
        StringBuilder op = new StringBuilder();
        for (String s : list) op.append(s);
        return Objects.hash(op.toString());
    }

    public String getStr() {
        return this.str;
    }
}