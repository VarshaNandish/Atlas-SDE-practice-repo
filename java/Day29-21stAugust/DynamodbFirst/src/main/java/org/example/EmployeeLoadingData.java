package org.example;

import java.io.File;
import java.util.Iterator;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;

import com.fasterxml.jackson.core.JsonFactory;    // fixed package
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EmployeeLoadingData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDBClient client = new AmazonDynamoDBClient().withEndpoint("http://localhost:8000");

        DynamoDB dynamoDB = new DynamoDB(client);   // fixed variable name

        Table table = dynamoDB.getTable("Employee");

        JsonParser parser = new JsonFactory().createParser(new File("Table.json")); // fixed filename usage

        JsonNode rootNode = new ObjectMapper().readTree(parser);
        Iterator<JsonNode> iterate = rootNode.iterator();

        while (iterate.hasNext()) {

            ObjectNode currentNode = (ObjectNode) iterate.next();   // fixed declaration

            int ID = currentNode.path("ID").asInt();
            String NomenClature = currentNode.path("NomenClature").asText();

            try {
                table.putItem(new Item().withPrimaryKey("ID", ID, "no", NomenClature)); // fixed method name

                System.out.println("wow add item in employee table is successful " + ID + " " + NomenClature);

            } catch (Exception ex) {
                System.err.println("sorry cant add item in employee table " + ID + " " + NomenClature);
                System.err.println(ex.getMessage());
                break;
            }
        }
        parser.close();
    }
}


