package diplom;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SetRequests {

    private ArrayList<String> jsonObjects = new ArrayList<>();
    GetRequests getR = new GetRequests();

    public void createJSON(){
        ArrayList<Client> clients = getR.getClientsList();
        for (Client c : clients){
            JSONObject json = new JSONObject();
            try {
                json.put("firstPhone", c.getPhoneFirst());
                json.put("secondPhone", c.getPhoneSecond());
                json.put("ref", c.getRef());
                json.put("site", c.getSite());
                json.put("time", c.getTime());
                jsonObjects.add(json.toString());
                System.out.println(jsonObjects.get(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
