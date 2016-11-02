

// http://tutorials.jenkov.com/java-collections/list.html

import java.util.*;

/**
 *
 * @author gab James 
 * CIT 360 ~ 01
 * 
 * instructions
 * Java Collections (one each of Map, List, Set, and Tree Types), Addition, Removal, using Iterators.
 * 
 */
public class JavaCollectionsList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List ashoelist = new ArrayList();
        List backuplist = new ArrayList();
        List alinkedlist = new LinkedList();
        ashoelist.add("Puma");
        ashoelist.add("Converse");
        ashoelist.add("Nike");
        ashoelist.add("Diesel");
        ashoelist.add("Nike");
        ashoelist.add("Skechers");
        ashoelist.add("Under Armour");
        ashoelist.add("Nike");
        ashoelist.add("Brooks");
        ashoelist.add("Saucony");
        
        
        System.out.println("Adding elements from the ashoelist to the backuplist");
        System.out.println("using a standard for loop to iterate the List");
//        Collections.copy(backuplist, ashoelist);
        for(int i=0; i < ashoelist.size(); i++) {
            Object obj = ashoelist.get(i);
                backuplist.add(obj);
        }
        
        // List the array on the screen
        System.out.println("Elements in the ashoelist ArrayList ");
        System.out.println("\t" + ashoelist);
        
        // List the array on the screen
        System.out.println("Elements in the backuplist ArrayList ");
        System.out.println("\t" + backuplist);
        
        // Pick an Element to remove using remove(int index)
        System.out.println("The 5th Element is: " + ashoelist.get(4));
        System.out.println("I don't like " + ashoelist.get(4) + " let's get rid of it from the list");
        ashoelist.remove(4);
        
        System.out.println("Elements in the revised ashoelist ArrayList ");
        System.out.println("\t" + ashoelist);
        
        // Pick an Element to remove using remove(Object element)
        System.out.println("1 of that shoe is gone but there are ");
        System.out.println("still several in the list.");
        
        //Using a standard for loop to iterate the List
        System.out.println("I don't like Nike let's get rid of it from the list");
        System.out.println("using a standard for loop to iterate the List");
        
        for(int i=0; i < ashoelist.size(); i++) {
            Object obj = ashoelist.get(i);
            if (obj == "Nike"){
                ashoelist.remove("Nike");
            }
        }
        
        System.out.println("All gone now. ");
        System.out.println("\t" + ashoelist);
        System.out.println();
        System.out.println();
        

        
        
        for(int i=0; i < ashoelist.size(); i++) {
            Object obj = ashoelist.get(i);
                alinkedlist.add(obj);
        }


        // Iterating a list
        Iterator newlist = alinkedlist.iterator();
        
        
        System.out.println("Original List: ");
        System.out.print("        [  ");
//        System.out.println("\t" + backuplist);
        for(int i=0; i < backuplist.size(); i++) {
            Object printit = backuplist.get(i);
            System.out.print(printit + "  ");
            
        }
        System.out.print("]");
        System.out.println();
        System.out.println();
        
        // outputing an Iterated list
        System.out.println("New List: ");
        System.out.print("        [  ");
        while(newlist.hasNext()){
            Object printit = newlist.next();
            System.out.print(printit + "  ");
        }
        System.out.print("]");
        System.out.println();
        
        
        
        
         
        
        
        
        
    }
    
}
