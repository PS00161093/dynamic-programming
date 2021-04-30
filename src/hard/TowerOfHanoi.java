package src.hard;

public class TowerOfHanoi {

    public static String hanoi(int nunOfDisks, int fromTower, int toTower) {

        if (nunOfDisks == 1) return fromTower + " -> " + toTower + ";";
        else {
            String move1, move2, move3;
            int otherTower = 6 - fromTower - toTower;
            move1 = hanoi(nunOfDisks - 1, fromTower, otherTower);
            move2 = fromTower + " -> " + toTower + ";";
            move3 = hanoi(nunOfDisks - 1, otherTower, toTower);

            return move1 + move2 + move3;
        }
    }
}