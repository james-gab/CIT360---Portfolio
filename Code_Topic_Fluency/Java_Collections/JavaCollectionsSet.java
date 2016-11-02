
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
public class JavaCollectionsSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashSet ashoeSet = new HashSet();
        HashSet backupSet = new HashSet();
        HashSet anotherSet = new HashSet();
        ashoeSet.add("Puma");
        ashoeSet.add("Converse");
        ashoeSet.add("Nike");
        ashoeSet.add("Diesel");
        ashoeSet.add("Nike");       // Duplicate, this will not be added
        ashoeSet.add("Skechers");
        ashoeSet.add("Under Armour");
        ashoeSet.add("Nike");       // Duplicate, this will not be added
        ashoeSet.add("Brooks");
        ashoeSet.add("Saucony");
        
        
        // copy ashoeSet to backupSet
        backupSet.addAll(ashoeSet);
        
        // Check to see if the Sets are empty
        System.out.println();
        System.out.println("Elements in the ashoeSet Set ");
        if(ashoeSet.isEmpty()){
            System.out.println("The ashoeSet is empty");
        } else {
            System.out.println(ashoeSet);
        }
        System.out.println();
        System.out.println("Elements in the backupSet Set ");
        if(backupSet.isEmpty()){
            System.out.println("The backupSet is empty");
        } else {
            System.out.println(backupSet);
        }
        System.out.println();
        System.out.println("Elements in the anotherSet Set ");
        if(anotherSet.isEmpty()){
            System.out.println("The anotherSet is empty");
        } else {
            System.out.println(anotherSet);
        }
        
        
        System.out.println();
        System.out.println();

        // Iterate a Set
        Iterator alinkedSet = ashoeSet.iterator();
        System.out.println("An Iterated Set:");
        while(alinkedSet.hasNext()){
            Object printit = alinkedSet.next();
            System.out.print(printit + " ");
        }
        
        System.out.println();
        System.out.println();
        
        
        System.out.println("I don't like Nike let's get rid of it from the Set");
        System.out.println("using a standard remove() statment");
        ashoeSet.remove("Nike");
        System.out.println();
        System.out.println("Nike is now gone from the Set");
        System.out.println(ashoeSet);
        
        // Copy a Set to another Set
        
        for(int i=0; i<ashoeSet.size(); i++){
            anotherSet.add(i);
        }
        System.out.println();
        System.out.println("Elements now in the anotherSet Set ");
        if(anotherSet.isEmpty()){
            System.out.println("The anotherSet is empty");
        } else {
            System.out.println(anotherSet);
        }
        
        
        System.out.println("Adding the contents of ashoeSet to the anotherSet");
        anotherSet.addAll(ashoeSet);
        System.out.println("Updated elements now in the anotherSet Set ");
        System.out.println(anotherSet);
        
        System.out.println();
        System.out.println("What a mess you can make of Sets");
    
        // Remove by Iterator
        for(int i=0; i<ashoeSet.size(); i++){
            anotherSet.remove(i);
        }
        System.out.println("Removing Elements with Iterator");
        System.out.println("Updated elements now in the anotherSet Set ");
        System.out.println(anotherSet);
        
        System.out.println();
        
        
        
        
        
        
        
    }    
    
}
