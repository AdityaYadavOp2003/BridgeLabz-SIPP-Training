package sorting_algos;

public class HeapSortJobApplicants {
    public static void sortSalaryDemands(int[] salaryDemands) {
        int numberOfApplicants = salaryDemands.length;
        for (int i = numberOfApplicants / 2 - 1; i >= 0; i--) {
            heapify(salaryDemands, numberOfApplicants, i);
        }
        for (int i = numberOfApplicants - 1; i > 0; i--) {
            int temp = salaryDemands[0];
            salaryDemands[0] = salaryDemands[i];
            salaryDemands[i] = temp;
            heapify(salaryDemands, i, 0);
        }
    }
    private static void heapify(int[] salaryDemands, int heapSize, int rootIndex) {
        int largestIndex = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        if (leftChildIndex < heapSize && salaryDemands[leftChildIndex] > salaryDemands[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && salaryDemands[rightChildIndex] > salaryDemands[largestIndex]) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != rootIndex) {
            int temp = salaryDemands[rootIndex];
            salaryDemands[rootIndex] = salaryDemands[largestIndex];
            salaryDemands[largestIndex] = temp;
            heapify(salaryDemands, heapSize, largestIndex);
        }
    }
    public static void main(String[] args) {
        int[] salaries = {50000, 60000, 45000, 70000, 55000};
        sortSalaryDemands(salaries);
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
} 