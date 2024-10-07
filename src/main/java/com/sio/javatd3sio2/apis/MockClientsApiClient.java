package com.sio.javatd3sio2.apis;

import com.sio.javatd3sio2.models.Client;
import com.sio.javatd3sio2.tools.ConfigManager;
import com.sio.javatd3sio2.tools.HttpRequestBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class MockClientsApiClient {
    private ConfigManager cm = new ConfigManager();
    private JSONParser parser = new JSONParser();

    public Client getClient(String siret) {
        try {
            HttpResponse<String> response = HttpRequestBuilder.get(cm.getProperty("mock.clients.api.url") + "/client/" + siret);
            System.out.println(response.body());

            JSONObject jsonItem = (JSONObject) parser.parse(response.body());
            JSONObject jsonClient = (JSONObject) jsonItem.get("client");

            return buildClientFull(jsonClient);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String,Object> getClients() {

        HashMap<String, Object> map = new HashMap<>();

        try {
            HttpResponse<String> response = HttpRequestBuilder.get(cm.getProperty("mock.clients.api.url") + "/clients");
            JSONObject jsonItem = (JSONObject) parser.parse(response.body());

            map.put("count", jsonItem.get("count"));

            ArrayList<Client> clients = new ArrayList<>();
            JSONArray jsonClients = (JSONArray) jsonItem.get("clients");
            for (Object item : jsonClients) {
                JSONObject jsonClient = (JSONObject) item;
                clients.add(buildClientOverview(jsonClient));
            }
            map.put("clients", clients);

            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean createClient(Client c){
        try {
            String data = buildJsonStringFromObject(c);
            HttpResponse<String> response = HttpRequestBuilder.post(cm.getProperty("mock.clients.api.url") + "/client",data);
            System.out.println(response.body());

            return response.statusCode() == 201;

//            JSONObject jsonItem = (JSONObject) parser.parse(response.body());
//            String message = (String) jsonItem.get("status");
//
//            System.out.println(jsonItem);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateClient(Client c){
        try {
            String data = buildJsonStringFromObject(c);
            System.out.println(data);
            HttpResponse<String> response = HttpRequestBuilder.put(cm.getProperty("mock.clients.api.url") + "/client/" + c.getSiret(),data);
            System.out.println(response.body());

            return response.statusCode() == 200;

//            JSONObject jsonItem = (JSONObject) parser.parse(response.body());
//            String message = (String) jsonItem.get("status");
//
//            System.out.println(jsonItem);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteClient(Client c){
        try {
            HttpResponse<String> response = HttpRequestBuilder.delete(cm.getProperty("mock.clients.api.url") + "/client/" + c.getSiret());
            System.out.println(response.body());

            return response.statusCode() == 200;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Client buildClientOverview(JSONObject jsonItem) {
        return new Client(
                (String) jsonItem.get("siret"),
                (String) jsonItem.get("raison_sociale")
        );
    }

    private Client buildClientFull(JSONObject jsonItem) {
        return new Client(
                (String) jsonItem.get("siret"),
                (String) jsonItem.get("raison_sociale"),
                (String) jsonItem.get("adresse"),
                (String) jsonItem.get("code_postal"),
                (String) jsonItem.get("ville")
        );
    }

    private String buildJsonStringFromObject(Client c){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("siret",c.getSiret());
        jsonObject.put("raison_sociale",c.getRaisonSociale());
        jsonObject.put("adresse",c.getAdresse());
        jsonObject.put("code_postal",c.getCodePostal());
        jsonObject.put("ville",c.getVille());

        return jsonObject.toString();
    }
}
