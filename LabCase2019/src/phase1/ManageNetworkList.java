package phase1;

import java.time.LocalDate;

import java.util.Collections; 

import java.util.List; 


public class ManageNetworkList implements IManageNetworkList{

	
	/**
	 *  The methods must join two social networks into a single social network. 
	 *  The method takes two objects of the StudentsList and returns a new list containing 
	 *  first the students from the first list followed by the students from the second list. 
	 * @param lst1
	 * @param lst2
	 * @return
	 */
	public StudentsList union(StudentsList lst1, StudentsList lst2) {

		
		StudentsList resultList=new StudentsList();
		
		for(int i=0; i<lst1.size; i++) {
			Student s= lst1.getAt(i);
			resultList.addLast(s);
		
		}
		for (int i=0; i<lst2.size; i++) {
			Student s= lst2.getAt(i);
			if (!resultList.contains(s)) {
			resultList.addLast(s);}
			
		}
		return resultList;
	}
	
	
	/**
	 * 3. This methods takes a social network as input and an integer parameter opc so that:
		- If opc =1: the method must return a StudentsList containing all the students residing
			in the same city that the campus where they are studying.
		- If opc =2: the method must return a StudentsList containing all the students residing
			in cities different that the one where their campus is located.
	 * @param lst1
	 * @param lst2
	 * @param opc
	 * @return
	 */
	public StudentsList getCampusCity(StudentsList lst, int opc) {
	
	StudentsList resultList= new StudentsList();
	if (lst== null) 
		return resultList;
	if (opc!=1 && opc!=2 )
		return lst;


		if(opc==1) {
			for(int i=0; i<lst.getSize(); i++) {
			Student	s = lst.getAt(i);
				if(s.campus.toString().equals(s.city) && (s.campus !=null) && (s.city!=null)) {
						resultList.addLast(s); 
				
					
				}
			}
		}
		if(opc==2){
			for(int i=0; i<lst.getSize(); i++) {
			Student	s = lst.getAt(i);
			if(!s.campus.toString().equals(s.city) && (s.campus!=null) && (s.city!=null)) {
					resultList.addLast(s);
			
		}
			}
		}
		return resultList;
		
	}

