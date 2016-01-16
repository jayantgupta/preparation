/*
	Implementation of Breadth First Search as described in CLRS,
	Author : Jayant Gupta,
	Date : January 16, 2015
*/

import java.io.*;
import java.util.*;

public class BFS{
	static int v ,e, g;
	static ArrayList<Integer> [] adj_list;
	public static void main(String [] args)throws Exception{
		read_input();
		for(int i = 1 ; i <= v ; i++){
			for(int j = 0 ; j < adj_list[i].size() ; j++){
				System.out.print(Integer.toString(adj_list[i].get(j)) + " ");
			}
			System.out.println();
		}
		BFS(adj_list, g);
	}
	
	// Implementing Breadth First Search.
	public static void BFS(ArrayList<Integer> [] adj_list, int g){
		LinkedList<Integer> myQueue = new LinkedList<Integer>();
		int dist[] = new int[v + 1];
		int prev[] = new int[v + 1];
		int seen[] = new int[v + 1];
		for(int i = 1 ; i <= v ; i++){
			dist[i] = prev[i] = -1;
			seen[i] = 0; // white
		}
		myQueue.add(g);
		dist[g] = 0;
		seen[g] = 1; // grey
		while(myQueue.size() > 0){
			int u = myQueue.remove();
			for(int v : adj_list[u]){
				if(seen[v] == 0){
					seen[v] = 1;
					dist[v] = dist[u] + 1;
					prev[v] = u;
					myQueue.add(v);	
				}
			}
			seen[u] = 2;
		}
		for(int i = 1 ; i <= v ; i++){
			System.out.print(Integer.toString(dist[i]) + " ");
		}
		System.out.println();
		return;
	}
	
	//Reading input.
	public static void read_input()throws Exception{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(in.readLine());
		adj_list = ( ArrayList<Integer> [])new ArrayList[v + 1];
		for(int i = 0 ; i <= v ; i++)
			adj_list[i] = new ArrayList<Integer>();	
		e = Integer.parseInt(in.readLine());
		for(int i = 0 ; i < e ; i++){
			String edge = in.readLine();
			System.out.println(edge);
			int a = Integer.parseInt(edge.split(" ")[0]);
			int b = Integer.parseInt(edge.split(" ")[1]);
			adj_list[a].add(b);
			adj_list[b].add(a);
		}
		g = Integer.parseInt(in.readLine());
		return;
	}
}
