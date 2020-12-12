package com.turvo.portfolio.management.resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.turvo.portfolio.management.model.Holding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
public class HoldingDetails {

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.holding}")
    private String holdingUrl;

    public List<Holding> getHoldingData() {
        String jsonString = restTemplate.getForObject(holdingUrl, String.class);
        Gson g = new Gson();
        Type collectionType = new TypeToken<Collection<Holding>>() {
        }.getType();
        List<Holding> data = g.fromJson(jsonString, collectionType);
        return data;
    }
}
