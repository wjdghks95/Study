package ch03;

public class BubbleSort {

	public static void main(String[] args) {

		int[] numbers = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};
		
		int temp;
		for(int i=0; i<numbers.length-1; i++) {
			for(int j=0; j<numbers.length-i-1; j++) {
				if(numbers[j] > numbers[j+1]) {
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<numbers.length; i++) {
			System.out.println("numbers["+i+"] : " + numbers[i]);
		}
	}

}
