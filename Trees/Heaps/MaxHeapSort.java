import java.util.*;
public class MaxHeapSort
{
	public static void main(String args[])
	{
		int arr[] = {8,4,7,1,3,5};
		MaxHeapSort heap = new MaxHeapSort();
		heap.buildHeap(arr, arr.length);
		heap.heapSort(arr);
		System.out.println("Sorted array is : "+ Arrays.toString(arr) );
	}

	private void heapSort(int heap[])
	{
		int heap_size= heap.length;
		buildHeap(heap, heap_size);
		for(int i = heap_size; i>=2; i--)
		{
			int temp = heap[0];
			heap[0] = heap[heap_size-1];
			heap[heap_size-1] = temp;
			heap_size-=1;
			max_heapify(heap,heap_size);
		}
	}
	private void buildHeap(int heap[], int n)
	{
		for(int i = n/2; i>=1; i--)
		{
			max_heapify(heap,i);
		}
	} 

	private void max_heapify(int heap[], int ind)
	{
		int left = ind*2;
		int right = ind*2 +1;
		int largest = ind;

		if(left < heap.length && heap[left] >= heap[ind]){
			largest = left;
		}

		if(right < heap.length && heap[right] >= heap[largest]){
			largest = right;
		}

		if(largest != ind){
			int temp = heap[largest];
			heap[largest] = heap[ind];
			heap[ind] = temp;

			max_heapify(heap, largest);
		}
	}
}