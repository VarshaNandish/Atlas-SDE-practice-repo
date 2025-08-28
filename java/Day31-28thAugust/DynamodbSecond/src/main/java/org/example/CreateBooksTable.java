package org.example;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateBooksTable {
    public static void main(String[] args) throws Exception {
        // Build DynamoDB client (local, dummy creds)
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("dummy", "dummy")))
                .build();

        // Load table.json from resources
        InputStream inputStream = CreateBooksTable.class.getClassLoader().getResourceAsStream("table.json");
        if (inputStream == null) {
            throw new RuntimeException("table.json not found in resources folder");
        }

        // Read JSON into a String
        String json = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();

        // Parse JSON into CreateTableRequest
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        CreateTableRequest request = mapper.readValue(json, CreateTableRequest.class);


        // Create the table
        CreateTableResult result = client.createTable(request);
        System.out.println("Table creation initiated: " + result.getTableDescription().getTableName());
    }
}

