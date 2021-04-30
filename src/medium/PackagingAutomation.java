package src.medium;

import static java.util.Arrays.sort;

public class PackagingAutomation {

    public static void main(String[] args) throws java.text.ParseException {

        int[] arr = {3, 2, 1, 3, 5};
        System.out.println(packaging(5, arr));
    }

    public static int packaging(int numGroups, int[] arr) {

        int numPkgs = 1;

        sort(arr);
        for (int i = 0; i < numGroups - 1; i++) {
            int currPkgCnt = arr[i];
            int nxtPkgCnt = arr[i + 1];
            if (nxtPkgCnt - currPkgCnt == 1) numPkgs++;
            else if (nxtPkgCnt - currPkgCnt == 2) numPkgs = numGroups == 4 ? numPkgs + 2 : numPkgs + 1;
        }

        return numPkgs;
    }
}
