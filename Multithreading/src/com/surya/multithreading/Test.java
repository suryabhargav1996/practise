package com.surya.multithreading;

public class Test {

	
	public static void main(String[] args) {
		
		Test t  = new Test();
		ThreadTest t2 = t.new ThreadTest();
		(new Thread(t2)).start();
	}
	private class ThreadTest implements Runnable {
		@Override
		public void run() {
			
			System.out.println("Testing thread using Runnable");
		}
	}
}
