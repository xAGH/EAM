public class Printer {
    public static void main(String[] args) {
        int[] test = new int[] { 49, 65, 15, 43, 98, 20, 07, 77 };
        print("Bubble Sort", BubbleSort.sort(test));
        print("SelectionSort", SelectionSort.sort(test));
        print("QuickSort", QuickSort.sort(test));
        print("InsertionSort", InsertionSort.sort(test));
    }

    static void print(String methodName, int arr[]) {
        System.out.print(methodName);
        int length = arr.length;
        System.out.print('[');
        for (int value = 0; value < length; value++) {
            char sep = value == length - 1 ? ']' : ',';
            System.out.print(String.format("%d%s", arr[value], sep));
        }
        System.out.println();
    }
}
