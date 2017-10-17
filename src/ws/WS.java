package ws;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;



public class WS {

    public static void main(String[] args) throws Exception {
       String JsonURL = "http://localhost/WebService/Consultas.php?format=json&code=1111&action=SelectDatos";
        System.out.println("Get Json from: " + JsonURL);
        System.out.println("-----------------------------------------------------------------");
        String JsonString = callURL(JsonURL);
        Gson gson = new Gson();
        ObjetoT json = gson.fromJson(JsonString, ObjetoT.class);  
        System.out.println(json.getNum1() + "-->" + json.getNum2());
    }
    public static String callURL(String myURL) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
}
