package beaconinside.sooraj.com;

import java.util.ArrayList;
import java.util.List;

public class Find21Short {
	// sample input matrix
	int m[][] = {{6,3,5,2,0}, {4,8,5,7,1}, {3,9,4,2,3}, {4,3,7,1,1}, {5,3,5,0,7}};
	int row = 5;
	int col = 5;
	// list to keep the shortest path
	List<Node> path = new ArrayList<Node>();
	// length of the shortest path
	int size = Integer.MAX_VALUE;
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Find21Short f21 = new Find21Short();
		
		// print the matrix first
		for (int i=0; i<f21.row; i++) {
			for (int j=0;j<f21.col;j++) {
				System.out.print(" " + f21.m[i][j]);
			}
			System.out.println("");
		}
		
		// do a DFS search for all elements in the matrix
		for (int i=0; i<f21.row; i++) {
			for (int j=0;j<f21.col;j++) {
				List<Node> ndList = new ArrayList<Node>();  
				f21.dfsFor21(i, j, 0, ndList, f21);
			}
		}
		
		// print the final path
		for (int p=0;p<f21.path.size();p++) {
			System.out.print(f21.path.get(p).v + " (" + f21.path.get(p).r + "/" + f21.path.get(p).c + ") ");
		}
	}

	/**
	 * function to do DFS search for an element in the matrix 
	 * @param i row index
	 * @param j column index
	 *  column index
	 * @param sum sum of the path 
	 * @param parent list containing traversed parents
	 * @param f21 object instance
	 */
	public void dfsFor21(int i, int j, int sum, List<Node> parent, Find21Short f21) {
		
		sum = sum+f21.m[i][j];
		
		// check if sum is 21, if so update path 
		if (sum == 21) {
			checkAndAdd(parent, new Node(f21.m[i][j],i,j), f21);
			return;
		// avoid longer paths	
		} else if (sum > 21) {
			return;
		// try out all possible directions 
		} else {
			Node n = new Node(f21.m[i][j],i,j);
			parent.add(n);
			
			// recurse through right neighbor
			if (checkChild(parent, i+1, j)) {
				List<Node> parantL = new ArrayList<Node>(parent);
				int sumL = sum;
				dfsFor21(i+1, j, sumL, parantL, f21);
			}
			
			// recurse through left neighbor
			if (checkChild(parent, i-1, j)) {
				List<Node> parantL = new ArrayList<Node>(parent);
				int sumL = sum;
				dfsFor21(i-1, j, sumL, parantL, f21);
			}
			
			// recurse through top neighbor
			if (checkChild(parent, i, j+1)) {
				List<Node> parantL = new ArrayList<Node>(parent);
				int sumL = sum;
				dfsFor21(i, j+1, sumL, parantL, f21);
			}
			
			// recurse through bottom neighbor
			if (checkChild(parent, i, j-1)) {
				List<Node> parantL = new ArrayList<Node>(parent);
				int sumL = sum;
				dfsFor21(i, j-1, sumL, parantL, f21);
			}
		}
	}
	
	/**
	 * function to check if current path is smaller than saved path 
	 * @param parant path to check
	 * @param node saved path
	 * @param f21 object instance
	 */
	public void checkAndAdd(List<Node> parant, Node node, Find21Short f21) {
		if ((parant.size()+1) < f21.size) {
			f21.path = new ArrayList<Node>(parant);
			f21.path.add(node);
			f21.size = f21.path.size();
		}
	}
	
	/**
	 * function to check if an element is parsed before
	 * @param parant list of already parsed elements
	 * @param i row index
	 * @param j column index
	 * @return true if not exists in the list and is a valid index 
	 */
	public boolean checkChild(List<Node> parant, int i, int j) {
		for(Node n: parant) {
			if ((n.r == i) && (n.c == j)) {
				return false;
			}
		}
		if (i<0 || i>4 || j<0 || j>4) {
			return false;
		}
		return true;
	}
	
	/**
	 *  inner class to hold a matrix element
	 */
	public class Node {
		int v,r,c;
		Node(int v, int r, int c) {
			this.v = v;
			this.r = r;
			this.c = c;
		}
	}
}
