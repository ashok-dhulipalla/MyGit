package com.ashok.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FastInputIO {

	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	}

	public static void main(String[] args) {
		usingScanner();
		//usingBufferedReader();
		//usingUserClass();
	}

	private static void usingUserClass() {
		FastReader s=new FastReader(); 
		int n = s.nextInt(); 
		int k = s.nextInt(); 
		int count = 0; 
		while (n-- > 0) 
		{ 
			int x = s.nextInt(); 
			if (x%k == 0) 
				count++; 
		} 
		System.out.println(count); 
	}

	private static void usingBufferedReader() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			int k= Integer.parseInt(st.nextToken());
			int count = 0; 
			while (n-- > 0) 
			{ 
				int x = Integer.parseInt(br.readLine()); 
				if (x%k == 0) 
					count++; 
			}  
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void usingScanner() {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int k= sc.nextInt();
		int count = 0; 
		while (n-- > 0) 
		{ 
			int x = sc.nextInt(); 
			if (x%k == 0) 
				count++; 
		}  
		System.out.println(count);
	}
}
