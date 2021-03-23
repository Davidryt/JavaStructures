package phase3;

import java.util.LinkedList;




public class ManageNetworkGraph implements IManageNetworkGraph {
	
	
	
	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;
		
	public ManageNetworkGraph(String[] students) {
			this.students=new LinkedList<String>();
			for(int k=0; k < students.length; k++) {
				this.students.add(students[k]);
			}
			
			//we must initialize each Integer list
			//each index i corresponds to a student, the function
			//getIndex is used to obtain the correspondence
			lst_of_lstAdjacents=new LinkedList<LinkedList<Integer>>();
			int num=this.students.size();
			for (int i=0; i<num; i++) {
				lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
			}
	}
	
	//searches the student and returns its index
	public int getIndex(String student) {
		int index=-1;
		for (int pos=0; pos<this.students.size();pos++) {
			if (this.students.get(pos).equals(student)) {
				index=pos;
			}
		}
		return index;
	}
	//checks if index is right and returns its associated city
	public String checkVertex(int index) {
		//to complete
		return null;
	}
	
	/**
	 * It takes taking two students (emails) as input and 
	 * creates a friendship relation between them. 
	 * Keep in mind that friendship relation is a symmetric relationship.
	 */
	public void addStudent(String student) {
		
		if(student!=null) {
		this.students.addLast(student);
		this.lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
		}
	}
	
	/**
	 * It takes two students (emails) as input and creates a friendship 
	 * relation between them. Keep in mind that friendship relation is a symmetric relationship.
	 * @param studentA
	 * @param studentB
	 */
	public void areFriends(String studentA, String studentB) {
	
		int n1 = this.getIndex(studentA);
		int n2 = this.getIndex(studentB);
		if(n1!=-1 && n2!=-1) {
		this.lst_of_lstAdjacents.get(n1).addLast(n2);
		this.lst_of_lstAdjacents.get(n2).addLast(n1);
		}
	}

	/**
	 * This takes a student (email), and returns an object of LinkedList<String>, 
	 * which contains the emails of his/her direct friends.
	 * @param studentA
	 * @return
	 */
	public LinkedList<String> getDirectFriends(String studentA){
		
		LinkedList<String> lDirectFriends = new LinkedList<String>();
		int n1=this.getIndex(studentA);
		if(n1!=-1) {
		String name;
		for (int i =0; i<this.lst_of_lstAdjacents.get(n1).size(); i++) {
			name=this.students.get(this.lst_of_lstAdjacents.get(n1).get(i));
			lDirectFriends.addLast(name);
		}
		}
		return lDirectFriends;
	}
	
	
	
	public int[] getAdjacents(int i) {
		int size = this.lst_of_lstAdjacents.get(i).size();
		int[] result = new int[size];
		Integer[] temp = this.lst_of_lstAdjacents.get(i).toArray(new Integer[size]);
		for (int n = 0; n < size; ++n) {
		    result[n] = temp[n];
		}
		return result;
	}
	
	
	
	public LinkedList<String> suggestedFriends(String studentA){
		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		int n1=this.getIndex(studentA);
		if(n1!=-1) {
		boolean visited[]=new boolean[this.students.size()];
		LinkedList<Integer> path=this.depth(n1, visited);
		for(int i=0; i<path.size();i++) {
			for(int j=0; j<this.lst_of_lstAdjacents.get(n1).size();j++) {
				if(path.get(i)==this.lst_of_lstAdjacents.get(n1).get(j)) {
					path.remove(i);
				}
			}
		}
		for(int i=0; i<path.size();i++) {
			if(path.get(i)!=n1) {
			lSuggestedFriends.addLast(this.students.get(path.get(i)));
			}
		}
		}
		return lSuggestedFriends;
	}
	
	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path=new LinkedList<Integer>();
		return depth(i,visited, path);
	}
	

	protected LinkedList<Integer> depth(int i,boolean[] visited, LinkedList<Integer> path) {
		path.addLast(i);
		visited[i]=true;
		int[]adj=this.getAdjacents(i);
		for(int a2:adj) {
			if(!visited[a2]) {
				this.depth(a2, visited, path);
			}
		}
		return path;
	}
	
	public void show() {
		//to complate
	}
	
	public static void main(String args[]) {
		String s1[]={"fran",
				"luisa", "manu","ricky","david",
				"maria","elena","juan","isabel","pedro","edu"};
		ManageNetworkGraph graph=new ManageNetworkGraph(s1);
		System.out.println(graph.getIndex("manu"));
		
		graph.areFriends("luisa", "manu");
		graph.areFriends("luisa", "isabel");
		graph.areFriends("isabel", "ricky");
		graph.areFriends("pedro", "juan");
		graph.areFriends("ricky", "edu");
		
		System.out.println(graph.getDirectFriends("luisa").get(0));
		System.out.println(graph.getDirectFriends("luisa").get(1));
		/*System.out.println(graph.getDirectFriends("fran").get(2));

		
		System.out.println(graph.getAdjacents(0)[0]);
		System.out.println(graph.getAdjacents(0)[1]);
		System.out.println(graph.getAdjacents(0)[2]);*/
		
		System.out.println(graph.suggestedFriends("luisa").toString());
	}
	
}
