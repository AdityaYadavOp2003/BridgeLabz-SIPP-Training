package sorting_algos;

public class CountingSortStudentAges {
    public static void sortStudentAges(int[] studentAges) {
        int minimumAge = 10;
        int maximumAge = 18;
        int range = maximumAge - minimumAge + 1;
        int[] ageFrequencies = new int[range];
        for (int age : studentAges) {
            ageFrequencies[age - minimumAge]++;
        }
        int sortedIndex = 0;
        for (int age = minimumAge; age <= maximumAge; age++) {
            while (ageFrequencies[age - minimumAge] > 0) {
                studentAges[sortedIndex++] = age;
                ageFrequencies[age - minimumAge]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 13, 12};
        sortStudentAges(ages);
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
} 