package ch03;

public class HeapTest {

	private int SIZE;
	private int[] heapArr;
	
	public HeapTest() {
		
		SIZE = 0;
		heapArr = new int[50];
	}
	
	public int getHeapSize() {
		
		return SIZE;
	}
	
	public void insertHeap(int input) {
		
		int i = ++SIZE;
		while((i != 1) && input < heapArr[i/2]) {
			
			heapArr[i] = heapArr[i/2];
			i = i/2;
		}
		heapArr[i] = input;
	}
	
	public int deleteHeap() {
		
		int data = heapArr[1];
		int parent, child;
		int temp;
		
		temp = heapArr[SIZE];
		SIZE -= 1;
		parent = 1; child = 2;
		
		while(child <= SIZE) {
			
			if((child < SIZE) && heapArr[child] > heapArr[child+1]) {
				child++;
			}
			if(temp <= heapArr[child]) break;
			heapArr[parent] = heapArr[child];
			parent = child;
			child *= 2;
		}
		heapArr[parent] = temp;
		return data;
	}

	
	public static void main(String[] args) {

		HeapTest h = new HeapTest();
		
		h.insertHeap(20);
		h.insertHeap(10);
		h.insertHeap(50);
		h.insertHeap(30);
		h.insertHeap(80);
		
		int n, data;
		n = h.getHeapSize();
		for(int i=1; i<=n; i++){    
			data = h.deleteHeap();  
			System.out.printf("\n 출력 : [%d]", data);
		}
	}

}
