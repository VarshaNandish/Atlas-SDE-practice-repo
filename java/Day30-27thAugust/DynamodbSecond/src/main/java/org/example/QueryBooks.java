package org.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class QueryBooks {
    public static void main(String[] args) {
        // 1) Connect to DynamoDB Local
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("BooksCatalog");

        // 2) Query Book B101 (George Orwell)
        GetItemSpec spec1 = new GetItemSpec()
                .withPrimaryKey("BookId", "B101", "Author", "George Orwell");

        // 3) Query Book B103 (J. K. Rowling)
        GetItemSpec spec2 = new GetItemSpec()
                .withPrimaryKey("BookId", "B103", "Author", "J. K. Rowling");

        try {
            Item book1 = table.getItem(spec1);
            Item book2 = table.getItem(spec2);

            System.out.println("Book 1: " + (book1 != null ? book1.toJSONPretty() : "Not Found"));
            System.out.println("Book 2: " + (book2 != null ? book2.toJSONPretty() : "Not Found"));
        } catch (Exception e) {
            System.err.println("Query failed: " + e.getMessage());
        }
    }
}
