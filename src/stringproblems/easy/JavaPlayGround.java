package playground;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.Objects.hash;
import static java.util.stream.Collectors.toSet;

public class JavaPlayGround {
    public static void main(String[] args) {

        //input
        List<String> inputs = new ArrayList<>();
        inputs.add("Is it Sunny");
        inputs.add("Sunny it is");
        inputs.add("Hello World");
        inputs.add("hello world");
        inputs.add("Sunny it is");

        /**
         * Iterating it backwards because, last seen string is needed.
         * When unique.add() is called, since it's a set, it will check if the given statement is already present or not.
         * To check that, first hasCode() will be called & then equals().
         * After, the loop completion unique, will have only those statements which are different & if 2 or more are same.
         * then only, the last seen will present.
         */
        Set<Statement> unique = new LinkedHashSet<>();
        for (int i = inputs.size() - 1; i >= 0; i--) unique.add(new Statement(inputs.get(i)));

        //output
        for (Statement i : unique) System.out.println(i.getStatement());
    }
}

/**
 * Class holds the logic to check if 2 statements are same or not
 */
class Statement {

    private final String statement;

    public Statement(String statement) {
        this.statement = statement;
    }

    /**
     * Overriding hashCode() & equals() method, to accommodate our requirements of equality
     *
     * @param otherStatement other statement
     * @return true, if statements are of same length & both statement has same words
     */
    @Override
    public boolean equals(Object otherStatement) {
        if (this == otherStatement) return true;
        if (!(otherStatement instanceof Statement)) return false;
        Statement statement = (Statement) otherStatement;

        return hasSameLength(statement) && hasSameWords(statement);
    }

    private boolean hasSameLength(Statement statement) {
        return this.statement.length() == statement.statement.length();
    }

    /**
     * @param otherStatement other Statement
     * @return true is both statements have same list of words
     * <p>
     * splitting this statement -> adding it to set (collection which holds unique values),
     * then splitting otherStatement -> checking if that word is present or not, if not return false
     */
    private boolean hasSameWords(Statement otherStatement) {
        return stream(otherStatement.statement.split(" "))
                .allMatch(word -> stream(this.statement.split(" "))
                        .map(String::toLowerCase)
                        .collect(toSet())
                        .contains(word.toLowerCase())
                );
    }

    /**
     * @return int
     * calculating hashcode after removing any duplicate word
     */
    @Override
    public int hashCode() {
        return hash(join("", stream(statement.split(" "))
                .map(String::toLowerCase)
                .collect(toSet()))
        );
    }

    public String getStatement() {
        return this.statement;
    }
}
