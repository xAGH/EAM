public class BubbleSort {
	static int[] sort(int arr[]) {
		int length = arr.length - 1;
		for (int i = 0; i < length; i++)
			for (int j = 0; j < length - i; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}
}