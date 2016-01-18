/* 
	 Implementation of Depth First Search as described in CLRS,
		Author : Jayant Gupta
		Date : January 17, 2016
		Colour :
			0 = White
			1 = Grey
			2 = Black	
*/

import java.io.*;
import java.util.*;

public class DFS{
	static int v, e, g;
	static ArrayList<Integer> [] adj_list;
	static int mark[];
	static int prev[];
	static int disc[];
	static int fini[];
	static int time;

	public static void main(String  [] args)throws Exception{
		read_input();
		DFS(adj_list);
	}

	// Depth First Search Algorithm implementation.
	public static void DFS(ArrayList<Integer> [] adj_list){
		mark = new int[v + 1];
		prev = new int[v + 1];
		disc = new int[v + 1];
		fini = new int[v + 1];
		for(int i = 1 ; i <= v ; i++){
			mark[i] = 0; // white
			prev[i] = 0;
			disc[i] = 0;
			fini[i] = 0;
		}
		time = 0;
		for(int i = 1 ; i <= v ; i++){
			if(mark[i] == 0){
				DFS_Visit(i);
			}
		}
		printArray(prev, 1, v);
		printArray(disc, 1, v);
		printArray(fini, 1, v);
	}

	static void DFS_Visit(int u){
		mark[u] = 1; // Grey
		time += 1;
		disc[u] = time;
		for(int v : adj_list[u]){
			if(mark[v] == 0){
				prev[v] = u;
				DFS_Visit(v);
			}
		}
		mark[u] = 2; // Black
		time += 1 ;
		fini[u] = time;
	}
	static void printArray(int [] arr, int start, int end){
		int l = arr.length;
		for(int i = start ; i <= end ; i++){
			System.out.print(Integer.toString(arr[i]) + " ");
		}
		System.out.println();
	}
	
	//Reading input.
	public static void read_input()throws Exception{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(in.readLine());
		adj_list = ( ArrayList<Integer> [])new ArrayList[v + 1]; 
		for(int i = 0 ; i <= v ; i++){
			adj_list[i] = new ArrayList<Integer>(); 
		}
		e = Integer.parseInt(in.readLine());
		for(int i = 0 ; i < e ; i++){
			String edge = in.readLine();
			int a = Integer.parseInt(edge.split(" ")[0]);
			int b = Integer.parseInt(edge.split(" ")[1]);
			adj_list[a].add(b);
//			adj_list[b].add(a); // Comment out when required for directed graph.
		}   
//		g = Integer.parseInt(in.readLine());
		return;
	}
}
