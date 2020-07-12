package com.damon.main;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.internal.MongoClientImpl;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TestMongo {
    public static void main(String[] args) {
        MongoOperations mongoOperations = new MongoTemplate(MongoClients.create(),"vkepai");
    }
}
