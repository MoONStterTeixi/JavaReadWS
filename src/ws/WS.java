package ws;

public class WS {

    public static void main(String[] args) throws Exception {
        String JsonURL = "http://localhost/WebService/query.php?code=1111&action=getall";
        System.out.println("Get Json from: " + JsonURL);
        System.out.println("-----------------------------------------------------------------");
        Json json = new Json(JsonURL);
        
        System.out.println(json.toString());
        //System.out.println(json.getNum1() + "-->" + json.getNum2());
    }
    
}
