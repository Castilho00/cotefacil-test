package com.castilho.cotefaciltest.services;

import com.castilho.cotefaciltest.entities.SwInfo;
import com.castilho.cotefaciltest.repository.SwRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@ManagedBean
@ViewScoped
public class SwService {

    private final String startUrlApi = "https://swapi.dev/api/";

    private final String endUrlApi = "?format=json";

    @Autowired
    private SwRepository repository;

    public long getCount(){
        return repository.count();
    }

    public List<SwInfo> findAll(){
        return repository.findAll();
    }

    public SwInfo findById(Integer id){
        Optional<SwInfo> obj = repository.findById(id);
        return obj.get();
    }

    public SwInfo findByName(String name){
        return repository.findByName(name);
    }

    public SwInfo save(SwInfo swInfo){
        return repository.save(swInfo);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public void init(){
        String urlSWAPI = startUrlApi + "planets/" + endUrlApi;

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlSWAPI)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject obj = new JSONObject(response.body());
            JSONArray array = obj.getJSONArray("results");

            for(int i=0; i< array.length(); i++){
                SwInfo swInfo = new SwInfo();
                swInfo.setName(array.getJSONObject(i).getString("name"));
                swInfo.setClimate(array.getJSONObject(i).getString("climate"));
                swInfo.setTerrainType(array.getJSONObject(i).getString("terrain"));
                swInfo.setQuantityTimesAppeared(array.getJSONObject(i).getJSONArray("films").length());
                repository.save(swInfo);
            }
        }
        catch (JSONException | IOException | InterruptedException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

}
