public class QuickSort {

    static int[] sort(int arr[]) {
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quicksort(int arr[], int left, int right) {

        int pivot = arr[left],
                i = left,
                j = right,
                aux;

        while (i < j) {
            while (arr[i] <= pivot && i < j)
                i++;

            while (arr[j] > pivot)
                j--;

            if (i < j) {
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
            }
        }

        arr[left] = arr[j];
        arr[j] = pivot;

        if (left < j - 1)
            quicksort(arr, left, j - 1);

        if (j + 1 < right)
            quicksort(arr, j + 1, right);
    }

}
