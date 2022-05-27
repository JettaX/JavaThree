package main;

public class Main {
    public static void main(String[] args) {
    }

    public static int[] findLastFourAndCopyAfter(int[] mass) {
        for (int i = mass.length - 1; i > -1; i--) {
            if (mass[i] == 4) {
                i++;
                int[] newMass = new int[mass.length - i];
                for (int j = 0; j < newMass.length; j++) {
                    newMass[j] = mass[i + j];
                }
                return newMass;
            }
        }
        throw new RuntimeException();
    }

    public static boolean checkSequence(int[] mass) {
        int countOne = 0;
        int countFour = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 1) {
                countOne++;
            } else if (mass[i] == 4) {
                countFour++;
            } else {
                return false;
            }
        }
        if (countOne > 0 && countFour > 0) {
            return true;
        }
        return false;
    }
}
