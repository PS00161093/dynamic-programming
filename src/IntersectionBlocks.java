package src;

import static java.lang.Math.max;

/**
 * Problem URL: https://aonecode.com/oa-storage-optimization
 */
public class IntersectionBlocks {

    public static void main(String[] args) {

        int[] WELane = {2, 3};
        int[] NSLane = {2};

        System.out.println(intersectionArea(WELane, NSLane));
    }

    public static int intersectionArea(int[] WELane, int[] NSLane) {

        int WEContinuousLanes = 1;
        int WEMaxContinuousLanes = WEContinuousLanes;
        for (int i = 0; i < WELane.length - 1; i++) {
            if (WELane[i + 1] - WELane[i] == 1) {
                WEContinuousLanes++;
                WEMaxContinuousLanes = max(WEMaxContinuousLanes, WEContinuousLanes);
            } else WEContinuousLanes = 1;
        }

        int NSContinuousLanes = 1;
        int NSMaxContinuousLanes = NSContinuousLanes;
        for (int i = 0; i < NSLane.length - 1; i++) {
            if (NSLane[i + 1] - NSLane[i] == 1) {
                NSContinuousLanes++;
                NSMaxContinuousLanes = max(NSMaxContinuousLanes, NSContinuousLanes);
            } else NSContinuousLanes = 1;
        }

        return WEMaxContinuousLanes * NSMaxContinuousLanes;
    }
}
