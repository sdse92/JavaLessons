package diplom;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SetRequests {

    private ArrayList<String> jsonObjects = new ArrayList<>();
    GetRequests getR;

    public SetRequests(GetRequests getR) {
        this.getR = getR;
    }

    public void createJSON(){
        ArrayList<Client> clients = getR.getClientsList();
        for (Client c : clients){
//            JSONObject json = new JSONObject();
            JsonParser json = new JsonParser();
//            try {
                json.put("firstPhone", c.getPhoneFirst());
                json.put("secondPhone", c.getPhoneSecond());
                json.put("ref", c.getRef());
                json.put("site", c.getSite());
                json.put("time", c.getTime());
                jsonObjects.add(json.toString());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void printJson(){
        System.out.println(jsonObjects);
    }
}
