package com.surya.collection;
import java.util.*;



public class TestCollections {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Integer> list = new LinkedList<>();
		
		Queue<Integer> q = new LinkedList<>();
		
		
		Set<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int  compare(Integer o1, Integer o2 ) {
				
				return o1 - o2;
			}
		
		});
		
		Queue<Integer> pq = new PriorityQueue<> (new Comparator<Integer> () {
			
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		
		
		ts.add(10);
		ts.add(2);
		ts.add(20);
		
		System.out.println("Treeset in string " + ts.toString());
		
		
		ABC a = new ABC(3,4);
		ABC b = new ABC(1,100);
		ABC c = new ABC(-3,-8);
		
		
		Set<ABC> tsABC = new TreeSet <ABC>();
		tsABC.add(a); 
		tsABC.add(b);
		tsABC.add(c);
		
		System.out.println("Treeset ABC " + tsABC.toString());
		
	}
	
	
	
	static class ABC implements Comparable<ABC> {

		int a,  b;
		
		public ABC(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(ABC o) {
			// TODO Auto-generated method stub
			return  (o.a * o.b) - (this.a * this.b) ;
		}
		
		@Override 
		public String toString() {
			return this.a + "_____" + this.b;
		}
	}

}
