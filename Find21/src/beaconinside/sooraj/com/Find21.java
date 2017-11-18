package beaconinside.sooraj.com;

import java.util.ArrayList;
import java.util.List;

public class Find21 {
	
	// sample input matrix
	int m[][] = {{6,3,5,2,0}, {4,8,5,7,1}, {3,9,4,2,3}, {4,3,7,1,1}, {5,3,5,0,7}};
	int row = 5;
	int col = 5;
	// flag to stop search 
	boolean found = false;
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Find21 f21 = new Find21();
		
		// print the matrix first
		for (int i=0; i<f21.row; i++) {
			for (int j=0;j<f21.col;j++) {
				System.out.print(" " + f21.m[i][j]);
			}
			System.out.println("");
		}
		
		// do a DFS search elements in the matrix, stop as soon as one is found
		for (int i=0; i<f21.row; i++) {
			for (int j=0;j<f21.col;j++) {
				List<Node> ndList = new ArrayList<Node>();  
				if (!f21.found) {
					f21.dfsFor21(i, j, 0, ndList, f21);
				}
			}
		}
	}

	/**
	 * function to do DFS search for an element in the matrix
	 * recursive call returns immediately once a path with 21 is found
	 * no more search is performed since we only need one path 
	 * @param i row index
	 * @param j column index
	 *  column index
	 * @param sum sum of the path 
	 * @param parent list containing traversed parents
	 * @param f21 object instance
	 */
	public boolean dfsFor21(int i, int j, int sum, List<Node> parant, Find21 f21) {
		
		sum = sum+f21.m[i][j];
		
		// if sum is 21, then print the element and go to caller
		// (print elements in the backward order)
		if (sum == 21) {
			System.out.print(f21.m[i][j] + " (" + i + "/" + j + ") ");
			found = true;
			return true;
		// avoid longer paths	
		} else if (sum > 21) {
			return false;
		// try out all possible directions	
		} else {
			Node n = new Node(i,j);
			parant.add(n);
			
			// recurse through right neighbor
			if (checkChild(parant, i+1, j, f21)) {
				List<Node> parantL = new ArrayList<Node>(parant);
				int sumL = sum;
				boolean rtn = dfsFor21(i+1, j, sumL, parantL, f21);
				if (rtn) {
					System.out.print(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				}
			}
			
			// recurse through left neighbor
			if (checkChild(parant, i-1, j, f21)) {
				List<Node> parantL = new ArrayList<Node>(parant);
				int sumL = sum;
				boolean rtn = dfsFor21(i-1, j, sumL, parantL, f21);
				if (rtn) {
					System.out.print(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				}
			}

			// recurse through top neighbor
			if (checkChild(parant, i, j+1, f21)) {
				List<Node> parantL = new ArrayList<Node>(parant);
				int sumL = sum;
				boolean rtn = dfsFor21(i, j+1, sumL, parantL, f21);
				if (rtn) {
					System.out.print(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				}
			}
			
			// recurse through bottom neighbor
			if (checkChild(parant, i, j-1, f21)) {
				List<Node> parantL = new ArrayList<Node>(parant);
				int sumL = sum;
				boolean rtn = dfsFor21(i, j-1, sumL, parantL, f21);
				if (rtn) {
					System.out.print(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * function to check if an element is parsed before
	 * @param parant list of already parsed elements
	 * @param i row index
	 * @param j column index
	 * @return true if not exists in the list and is a valid index 
	 */
	public boolean checkChild(List<Node> parant, int i, int j, Find21 f21) {
		for(Node n: parant) {
			if ((n.r == i) && (n.c == j)) {
				return false;
			}
		}
		if (i<0 || i>f21.row-1 || j<0 || j>f21.col) {
			return false;
		}
		return true;
	}
	
	/**
	 * inner class to hold index of a matrix element
	 */
	public class Node {
		int r,c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
