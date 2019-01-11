package diplom;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRequests {

    private ArrayList<String> innerRequestList = new ArrayList<>();
    private ArrayList<Client> clientsList = new ArrayList<>();
    private Map<String, Client> clients = new HashMap<>();

    Timer timer = new Timer();

    public String getHTMLrequest(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = result.replaceAll("\\[","").replaceAll("]","");
        return result;
    }

    public void Result(long timeFrom, long timeTo){
//        String URL = "http://new.welcome-tracker.ru/api.php?api=71e5367021e4c6cf091f34434e5e9458&from="
//                + timer.getTimeFrom() +  "&to=" + timer.getTimeTo();
        String URL = "http://new.welcome-tracker.ru/api.php?api=71e5367021e4c6cf091f34434e5e9458&from="
                + timeFrom +  "&to=" + timeTo;
        String result = getHTMLrequest(URL);
        if (!result.equals("")){
        String element = null;
        String[] delimit = result.split("},");
        for (int i = 0; i < delimit.length; i++) {
            StringBuilder sb = new StringBuilder();
            element = delimit[i].replaceAll("}", "");
            sb = sb.append(element).append("}");
            element = sb.toString();
            innerRequestList.add(element);
            createClients(element);
        }
        }
    }

    public void createClients(String s){
        if (s != null){
//                try {
//                    JSONObject json = new JSONObject(s);
                    JsonParser json = new JsonParser(s);
//                    System.out.println(json);
                    String phone = phone(json.get("phone").toString());
                    String ref = ref(json.get("ref").toString());
                    String site = site(json.get("site").toString());
                    Client client = new Client(phone, ref, site);
//                    System.out.println(client);
                    clients.put(client.getPhoneFirst(), client);
                    clientsList.add(client);
//                    System.out.println(clients.get(phone));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
    }

    private String phone(String s){
        String rez = s.replaceAll("pP","").replaceAll("\\D","");
        if (rez.length() < 11){
            rez = "";
        }
        return rez;
    }

    private String ref(String s){
        String rez = s;
        return rez;
    }

    private String site(String s){
        String rez = "";
        if (s.contains("http://petrobani.ru/")){
            rez = "http://petrobani.ru/";
        }
        if (s.contains("http://petrobitovki.ru/")){
            rez = "http://petrobitovki.ru/";
        }
        if (s.contains("http://petro-blok.ru/")){
            rez = "http://petro-blok.ru/";
        }
        return rez;
    }

    public void printClients(){
        System.out.println(clients);
    }

    public void printClientList(){
        System.out.println(clientsList);
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }
}
