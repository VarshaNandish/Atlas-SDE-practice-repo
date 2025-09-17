package org.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

import java.net.URI;
import java.util.List;

public class ListTables01 {


    private static DynamoDbClient connectToLocal() {
        return DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8001"))
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create("dummy", "dummy")
                        )
                )
                .build();
    }


    private static void displayTables(DynamoDbClient client) {
        System.out.println("Displaying existing tables in DynamoDB Local (port 8001)...");

        String lastName = null;
        boolean moreTables = true;

        while (moreTables) {
            try {
                ListTablesRequest.Builder reqBuilder = ListTablesRequest.builder();
                if (lastName != null) {
                    reqBuilder.exclusiveStartTableName(lastName);
                }

                ListTablesResponse res = client.listTables(reqBuilder.build());

                List<String> tableNames = res.tableNames();
                if (!tableNames.isEmpty()) {
                    for (String tableName : tableNames) {
                        System.out.println("* " + tableName);
                    }
                } else {
                    System.out.println("No tables found in local DynamoDB.");
                    return;
                }

                lastName = res.lastEvaluatedTableName();
                moreTables = (lastName != null);

            } catch (DynamoDbException ex) {
                System.err.println(" Error listing tables: " + ex.getMessage());
                return;
            }
        }

        System.out.println("Done listing tables!");
    }

    public static void main(String[] args) {
        try (DynamoDbClient client = connectToLocal()) {
            displayTables(client);
        }
    }
}
