/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingJSON;

/**
 *
 * @author gab
 * 
 * SandBox code
 * 
 */
    
    import org.json.simple.JSONObject;

public class JsonEncodeDemo {

   public static void main(String[] args){
      JSONObject obj = new JSONObject();

      obj.put("aname", "foo");
      obj.put("num", new Integer(100));
      obj.put("balance", new Double(1000.21));
      obj.put("is_vip", new Boolean(true));

      System.out.print(obj);
   }
}
