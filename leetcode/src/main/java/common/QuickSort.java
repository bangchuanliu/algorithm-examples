package common;

public class QuickSort {
	public void sort(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		qSort(A, 0, A.length - 1);
	}

	public int partition(int[] A, int low, int high) {
		int r = A[high];
		int i = low - 1;
		int j = low;
		while (j < high) {
			if (A[j] <= r) {
				i++;
				swap(A, i, j);
			}
			j++;
		}
		i++;
		swap(A, i, high);
		return i;
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public void qSort(int[] A, int low, int high) {
		if (low < high) {
			int r = partition(A, low, high);
			qSort(A, low, r - 1);
			qSort(A, r + 1, high);
		}
	}
	
	public static void main(String[] args){
		int[] A= {1,3,5,9,2,4,1,5,7};
		new QuickSort().sort(A);
		for(int a : A){
			System.out.print(a + " ");
		}
	}
}
