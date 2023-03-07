public class BubbleSort {

    static int[] bubbleSort(int arr[])
    {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }

    public static void main(String[] args) {
        int[] arrTest = new int[] {49, 65, 15, 43, 98, 20, 07, 77};
        int[] sorted = bubbleSort(arrTest);
        int length = sorted.length;
        System.out.print('[');
        for (int value = 0; value < length; value++) {
            char sep = value == length - 1 ? ']' : ',';
            System.out.print(String.format("%d%s", sorted[value], sep));
        }
        System.out.println();
    }

}
