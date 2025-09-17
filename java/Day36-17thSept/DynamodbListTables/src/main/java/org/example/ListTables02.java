package org.example;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

import java.util.List;

public class ListTables02 {

    public static void main(String[] args) {
        // 1. Create DynamoDB client (connects to AWS Cloud)
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.AP_SOUTH_1)  // use your region
                .build();

        // 2. Build request
        ListTablesRequest request = ListTablesRequest.builder().build();

        // 3. Call DynamoDB
        ListTablesResponse response = client.listTables(request);

        // 4. Get tables
        List<String> tables = response.tableNames();

        if (tables.isEmpty()) {
            System.out.println("No tables found in this region!");
        } else {
            System.out.println("Tables in DynamoDB:");
            tables.forEach(System.out::println);
        }

        // 5. Close client
        client.close();
    }
}

// output error because aws credentials fails, access exhausted