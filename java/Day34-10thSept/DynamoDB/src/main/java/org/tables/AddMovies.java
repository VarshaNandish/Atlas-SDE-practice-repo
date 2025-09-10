package org.tables;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.Arrays;
import java.util.List;

public class AddMovies {
    public static void main(String[] args) {
        // Step 1: Connect to DynamoDB Local (port 8001)
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8001", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Movies");

        // Step 2: Prepare some movies
        List<Item> movies = Arrays.asList(
                new Item().withPrimaryKey("MovieId", "M101", "Title", "Inception")
                        .withString("Genre", "Sci-Fi")
                        .withNumber("Year", 2010)
                        .withString("Director", "Christopher Nolan")
                        .withNumber("Rating", 8.8),

                new Item().withPrimaryKey("MovieId", "M102", "Title", "Interstellar")
                        .withString("Genre", "Sci-Fi")
                        .withNumber("Year", 2014)
                        .withString("Director", "Christopher Nolan")
                        .withNumber("Rating", 8.6),

                new Item().withPrimaryKey("MovieId", "M103", "Title", "The Dark Knight")
                        .withString("Genre", "Action")
                        .withNumber("Year", 2008)
                        .withString("Director", "Christopher Nolan")
                        .withNumber("Rating", 9.0),

                new Item().withPrimaryKey("MovieId", "M104", "Title", "The Matrix")
                        .withString("Genre", "Sci-Fi")
                        .withNumber("Year", 1999)
                        .withString("Director", "Lana & Lilly Wachowski")
                        .withNumber("Rating", 8.7),

                new Item().withPrimaryKey("MovieId", "M105", "Title", "Titanic")
                        .withString("Genre", "Romance")
                        .withNumber("Year", 1997)
                        .withString("Director", "James Cameron")
                        .withNumber("Rating", 7.8)
        );

        // Step 3: Insert movies
        for (Item movie : movies) {
            try {
                PutItemOutcome outcome = table.putItem(movie);
                System.out.println("✅ Inserted: " + movie.getString("Title"));
            } catch (Exception e) {
                System.err.println("❌ Failed to insert: " + movie.getString("Title") + " → " + e.getMessage());
            }
        }
    }
}

