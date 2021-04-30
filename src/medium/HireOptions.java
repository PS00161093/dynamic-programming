package src.medium;

import static java.util.Arrays.sort;

/**
 * Problem URL: https://aonecode.com/oa-shopping-options
 */
public class HireOptions {

    public static void main(String[] args) {

        int[] productManagers = {4, 7};
        int[] softwareEngineers = {6, 6};
        int[] accountManagers = {1, 3, 5};
        int[] programManagers = {5, 7, 12};
        int budget = 20;

        System.out.println(recruitmentCombinations(productManagers, softwareEngineers, accountManagers, programManagers
                , budget));
    }

    public static int recruitmentCombinations(
            int[] productManagers,
            int[] softwareEngineers,
            int[] accountManagers,
            int[] programManagers,
            int budget) {

        int combinations = 0;

        sort(productManagers);
        sort(softwareEngineers);
        sort(accountManagers);
        sort(programManagers);

        for (int i = 0; i < productManagers.length; i++) {

            int currExpense = 0;
            int pm = productManagers[i];
            currExpense = currExpense + pm;

            if (currExpense <= budget) {
                for (int j = 0; j < softwareEngineers.length; j++) {
                    int se = softwareEngineers[i];
                    currExpense = currExpense + se;

                    if (currExpense <= budget) {
                        for (int am : accountManagers) {
                            currExpense = currExpense + am;

                            if (currExpense <= budget) {
                                for (int prm : programManagers) {
                                    currExpense = currExpense + prm;

                                    if (currExpense <= budget) combinations++;
                                    currExpense = currExpense - prm;
                                }
                            }
                            currExpense = currExpense - am;
                        }
                    }
                    currExpense = currExpense - se;
                }
            }
        }

        return combinations;
    }
}
