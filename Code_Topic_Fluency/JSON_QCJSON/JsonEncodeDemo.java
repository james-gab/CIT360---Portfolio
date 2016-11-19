package TestingJSON;
/**
 * @author gab
 * SandBox code
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonEncodeDemo {

   public static void main(String[] args){
      JSONObject obj = new JSONObject();
      JSONArray list = new JSONArray();
	list.add("msg 1");
	list.add("msg 2");
	list.add("msg 3");
	list.add("msg 6");
	list.add("msg 5");
	list.add("msg 4");
	list.add("msg 3");

      obj.put("aname", "foo");
      obj.put("num", 100);
      obj.put("balance", 1000.21);
      obj.put("is_vip", true);

//The output for each JSON variable is on one line 
//regardless of which screen output command is used
      System.out.println(obj);
      System.out.println(list);
      System.out.print(obj);
      System.out.print(list);
   }
}
