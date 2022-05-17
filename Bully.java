package bullyAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	public int id;
	public int status;
	public int priority;

	public Node(int id, int status, int priority) {
		super();
		this.id = id;
		this.status = status;
		this.priority = priority;
	}
}

public class Bully {
	static int n;
	static int id;
	static int status;
	static int priority;
	static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		List<Node> eList = new ArrayList<Node>();
		System.out.println("Enter size of elements list");
		n = sc.nextInt();
		// for(int i=0;i<n;i++) {
		// System.out.println("enter id, status, priority");
		// id = sc.nextInt();
		// status = sc.nextInt();
		// priority = sc.nextInt();
		// eList.add(new Node(id, status, priority));
		// }
		// eList.get(1);

		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			System.out.println("enter id, status, priority");
			id = sc.nextInt();
			status = sc.nextInt();
			priority = sc.nextInt();
			nodes[i] = new Node(id, status, priority);
		}
		System.out.println("processes created");
		System.out.println("id  :: status :: priority");
		for (int i = 0; i < n; i++) {
			System.out.println(nodes[i].id + " :: " + nodes[i].status + "      :: " + nodes[i].priority);
		}
		System.out.println("enter any index to start 'ELECTION' using bully algorithm");
		int no = sc.nextInt();
		election(nodes, n, no, 0);

	}

	static void election(Node[] proc, int n, int currInd, int maxInd) {
		if(currInd < n) {
			if(proc[currInd].status == 1) {
				for (int i = 0; i < n; i++) {
					if(proc[i].priority > proc[currInd].priority) {
						System.out.println("'ELECTION' message sent from process "+proc[currInd].id+" to process "+proc[i].id);
					}
				}
				System.out.println("__________________________________________________");
				for (int i = 0; i < n; i++) {
					if(proc[i].priority > proc[currInd].priority) {
						if(proc[i].status == 1) {
							System.out.println("'OK' message sent from process "+proc[i].id+" to process "+proc[currInd].id);
						}
					}
				}
				System.out.println("__________________________________________________");
				int nextInd=nextInd(proc, n, currInd);
				election(proc, n, nextInd, currInd);
			}else {
				int nextInd=nextInd(proc, n, currInd);
				election(proc, n, nextInd, maxInd);
			}
		}else {
			System.out.println("election over!");
			System.out.println("New Co-ordinator is :: (id)"+proc[maxInd].id);
		}
	}
	
	static int nextInd(Node[] proc, int n, int currInd) {
		int nextInd=9999;
		for(int i=0;i<n;i++) {
			if(proc[i].priority > proc[currInd].priority) {
				nextInd = i;
				break;
			}
		}
		return nextInd;
	}

}