	/**
	 * 4. This method takes a social network as input and a integer parameter opc so that: 
			- If opc=1, the method returns a list of students sorted by ascending
			order according to their full name.
			- If opc=2, the method returns a lit of students sorted by descending
			order according to their full name. 
		Note 1. You must implement your own sort method based on some of the sorted algorithms (such as bubble, sort). 
		Note 2: Remember that you cannot modify or extend the StudentsList class. Therefore, if you need an auxiliary method that help you to sort the list, please include this method into the ManageNetwork class. 
		Note 3. The input list cannot be modified. The method must return a new list where the students are sorted.
	 * @param lst
	 * @param opc
	 * @return
	 */
	public StudentsList orderBy(StudentsList lst, int opc) {
		
		StudentsList sortedList= lst; {		
		}
		if(opc==1) {
				 int n = sortedList.getSize(); 
			        for (int i = 0; i < n; i++) {
			            for (int j = 0; j < n-i-1; j++) {
			                //if (arr[j] > arr[j+1])
			                if((sortedList.getAt(j).email.compareTo(sortedList.getAt(j+1).email))>0)
			                { 
			                    // swap arr[j+1] and arr[i] 
			                    Student temp1 = sortedList.getAt(j); 
			                    Student temp2 = sortedList.getAt(j+1);
			                    sortedList.removeAt(j);
			                    sortedList.removeAt(j);
			                    sortedList.insertAt(j, temp1);
			                    sortedList.insertAt(j, temp2);
			                }
			        }
			        }			        
				}
		else if(opc==2){
			 int n = sortedList.getSize(); 
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < n-i-1; j++) {
		                //if (arr[j] > arr[j+1])
		                if((sortedList.getAt(j).email.compareTo(sortedList.getAt(j+1).email))<0)
		                { 
		                	System.out.println(sortedList.toString());
		                    // swap arr[j+1] and arr[i] 
		                    Student temp1 = sortedList.getAt(j); 
		                    Student temp2 = sortedList.getAt(j+1);
		                    sortedList.removeAt(j);
		                    sortedList.removeAt(j);
		                    sortedList.insertAt(j, temp1);
		                    sortedList.insertAt(j, temp2);
		                }
		        }
		        }
	}return sortedList;	
		}
		
	
	
	
	/**
	 * This methods takes a social network (that is an object of StudentsList class) 
	 * and a city name as input and returns a list containing all the students 
	 * (that is, an object of the StudentsList class) who live in that city.
	 * @param lst
	 * @param city
	 * @return
	 */
	public StudentsList locateByCity(StudentsList lst, String city) {
		
		StudentsList list = new StudentsList();
	
		for (int i= 0; i<lst.size; i++) {		
			if (city.equals(lst.getAt(i).city)) {
				list.addLast(lst.getAt(i));
			}
			
		}
		return list;
		}

	
	
	/**
	 * This takes a social network (an object of the StudentsList class) and two dates 
	 * and returns the list of all students from the input list 
	 * whose registration dates are in the interval of input dates. 
	 * Please, take into account the following comments:
		- start <= end. 
		- Both dates are included into the interval.
		- The order in the resulting list must be the same that in the input list.

	 * @param lst
	 * @param start
	 * @param end
	 * @return
	 */
	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end) {
		
		StudentsList resultList=new StudentsList();

		for (int i =0; i<lst.size; i++) {
			Student aux =lst.getAt(i);
			LocalDate auxDate= aux.date_sign_in;
			//if (auxDate.equals(start) && auxDate.equals(end)) {
			if (auxDate.compareTo(start)>0 && auxDate.compareTo(end)<0) {
				resultList.addLast(aux);
			
			}
		}
		return resultList;
	
	}
	
	
	
	public static void main(String[] args) {
		
		StudentsList lst1 = new StudentsList();
		StudentsList lst2 = new StudentsList();

	Student s1= new Student("alum1@uc3m.es", "COLMENAREJO", Student.Campus.LEGANES, LocalDate.of(2018, 3, 24));
	Student s2= new Student("alum2@uc3m.es", "GETAFE", Student.Campus.LEGANES, LocalDate.of(2016, 3, 20));
	Student s3= new Student("alum3@uc3m.es", "MADRID", Student.Campus.GETAFE, LocalDate.of(2016, 2, 5));
	Student s4= new Student("alum4@uc3m.es", "LEGANES", Student.Campus.COLMENAREJO, LocalDate.of(2018, 3, 24));
	Student s5= new Student("alum5@uc3m.es", "ALCORCON", Student.Campus.GETAFE, LocalDate.of(2017, 9, 14));
	Student s6= new Student("alum6@uc3m.es", "MADRID", Student.Campus.LEGANES, LocalDate.of(2018, 10, 12));

	lst1.addLast(s3);
	lst1.addLast(s2);
	lst1.addLast(s1);
	lst2.addLast(s5);
	lst2.addLast(s4);
	lst2.addLast(s6);
	
	ManageNetworkList m = new ManageNetworkList();
	StudentsList resultList= null;
	
	resultList= m.union(lst1, lst2);
	System.out.println("Result of union:/n" + resultList.toString());
	System.out.println();
	
	/*resultList= m.getCampusCity(lst1, 1);
	System.out.println("Result of getCampusCity (opc=1, city=campus): /n" + resultList.toString());
	System.out.println();
	resultList= m.getCampusCity(lst1, 2);
	System.out.println("Result of getCampusCity (opc=2, city!=campus): /n" + resultList.toString());
	System.out.println();*/
		
	System.out.println(resultList.toString());
	System.out.println(m.orderBy(resultList,2).toString());
	
	
	}

}
