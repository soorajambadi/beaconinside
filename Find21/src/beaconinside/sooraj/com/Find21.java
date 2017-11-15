package beaconinside.sooraj.com;

import java.util.ArrayList;
import java.util.List;

public class Find21 {
	
	int m[][] = {{6,3,5,2,0}, {4,8,5,7,1}, {3,9,4,2,3}, {4,3,7,1,1}, {5,3,5,0,7}};
	boolean found = false;
	public static void main(String[] args) {
		Find21 f21 = new Find21();
		
		for (int i=0; i<5; i++) {
			for (int j=0;j<5;j++) {
				System.out.print(" " + f21.m[i][j]);
			}
			System.out.println("");
		}
		
		for (int i=0; i<5; i++) {
			for (int j=0;j<5;j++) {
				List<Node> ndList = new ArrayList<Node>();  
				if (!f21.found) {
					f21.dfsFor21(i, j, 0, ndList, f21);
				}
			}
		}
	}

	public boolean dfsFor21(int i, int j, int sum, List<Node> parant, Find21 f21) {
		sum = sum+f21.m[i][j];
		if (sum == 21) {
			System.out.println(f21.m[i][j] + " (" + i + "/" + j + ") ");
			found = true;
			return true;
		} else if (sum > 21) {
			return false;
		} else {
			Node n = new Node(i,j);
			parant.add(n);
			if (checkChild(parant, i+1, j)) {
				List<Node> parantL = new ArrayList(parant);
				int sumL = sum;
				//System.out.print(" . " + f21.m[i][j]);
				boolean rtn = dfsFor21(i+1, j, sumL, parantL, f21);
				if (rtn) {
					System.out.println(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				} else {
					return false;
				}
			}
			
			if (checkChild(parant, i-1, j)) {
				List<Node> parantL = new ArrayList(parant);
				int sumL = sum;
				//System.out.print(" , " + f21.m[i][j]);
				boolean rtn = dfsFor21(i-1, j, sumL, parantL, f21);
				if (rtn) {
					System.out.println(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				} else {
					return false;
				}
			}
			
			if (checkChild(parant, i, j+1)) {
				List<Node> parantL = new ArrayList(parant);
				int sumL = sum;
				//System.out.print(" + " + f21.m[i][j]);
				boolean rtn = dfsFor21(i, j+1, sumL, parantL, f21);
				if (rtn) {
					System.out.println(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				} else {
					return false;
				}
			}
			
			if (checkChild(parant, i, j-1)) {
				List<Node> parantL = new ArrayList(parant);
				int sumL = sum;
				//System.out.print(" - " + f21.m[i][j]);
				boolean rtn = dfsFor21(i, j-1, sumL, parantL, f21);
				if (rtn) {
					System.out.println(f21.m[i][j] + " (" + i + "/" + j + ") ");
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
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
	
	public class Node {
		int r,c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
