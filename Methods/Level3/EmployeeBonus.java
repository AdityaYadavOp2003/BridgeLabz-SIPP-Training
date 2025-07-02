package Level3;

import java.util.*;

public class EmployeeBonus {
    public static void main(String[] args) {
        Random rand = new Random();
        double[][] data = new double[10][2]; // [salary, years]
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // 5-digit salary
            data[i][1] = 1 + rand.nextInt(15); // 1-15 years
        }
        double[][] result = new double[10][2]; // [new salary, bonus]
        double sumOld = 0, sumNew = 0, totalBonus = 0;
        for (int i = 0; i < 10; i++) {
            double bonus = data[i][1] > 5 ? data[i][0] * 0.05 : data[i][0] * 0.02;
            result[i][0] = data[i][0] + bonus;
            result[i][1] = bonus;
            sumOld += data[i][0];
            sumNew += result[i][0];
            totalBonus += bonus;
        }
        System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f\n", i+1, data[i][0], data[i][1], result[i][1], result[i][0]);
        }
        System.out.printf("SumOld: %.2f\tSumNew: %.2f\tTotalBonus: %.2f\n", sumOld, sumNew, totalBonus);
    }
}
