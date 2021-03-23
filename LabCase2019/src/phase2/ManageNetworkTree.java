package phase2;

import phase1.StudentsList;

public class ManageNetworkTree implements IManageNetworkTree {


/**
 * It takes an object of the StudentsTree class 
 * and an object of the StudentsList class (phase 1),
 * and inserts each student from the list into the tree. 
 * The method does not return anything. 
 * @param tree
 * @param list
 */
public void copySocialNetwork(StudentsTree tree, StudentsList list) {
	
	int s=list.getSize();
	for(int i=0; i<s;i++) {
		tree.insertStudent(list.getAt(i));
	}
	
}
/**
 * This takes an object of the StudentsTree class and returns an object of the StudentsList class
 *  containing all the students in the tree ordered by their email. 
 *  Hint: You can develop an auxiliary and recursive method  
 *  which takes a BSTNode object and a StudentsList object. 
 *  You cannot use any sort algorithm to sort the resulting list. 
 *  To obtain the list, you must traverse the tree (or subtree) in a recursive way. 
 * @return
 */
public StudentsList getOrderedList(StudentsTree tree){
	
    StudentsList sL = new StudentsList();
    if(tree.root!=null) {
    sL=ord(tree.root,sL);
    }
    return sL;
}

public StudentsList ord(BSTNode nod, StudentsList li){
	if(nod.left!=null){
		ord(nod.left, li);
	}
	
	if(nod!=null) {
		li.addLast(nod.oStudent);
	}
	
	if(nod.right!=null){
		ord(nod.right, li);
	}
	
	return li;
	
}
/**
 * This class has a parameter n as input and removes all students having a number of blocks equal or greater than n.
 * @param num
 */

public void deleteByNumberOfBlocks(StudentsTree tree,int num) {
	
	tree=findnums(num,tree.root, tree);
	
	
}

public StudentsTree findnums(int num, BSTNode nod,StudentsTree tree) {
	if (nod == null) {
		//System.out.println("It's empty");
	} else {
		if (nod!=null) {
			findnums(num,nod.left, tree);}
		if (nod.oStudent.blocks>=num) {
			tree.removeStudent(nod.oStudent.email);}
		if (nod!=null) {
			findnums(num,nod.right, tree);}
	}
	return tree;
}



}
