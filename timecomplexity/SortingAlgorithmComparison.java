package timecomplexity;

import java.util.Random;

public class SortingAlgorithmComparison {
    public static void main(String[] args) {
        int[] unsortedArray = new int[10000];
        Random randomGenerator = new Random();
        for (int index = 0; index < unsortedArray.length; index++) {
            unsortedArray[index] = randomGenerator.nextInt(100000);
        }
        int[] arrayForBubbleSort = unsortedArray.clone();
        int[] arrayForMergeSort = unsortedArray.clone();
        int[] arrayForQuickSort = unsortedArray.clone();
        long bubbleSortStart = System.nanoTime();
        bubbleSort(arrayForBubbleSort);
        long bubbleSortEnd = System.nanoTime();
        long mergeSortStart = System.nanoTime();
        mergeSort(arrayForMergeSort, 0, arrayForMergeSort.length - 1);
        long mergeSortEnd = System.nanoTime();
        long quickSortStart = System.nanoTime();
        quickSort(arrayForQuickSort, 0, arrayForQuickSort.length - 1);
        long quickSortEnd = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (bubbleSortEnd - bubbleSortStart) + " ns");
        System.out.println("Merge Sort Time: " + (mergeSortEnd - mergeSortStart) + " ns");
        System.out.println("Quick Sort Time: " + (quickSortEnd - quickSortStart) + " ns");
    }
    static void bubbleSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temporaryValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporaryValue;
                }
            }
        }
    }
    static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }
    static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];
        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[leftIndex + i];
        }
        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = array[middleIndex + 1 + j];
        }
        int leftPointer = 0, rightPointer = 0, mergedPointer = leftIndex;
        while (leftPointer < leftArraySize && rightPointer < rightArraySize) {
            if (leftArray[leftPointer] <= rightArray[rightPointer]) {
                array[mergedPointer] = leftArray[leftPointer];
                leftPointer++;
            } else {
                array[mergedPointer] = rightArray[rightPointer];
                rightPointer++;
            }
            mergedPointer++;
        }
        while (leftPointer < leftArraySize) {
            array[mergedPointer] = leftArray[leftPointer];
            leftPointer++;
            mergedPointer++;
        }
        while (rightPointer < rightArraySize) {
            array[mergedPointer] = rightArray[rightPointer];
            rightPointer++;
            mergedPointer++;
        }
    }
    static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex);
            quickSort(array, lowIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, highIndex);
        }
    }
    static int partition(int[] array, int lowIndex, int highIndex) {
        int pivotValue = array[highIndex];
        int smallerElementIndex = lowIndex - 1;
        for (int currentIndex = lowIndex; currentIndex < highIndex; currentIndex++) {
            if (array[currentIndex] < pivotValue) {
                smallerElementIndex++;
                int temporaryValue = array[smallerElementIndex];
                array[smallerElementIndex] = array[currentIndex];
                array[currentIndex] = temporaryValue;
            }
        }
        int temporaryValue = array[smallerElementIndex + 1];
        array[smallerElementIndex + 1] = array[highIndex];
        array[highIndex] = temporaryValue;
        return smallerElementIndex + 1;
    }
} 