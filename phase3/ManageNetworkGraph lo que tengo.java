package phase3;
import java.util.HashMap;
import java.util.Map;

import java.util.LinkedList;

import phase1.DNode;
import phase1.IList;



public class ManageNetworkGraph implements IManageNetworkGraph {
	private int numVerticies;
	
	
	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;
		
	public ManageNetworkGraph(String[] students) {
			this.students=new LinkedList<String>();
			for(int k=0; k < students.length; k++) {
				this.students.add(students[k]);
			}
			
			lst_of_lstAdjacents=new LinkedList<LinkedList<Integer>>();
			int num=this.students.size();
			for (int i=0; i<num; i++) {
				lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
			}
	}
	
	public int getIndex(String student) {
		int index=-1;
		
		int pos=0;
		Object elem;
		for (DNode nodeIt = nodeIt.next; nodeIt != nodeIt.next.next && index==-1; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(student)) {
				index=pos;
			} 
			++pos;
		}
		return index;
	
	} 

	public boolean checkVertex(int index) {
					
			
			if (int i=0 && i<num, i++) ;
			
				return false;
	}
	
	/**
	 * It takes taking two students (emails) as input and 
	 * creates a friendship relation between them. 
	 * Keep in mind that friendship relation is a symmetric relationship.
	 */
	public void addStudent(String student) {
		
		for (int i = 0; i<students.size(); i++) {
			i++;
		}
	}
	
	/**
	 * It takes two students (emails) as input and creates a friendship 
	 * relation between them. Keep in mind that friendship relation is a symmetric relationship.
	 * @param studentA
	 * @param studentB
	 */
	public void areFriends(String studentA, String studentB) {
	this.student = studentA;
	this.student = studentB; 

	LinkedList<LinkedList<Integer>;
		if (checkVertex(i)==null) {
			System.out.println("Nonexistent vertex  " + i);
			return null;
		}
		
		//gets the number of adjacent vertices
		int numAdj=lstAdjacents[i].size();
		//creates the array
		int[] adjVertices=new int[numAdj];
		//saves the adjacent vertices into the array
		for (int j=0; j<numAdj; j++) {
			adjVertices[j]=lstAdjacents[i].get(j).vertex;
		}
		//return the array with the adjacent vertices of i
		return adjVertices;
	}
	
	
	/**
	 * This takes a student (email), and returns an object of LinkedList<String>, 
	 * which contains the emails of his/her direct friends.
	 * @param studentA
	 * @return
	 */
	public LinkedList<String> getDirectFriends(String studentA){
		
		LinkedList<String> lDirectFriends = new LinkedList<String>();
		//to complete
		
		return lDirectFriends;
	}
	
	
	
	public int[] getAdjacents(int i) {
		
			if (checkVertex(i)==null) {
				System.out.println("Nonexistent vertex  " + i);
				return null;
			}
			
			int numAdj=lstAdjacents[i].size();
			int[] adjVertices=new int[numAdj];
			for (int j=0; j<numAdj; j++) {
				adjVertices[j]=lstAdjacents[i].get(j).vertex;
			}			
			return adjVertices;
		}

	
	
	public LinkedList<String> suggestedFriends(String studentA){
		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		//to complete
		return lSuggestedFriends;
	}
	
	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path=new LinkedList<Integer>();
		return depth(i,visited, path);
	}
	

	protected LinkedList<Integer> depth(int i,boolean[] visited, LinkedList<Integer> path) {
			System.out.print(i+"\t");
			visited[i]=true;
			int[] adjacents=getAdjacents(i);
			for (int adjV:adjacents) {
				if (!visited[adjV]) {
					depth(adjV,visited);
					
				}
			}
		}
	
				return depth;

	
	public void show() {

			for (int i=0; i<numVertices; i++) {
				for (int k=0; k<lstAdjacents[i].size();k++) {
					Adjacent obj=lstAdjacents[i].get(k);
					System.out.println("adjacents for " + i );
					System.out.println(obj.toString());
				}
			}
			
		}	
	
	public static void main(String args[]) {
		
	}
	
}
