package com.ashok.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static Map<Integer,Integer> map= null;
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int n = 0; n < t; n++) {
			int a = sc.nextInt();
			char arr[][]= new char[a][a];
			for(int j= 0; j < a;j++)
				for(int k= 0;k < a;k++)
					arr[j][k]= sc.next().charAt(0);

			/*for(int j = 0;j < a;j++)
			{
				for(int k = 0;k < a;k++)
				{
					System.out.print(arr[j][k]+" ");
				}
			}
			System.out.println();*/
			map= new HashMap<>();
			map.put(0, 0);
			
			MyThread t1= new MyThread();
			t1.setMap(map).setArr(arr).setL(a-1).setR(a-1).setTotal(0);
			t1.start();
			t1.join();
			//find(arr, a-1, a-1, 0);
			Set<Integer> set = map.keySet();
			//System.out.println(set.toString());
			Integer max = Collections.max(set);
			System.out.println(max+" "+map.get(max));
		}
		
	}

	public static void find(char[][] arr, int l, int r, int total)
	{
		if(l == 0 && r == 0)
		{
			map.put(total, map.get(total)!=null?(Integer)map.get(total)+1:1);
			return;
		}
		if(!(l == arr.length -1 && r == arr.length-1))
			total+= Character.getNumericValue(arr[l][r]);
		if(l != 0 && arr[l-1][r] != 'x')
			find(arr, l-1, r, total);
		if(r != 0 && arr[l][r-1] != 'x')
			find(arr, l, r-1, total);
		if(l != 0 && r != 0 && arr[l-1][r-1] != 'x')
			find(arr, l-1, r-1, total);
	}

}
class MyThread extends Thread{

	Map<Integer, Integer> map= null;
	char[][] arr;
	int l;
	int r;
	int total;
	public void run()
	{
		MyThread t1 = null, t2 = null, t3 = null;
		if(l == 0 && r == 0)
		{
			map.put(total, map.get(total)!=null?(Integer)map.get(total)+1:1);
			return;
		}
		if(!(l == arr.length -1 && r == arr.length-1))
			total+= Character.getNumericValue(arr[l][r]);
		if(l != 0 && arr[l-1][r] != 'x')
		{
			Solution.find(arr, l-1, r, total);
		}
		if(r != 0 && arr[l][r-1] != 'x')
		{
			
			Solution.find(arr, l-1, r, total);
		}
		if(l != 0 && r != 0 && arr[l-1][r-1] != 'x')
		{
			Solution.find(arr, l-1, r, total);
		}
		
	}
	public Map<Integer, Integer> getMap() {
		return map;
	}
	public MyThread setMap(Map<Integer, Integer> map) {
		this.map = map;
		return this;
	}
	public char[][] getArr() {
		return arr;
	}
	public MyThread setArr(char[][] arr) {
		this.arr = arr;
		return this;
	}
	public int getL() {
		return l;
	}
	public MyThread setL(int l) {
		this.l = l;
		return this;
	}
	public int getR() {
		return r;
	}
	public MyThread setR(int r) {
		this.r = r;
		return this;
	}
	public int getTotal() {
		return total;
	}
	public MyThread setTotal(int total) {
		this.total = total;
		return this;
	}
}
