package src;

public class App {

    public static void main(String[] args) {

        int numberOfDisks = 3;
        String stepsToSolve = TowerOfHanoi.hanoi(numberOfDisks, 1, 3);
        for (String step : stepsToSolve.split(";")) System.out.println(step);
    }
}