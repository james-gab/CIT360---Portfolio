
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
public class JavaCollectionsMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap ashoeMap = new HashMap();
//        HashMap backupSet = new HashMap();
//        HashMap anotherSet = new HashMap();
        System.out.println("Adding Puma, 8 an an Elements in the ashoeMap Map");
        ashoeMap.put("Puma", 8);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Converse, 7 an an Elements in the ashoeMap Map");
        ashoeMap.put("Converse", 7);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Nike, 10 an an Elements in the ashoeMap Map");
        ashoeMap.put("Nike", 10);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Diesel, 6 an an Elements in the ashoeMap Map");
        ashoeMap.put("Diesel", 6);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Nike, 1 an an Elements in the ashoeMap Map");
        ashoeMap.put("Nike", 1);       // Duplicate, this will overwire the first
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Skechers, 2 an an Elements in the ashoeMap Map");
        ashoeMap.put("Skechers", 2);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Under Armour, 3 an an Elements in the ashoeMap Map");
        ashoeMap.put("Under Armour", 3);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Nike, 9 an an Elements in the ashoeMap Map");
        ashoeMap.put("Nike", 9);       // Duplicate, this will overwire any already added
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Brooks, 4 an an Elements in the ashoeMap Map");
        ashoeMap.put("Brooks", 4);
        System.out.print("\t" + ashoeMap);
        System.out.println();
        System.out.println();
        System.out.println("Adding Saucony, 5 an an Elements in the ashoeMap Map");
        ashoeMap.put("Saucony", 5);
        System.out.print("\t" + ashoeMap);
        
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Elements in the ashoeMap Map");
        System.out.print("\t" + ashoeMap);
        
        
        
        System.out.println();
        System.out.println();
        
        // Lets loop or Iterate through the Map
        System.out.println("Iterate elements in the ashoeMap Map");
        System.out.print("        { ");
        for (Iterator it = ashoeMap.entrySet().iterator(); it.hasNext();) {
            Object printit = it.next();
            System.out.print(printit + "  ");
        }
        System.out.print(" }");
        
        System.out.println();
        System.out.println();
        
        // Lets loop or Iterate through the Map
        System.out.println("Not a Nike Fan, let Iterate the elements to change the 9 to a 10 in ashoeMap Map");
        for (Iterator it = ashoeMap.entrySet().iterator(); it.hasNext();) {
            // Map does not support a partial search of elements BUT
            // by converting the element to a string you can search
            // for a partial word with contains()
            if(it.next().toString().contains("Nike")){
                ashoeMap.put("Nike", 10);
            }
        }
        
        System.out.print("        { ");
        for (Iterator it = ashoeMap.entrySet().iterator(); it.hasNext();) {
            Object printit = it.next();
            System.out.print(printit + "  ");
        }
        System.out.print(" }");
        
        System.out.println();
        System.out.println();
        
        
        
        // Lets loop or Iterate through the Map
        System.out.println("Still not a Nike Fan, let Iterate the elements to remove it from ashoeMap Map");
        for (Iterator it = ashoeMap.entrySet().iterator(); it.hasNext();) {
            // Map does not support a partial search of elements BUT
            // by converting the element to a string you can search
            // for a partial word with contains()
            if(it.next().toString().contains("Nike")){
                it.remove();
            }
        }
        
        
        
        System.out.print("        { ");
        for (Iterator it = ashoeMap.entrySet().iterator(); it.hasNext();) {
            Object printit = it.next();
            System.out.print(printit + "  ");
        }
        System.out.print(" }");
        
        System.out.println();
        System.out.println();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
