package com.surya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueQuestions {
	
	public static void main(String[] args) {
		
		int a[] = new int[] {2,3,4, -1,0,8};
		List<Integer> b = new ArrayList<>();
		for(int i: a) {
			b.add(i);
		}
		
		
		long abs = Math.abs(Integer.MAX_VALUE);
		System.out.println("number : " + Integer.MAX_VALUE + "   abs :" +abs);
		
		Comparator c = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
		
			return o2 - o1;
		}
		};
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(c);
		q.addAll(b);
		while(!q.isEmpty()) {
			System.out.println("element is " +  q.poll());
		}
		
	}

}
