package com.surya;

import java.util.*;
public class Practise {


	
	static int globalCounter=0;
	public static void main(String[] args) {
		
		int [] arr= new int[] {2,3,7,8, 10};
		int expectedSum=19;
		boolean [][] matrix = new boolean[arr.length+1] [expectedSum+1];
		boolean [][] matrix2 = new boolean[arr.length+1] [expectedSum+1];
		
		/*
		 * System.out.println(subsetSum(arr, arr.length, expectedSum, matrix));
		 * System.out.println(subsetSumTopDown(arr, arr.length, expectedSum, matrix2));
		 * 
		 * System.out.println("globalCounter is " + globalCounter);
		 * 
		 * 
		 * 
		 * for(int i=0;i<=arr.length;i++) { for(int j=0;j<=expectedSum;j++) {
		 * System.out.print(matrix2[i][j] + " ,"); } System.out.println(""); }
		 */
		
		//String x="abcd" , y="axvbd";
		//String x="abcd" , y="axvbd";
		//String x = "ABCDEF" , y = "ABCDEF";
		//String x = "RACECAR",  y = "CARRACE";
		//String x = "RACECAR", y = "CARRACE";
		String x = "AABBCDD",  y = "ABACD";


		//System.out.println(lcs(x,y,x.length(),y.length()));
		
		
		int[][] memo = new int[x.length() +1][y.length()+1];
		
		//initialize memo 
				for(int i=0;i<=x.length();i++) {
					for(int j=0;j<=y.length();j++) {
						memo[i][j] = i==0||j==0 ? 0:-1;
					}
				}
				
				
		int[] maxCount = new int[1];		
		lcSubstring(x,y,x.length(),y.length(),memo,maxCount);
		System.out.println("LC substring " + maxCount[0] );
		
		
		Set<String> powerSet = new HashSet<>();
		String a =  "abc";
		powerSet(a,0, "", powerSet);
		System.out.println("powerSet " + powerSet.toString());
		int[] arr2 = new int[] {1,2,3};
		
		Set<Set<Integer>> powerArray = new HashSet<>();
		powerSet(arr2, 0, new HashSet<>(), powerArray);
		
		
		Set<String> permutations = new HashSet<>();
		
		
		
		System.out.println("powerSet " + powerArray.toString());
		permutations(a, "", permutations);
		System.out.println("permutations " + permutations.toString());

		
	}
	/*
	 * longest common substing
	 */
	static int lcSubstring(String x, String y, int m, int n, int[][] memo, int[] maxCount) { 
		
		if(m==0 || n==0) {
			return 0;
		}
		if(memo[m][n] != -1) {
			return memo[m][n];
		}
		int localCount = 0;
		
		if(x.charAt(m-1) == y.charAt(n-1)) {
			localCount = 1 + lcSubstring(x,y,m-1,n-1, memo, maxCount);
			maxCount[0] = Math.max(localCount, maxCount[0]);
		}
		
		lcSubstring(x,y,m,n-1,memo,maxCount);
		lcSubstring(x,y,m-1,n,memo,maxCount);
		memo[m][n] = localCount;
		return memo[m][n];
	}
	
	/*
	 * longest common subsequence
	 */
	static int lcs(String x, String y, int m, int n) {
		
		if(m==0 || n==0) {
			return 0;
		}
		int[][] memo = new int[m+1][n+1];
		
		//initialize memo 
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				memo[i][j] = i==0||j==0 ? 0:-1;
			}
		}
		
		for(int i=1; i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(x.charAt(i-1)==y.charAt(j-1)) {
					memo[i][j] = 1+ memo[i-1][j-1];
				} 
				else {
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
				}
			}
		}
		printMemo(memo);
		return memo[m][n];
	}
	
	static void printMemo(int[][] memo) {
		for(int i=0;i<memo.length;i++) {
			for(int j=0;j<memo[i].length;j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	static boolean subsetSum (int[] arr, int n, int sum, boolean[][] matrix) {
		
		
		if(sum==0) {
			return true;
		} 
		
		if (n==0) {
			return false;
		}
			
		
		
		globalCounter++;
		if(arr[n-1] > sum) {
			matrix[n][sum] = subsetSum(arr, n-1, sum, matrix);
			return matrix[n][sum];
		}
	
		return matrix[n][sum] = subsetSum(arr,n-1, sum- arr[n-1], matrix) || subsetSum(arr, n-1, sum, matrix);
		
	}
	
	
	static boolean subsetSumTopDown(int[] arr, int n, int sum, boolean[][] matrix) {
		
		//initialize the matrix
		
		for(int i=0;i<=n; i++) {
			matrix[i][0] = true;
			
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				
				if(j < arr[i-1]) {
					//exclude the element matrix[n][sum] = subsetSum(arr, n-1, sum, matrix)
					matrix[i][j] = matrix[i-1][j];
				} else {
					matrix[i][j] = matrix[i-1][j] || matrix[i-1][j - arr[i-1]];
				}
			}
		}
		return matrix[n][sum];
	}
	
	
	
	static void powerSet(String s, int index, String current, Set<String> powerSet) {
		if(index == s.length()) {
			powerSet.add(current);
			return;
		}
		
		powerSet(s, index+1, current + s.charAt(index), powerSet);
		powerSet(s, index+1, current, powerSet);
	}
	
	static void powerSet(int[] s, int index, Set<Integer> current, Set<Set<Integer>> powerSet) {
		if(index == s.length) {
			powerSet.add(new HashSet<>(current));
			return;
		}
		powerSet(s, index+1, current, powerSet);
		current.add(s[index]);
		powerSet(s, index+1, current, powerSet);
		current.remove(s[index]);
	}
	
	static void permutations(String s, String current, Set<String> list) {
		
		if(s.isEmpty()) {
			list.add(current);
			return;
		}
		for(int i=0;i<s.length();i++) {
			//make a particular character as fixed
			String newCurrent = current + s.charAt(i);
			String s2 = s.substring(0,i) + s.substring(i+1);
 			permutations(s2, newCurrent, list);
		}	
	}
}
