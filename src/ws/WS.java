package ws;

import com.google.gson.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class WS {

    public static void main(String[] args) throws Exception {

        InsertT();
        //SelectT();
    }
    
    public static void InsertT() throws MalformedURLException, IOException{
        String myURL = "http://localhost/WebService/query.php?code=1111&action=insertarnums&num1=2&num2=2";
        System.out.println("Post Json from: " + myURL);
        System.out.println("-----------------------------------------------------------------");
        HttpClient client = new HttpClient();
    }
    
    public static void SelectT(){
        String JsonURL = "http://localhost/WebService/query.php?code=1111&action=getall";
        System.out.println("Get Json from: " + JsonURL);
        System.out.println("-----------------------------------------------------------------");
        Json json = new Json(JsonURL);
        //String json = "{\"posts\":[{\"post\":{\"num1\":\"3\",\"num2\":\"1\"}}]}";
        System.out.println(json.toString());
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json.toString(), JsonObject.class);
        ObjetoT hson = new ObjetoT(jsonObject.get("num1").toString(), jsonObject.get("num2").toString());
        System.out.println(hson.toString());
    }
    
}
