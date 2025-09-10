package org.tables;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Arrays;

public class CreateMoviesTable {
    public static void main(String[] args) {
        // Step 1: Connect to DynamoDB Local on port 8001
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8001", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Movies";

        try {
            // Step 2: Define schema and create table
            Table table = dynamoDB.createTable(
                    tableName,
                    Arrays.asList(
                            new KeySchemaElement("MovieId", KeyType.HASH),   // Partition Key
                            new KeySchemaElement("Title", KeyType.RANGE)     // Sort Key
                    ),
                    Arrays.asList(
                            new AttributeDefinition("MovieId", ScalarAttributeType.S),
                            new AttributeDefinition("Title", ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(5L, 5L) // Required but ignored in local
            );

            // Step 3: Wait for table to become active
            table.waitForActive();
            System.out.println(" Table created: " + table.getDescription().getTableName());

        } catch (Exception e) {
            System.err.println(" Failed to create table: " + e.getMessage());
        }
    }
}
