package org.example;

import java.util.Arrays;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class CreateTable {
    public static void main(String[] args) throws Exception {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
                .withEndpoint("http://localhost:8000");
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "Employee";

        try {
            Table table = dynamoDB.createTable(
                    tableName,
                    Arrays.asList(
                            new KeySchemaElement("ID", KeyType.HASH),
                            new KeySchemaElement("no", KeyType.RANGE)
                    ),
                    Arrays.asList(
                            new AttributeDefinition("ID", ScalarAttributeType.N),
                            new AttributeDefinition("no", ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(5L, 5L)
            );

            table.waitForActive();
            System.out.println("Table description: " + table.getDescription().getTableStatus());

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
