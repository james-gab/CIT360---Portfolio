
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author gab
 */
public abstract class TheJSONTest implements Runnable {
    
    public static void main(String[] args) throws MalformedURLException{
        
    
        Integer numBer = 1;
 
        
        URL Url = new URL("https://qrng.anu.edu.au/API/jsonI.php?length="+ numBer + "&type=uint8&#8217");
        
        try{
            HttpURLConnection urlConnection = (HttpURLConnection) Url.openConnection();
            InputStream stream = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                result.append(line);
            }
            
            JSONObject aJSONObject = new JSONObject(result.toString());
  
            System.out.println("The original Data:                  " + result + "\n");
            System.out.println("The Data Converted to a JSONObject: " + aJSONObject+ "\n");
            System.out.println("The JSONObject data:[] value:       " + aJSONObject.get("data") + "\n\n");
            
            JSONArray theJSONArray = aJSONObject.getJSONArray("data");
            
            System.out.println("Elements in the theJSONArray ArrayList ");
            System.out.println("\t" + theJSONArray);
            
            List aJSONCastNumberToList = new ArrayList();

            System.out.println("Elements in the theJSONArray ArrayList iterated to a List ");
            for (int j = 0; j < theJSONArray.length(); j++) {
                 aJSONCastNumberToList.add(theJSONArray.get(j));
            }

            System.out.println("Elements in the aJSONCastNumberToList List");
            System.out.println("\t" + aJSONCastNumberToList);
            
//            Integer num = Integer.parseInt(aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", ""));
//            System.out.println("The JSONObject.data Parsed as an Long Integer: " + num + "\n\n");
            
//            String aNumString = aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "");
            
//            System.out.println("The JSONObject.data converted to a string: " + aNumString + "\n\n");
            System.out.println("The JSONObject.data converted to a string: " + aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "") + "\n\n");
            
            int aaJSONObjectToNumber = 0;
            int aJSONObjectlength = 3;
            
            if (aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "").length() < 3 ){
                aJSONObjectlength = aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "").length();
            }
            
            for (int i = 0; i < aJSONObjectlength; i++){
                aaJSONObjectToNumber = aaJSONObjectToNumber + Integer.parseInt(Character.toString(aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "").charAt(i)));
            }
            
            System.out.println("The first " + aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "").length() + " JSONObject.data numbers added together: " + aaJSONObjectToNumber + "\n\n");
//            System.out.println("divided by 1: " + aaJSONObjectToNumber/aJSONObject.length());
//            System.out.println("divided by 2: " + aaJSONObjectToNumber/2);
//            System.out.println("divided by 3: " + aaJSONObjectToNumber/3);
//            System.out.println("divided by 4: " + aaJSONObjectToNumber/4);
//            System.out.println("divided by 5: " + aaJSONObjectToNumber/5);
//            System.out.println("divided by 6: " + aaJSONObjectToNumber/6);

System.out.println(aJSONObject.get("data").toString().replace("[", "").replace("]", "").replace(",", "").length());
            
            if (aaJSONObjectToNumber/aJSONObject.length() < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/aJSONObject.length() + "\n\n");
            } else if (aaJSONObjectToNumber/1 < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/1 + "\n\n");
            } else if (aaJSONObjectToNumber/2 < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/2 + "\n\n");
            } else if (aaJSONObjectToNumber/3 < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/3 + "\n\n");
            } else if (aaJSONObjectToNumber/4 < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/4 + "\n\n");
            } else if (aaJSONObjectToNumber/5 < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/5 + "\n\n");
            } else if(aaJSONObjectToNumber/6 < 6){
                System.out.println("A 1D6 dice roll: " + aaJSONObjectToNumber/6 + "\n\n");
            }
            
            
            
            
            
            
            
        }catch(IOException | JSONException e){
                    System.out.print("Exception found, you screwed up something!!!");
        }
        
    }



    
}
