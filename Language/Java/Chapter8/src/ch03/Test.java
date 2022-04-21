package ch03;

public class Test {

	public static void print(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void selectionSort(int[] arr) {
		
		int min;
		int temp;
		
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
		print(arr);
	}
	
	public static void bubbleSort(int[] arr) {
		
		int temp;
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
		
		print(arr);
	}
	
	public static void main(String[] args) {

		int[] arr = {80, 50, 70, 10, 60, 20, 40, 30};
		
		selectionSort(arr);
		System.out.println("\n-----------------------");
		
		bubbleSort(arr);
		System.out.println("\n-----------------------");
	}

}
