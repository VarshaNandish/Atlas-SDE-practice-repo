package org.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class RetrieveItem {
    public static void main(String[] args) {
        // Connect to DynamoDB (Cloud). Credentials come from aws configure
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion("ap-south-1") // your region
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        // Table name from NoSQL Workbench deployment
        Table table = dynamoDB.getTable("Employee");

        // Retrieve an item (you need the full primary key: Partition key + Sort key if defined)
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey("ID", 1, "EmpName", "Varsha");

        try {
            Item outcome = table.getItem(spec);
            if (outcome != null) {
                System.out.println("Retrieved item: " + outcome.toJSONPretty());
            } else {
                System.out.println("Item not found");
            }
        } catch (Exception e) {
            System.err.println("Failed to retrieve item: " + e.getMessage());
        }
    }
}

