import java.net.*;
import java.io.*;

public class httpURLConnections {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("https://en.wikipedia.org/wiki/Roman_Empire");
        URLConnection yc = oracle.openConnection();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        }
    }
}
