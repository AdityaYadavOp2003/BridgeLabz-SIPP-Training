package sorting_algos;

public class BubbleSortStudentMarks {
    public static void sortStudentMarks(int[] studentMarks) {
        int numberOfStudents = studentMarks.length;
        boolean isSorted;
        for (int i = 0; i < numberOfStudents - 1; i++) {
            isSorted = true;
            for (int j = 0; j < numberOfStudents - i - 1; j++) {
                if (studentMarks[j] > studentMarks[j + 1]) {
                    int markToSwap = studentMarks[j];
                    studentMarks[j] = studentMarks[j + 1];
                    studentMarks[j + 1] = markToSwap;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] marks = {78, 55, 89, 62, 90, 70};
        sortStudentMarks(marks);
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
} 