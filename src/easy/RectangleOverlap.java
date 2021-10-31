package src.easy;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class RectangleOverlap {

    /**
     * [x1, y1, x2, y2]
     * rec1 = [0,0,2,2]
     * <p>
     * [x1, y1, x2, y2]
     * rec2 = [1,1,3,3]
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
         * Must condition for overlap, mathematically
         * R1.x1 < R2.x2 && R2.x1 < R1.x2
         * R1.y1 < R2.y2 && R2.y1 < R1.y2
         */
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] &&
                rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
