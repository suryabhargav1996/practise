package com.surya;

public class Heap {

	
	private int arr[];
	public int  capacity;
	public int currentSize;
	
	public Heap(int n) {
		this.arr = new int[n];
		this.currentSize = 0;
		this.capacity = 20;
	}
	
	public int parent (int key) {
		return (key -1)/2;
	}
	
	public int leftChild (int key) {
		return 2*key + 1;
	}
	
	public int rightChild (int key) {
		return 2*key + 2;
	}
	
	
	// adds the key at end then initiates the heapify up process
	public boolean add (int value) {
		if (this.currentSize >= this.capacity) {
			//heap full
			return false;
		} 
		int i = this.currentSize;
		this.arr[this.currentSize++] = value;
		
		while (i !=0 && this.arr[i] > this.arr[parent(i)]) {
			swap(this.arr, i, parent(i));
			i = parent(i);
			
		}		
		return true;
	}
	
	
	
	private static void swap(int[] arr, int a, int b) {
		
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

