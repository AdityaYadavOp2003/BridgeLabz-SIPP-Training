package stackques;

public class CircularTour {
    public static int findStartingPump(int[] petrolAtPump, int[] distanceToNextPump) {
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentPetrol = 0;
        int startingPumpIndex = 0;
        for (int pumpIndex = 0; pumpIndex < petrolAtPump.length; pumpIndex++) {
            totalPetrol += petrolAtPump[pumpIndex];
            totalDistance += distanceToNextPump[pumpIndex];
            currentPetrol += petrolAtPump[pumpIndex] - distanceToNextPump[pumpIndex];
            if (currentPetrol < 0) {
                startingPumpIndex = pumpIndex + 1;
                currentPetrol = 0;
            }
        }
        return totalPetrol < totalDistance ? -1 : startingPumpIndex;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = findStartingPump(petrol, distance);
        System.out.println(start);
    }
} 