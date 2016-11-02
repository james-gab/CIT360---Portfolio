
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
public class JavaCollectionsTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TreeSet ashoeTreeSet = new TreeSet();
        TreeSet backupTreeSet = new TreeSet();
        TreeSet anotherTreeSet = new TreeSet();
        ashoeTreeSet.add("Puma");
        ashoeTreeSet.add("Converse");
        ashoeTreeSet.add("Nike");
        ashoeTreeSet.add("Diesel");
        ashoeTreeSet.add("Nike");       // Duplicate, this will not be added
        ashoeTreeSet.add("Skechers");
        ashoeTreeSet.add("Under Armour");
        ashoeTreeSet.add("Nike");       // Duplicate, this will not be added
        ashoeTreeSet.add("Brooks");
        ashoeTreeSet.add("Saucony");
        
        // copy ashoeTreeSet to backupTreeSet
        System.out.println();
        System.out.println("Adding Elements in the ashoeTreeSet Set to the backupTreeSet");
        backupTreeSet.addAll(ashoeTreeSet);
        
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the ashoeTreeSet Set ");
        if(ashoeTreeSet.isEmpty()){
            System.out.println("The ashoeTreeSet is empty");
        } else {
            System.out.println(ashoeTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupTreeSet Set ");
        if(backupTreeSet.isEmpty()){
            System.out.println("The backupTreeSet is empty");
        } else {
            System.out.println(backupTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherTreeSet Set ");
        if(anotherTreeSet.isEmpty()){
            System.out.println("The anotherTreeSet is empty");
        } else {
            System.out.println(anotherTreeSet);
        }
        
        
        System.out.println();
        System.out.println();
        System.out.println("I can tell you the first and last element in the ashoeTreeSet TreeSet");
        
        System.out.println("The First Element is: " + ashoeTreeSet.first());
        System.out.println("The First Element is: " + ashoeTreeSet.last());
        
        System.out.println();
        System.out.println();
        System.out.println("I can rearrange the TreeSet in ascending order:");
        System.out.print("        { ");
        
        Iterator iteratedshoeTreeSet;
        iteratedshoeTreeSet = ashoeTreeSet.iterator();
        while (iteratedshoeTreeSet.hasNext()){
            System.out.print(iteratedshoeTreeSet.next() + "  ");
        }
        System.out.print(" } ");
        System.out.println();
        System.out.println();
        System.out.println("Or Decending order:");
        System.out.print("        { ");
        
        iteratedshoeTreeSet = ashoeTreeSet.descendingIterator();
        while (iteratedshoeTreeSet.hasNext()){
            System.out.print(iteratedshoeTreeSet.next() + "  ");
        }
        System.out.print(" } ");
        System.out.println();
        System.out.println();
        
        
        System.out.println("I will remove Nike from the list because I am not a Nike fan.");
        ashoeTreeSet.remove("Nike");
        System.out.println();
        System.out.println();
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the ashoeTreeSet Set ");
        if(ashoeTreeSet.isEmpty()){
            System.out.println("The ashoeTreeSet is empty");
        } else {
            System.out.println(ashoeTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupTreeSet Set ");
        if(backupTreeSet.isEmpty()){
            System.out.println("The backupTreeSet is empty");
        } else {
            System.out.println(backupTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherTreeSet Set ");
        if(anotherTreeSet.isEmpty()){
            System.out.println("The anotherTreeSet is STILL empty");
        } else {
            System.out.println(anotherTreeSet);
        }
        
        
        System.out.println();
        System.out.println("Adding Elements in the ashoeTreeSet Set to the anotherTreeSet");
        anotherTreeSet.addAll(ashoeTreeSet);
        
        System.out.println();
        System.out.println("Clearing the ashoeTreeSet TreeSet");
        ashoeTreeSet.clear();
        
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the ashoeTreeSet Set ");
        if(ashoeTreeSet.isEmpty()){
            System.out.println("The ashoeTreeSet is empty");
        } else {
            System.out.println(ashoeTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupTreeSet Set ");
        if(backupTreeSet.isEmpty()){
            System.out.println("The backupTreeSet is empty");
        } else {
            System.out.println(backupTreeSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherTreeSet Set ");
        if(anotherTreeSet.isEmpty()){
            System.out.println("The anotherTreeSet is STILL empty");
        } else {
            System.out.println(anotherTreeSet);
        }
        
        
        System.out.println();
        
        
        
    }
    
}
