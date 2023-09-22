public class SelectionSort {
  static int[] sort(int arr[])
  {
    int length = arr.length;
    for (int value = 0; value < length - 1; value++)
    {
      int min_index = value;
      for (int j = value + 1; j < length; j++)
      {
        if (arr[j] < arr[min_index]) {
          min_index = j;
        }
      }
      int temp = arr[min_index];
      arr[min_index] = arr[value];
      arr[value] = temp;
    }
    return arr;
  }
}