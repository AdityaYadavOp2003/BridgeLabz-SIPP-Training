package sorting_algos;

public class InsertionSortEmployeeIDs {
    public static void sortEmployeeIDs(int[] employeeIDs) {
        int totalEmployees = employeeIDs.length;
        for (int currentIndex = 1; currentIndex < totalEmployees; currentIndex++) {
            int currentID = employeeIDs[currentIndex];
            int sortedIndex = currentIndex - 1;
            while (sortedIndex >= 0 && employeeIDs[sortedIndex] > currentID) {
                employeeIDs[sortedIndex + 1] = employeeIDs[sortedIndex];
                sortedIndex--;
            }
            employeeIDs[sortedIndex + 1] = currentID;
        }
    }
    public static void main(String[] args) {
        int[] ids = {105, 102, 110, 101, 108};
        sortEmployeeIDs(ids);
        for (int id : ids) {
            System.out.print(id + " ");
        }
    }
} 