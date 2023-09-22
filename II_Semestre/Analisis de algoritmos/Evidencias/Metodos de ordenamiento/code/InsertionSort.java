public class InsertionSort {
  static int[] sort(int arr[])
  {
    int length = arr.length;
    for (int value = 1; value < length; ++value)
    {
      int key = arr[value];
      int j = value - 1;
      while (j >= 0 && arr[j] > key)
      {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    return arr;
  }
}
