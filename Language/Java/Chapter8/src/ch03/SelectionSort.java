package ch03;

public class SelectionSort {

	public static void main(String[] args) {

		int numbers[] = {66, 10, 1, 99, 5};
		
        int min;
        int temp;
        
        for(int i=0; i<numbers.length-1; i++){
            min = i;
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[min] > numbers[j]){
                    min = j;
                }
            }
            temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }
 
        for(int i=0; i<numbers.length; i++){
            System.out.println("numbers["+i+"] : " + numbers[i]);
        }
		  
	}

}
