package org.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;

public class DeleteBooks {
    public static void main(String[] args) {
        // 1) Connect to DynamoDB Local
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("BooksCatalog");

        // 2) Delete Book 1 (B101 - George Orwell)
        DeleteItemSpec deleteSpec1 = new DeleteItemSpec()
                .withPrimaryKey("BookId", "B101", "Author", "George Orwell");

        // 3) Delete Book 2 (B103 - J. K. Rowling)
        DeleteItemSpec deleteSpec2 = new DeleteItemSpec()
                .withPrimaryKey("BookId", "B103", "Author", "J. K. Rowling");

        try {
            DeleteItemOutcome outcome1 = table.deleteItem(deleteSpec1);
            System.out.println("Deleted book: B101 - George Orwell");

            DeleteItemOutcome outcome2 = table.deleteItem(deleteSpec2);
            System.out.println("Deleted book: B103 - J. K. Rowling");

        } catch (Exception e) {
            System.err.println("Delete failed: " + e.getMessage());
        }
    }
}
