package org.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import java.util.Arrays;
import java.util.List;

public class AddBooks {
    public static void main(String[] args) {
        // 1) Connect to DynamoDB Local
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("BooksCatalog");  // must match your table.json

        // 2) Prepare 5 items
        List<Item> books = Arrays.asList(
                new Item().withPrimaryKey("BookId", "B101", "Author", "George Orwell")
                        .withString("Title", "1984")
                        .withString("Genre", "Dystopian")
                        .withNumber("Year", 1949),

                new Item().withPrimaryKey("BookId", "B102", "Author", "Aldous Huxley")
                        .withString("Title", "Brave New World")
                        .withString("Genre", "Dystopian")
                        .withNumber("Year", 1932),

                new Item().withPrimaryKey("BookId", "B103", "Author", "J. K. Rowling")
                        .withString("Title", "Harry Potter and the Philosopher's Stone")
                        .withString("Genre", "Fantasy")
                        .withNumber("Year", 1997),

                new Item().withPrimaryKey("BookId", "B104", "Author", "J. R. R. Tolkien")
                        .withString("Title", "The Hobbit")
                        .withString("Genre", "Fantasy")
                        .withNumber("Year", 1937),

                new Item().withPrimaryKey("BookId", "B105", "Author", "Harper Lee")
                        .withString("Title", "To Kill a Mockingbird")
                        .withString("Genre", "Fiction")
                        .withNumber("Year", 1960)
        );

        // 3) Condition: do NOT overwrite if (BookId, Author) already exists
        final String noOverwriteCondition = "attribute_not_exists(BookId) AND attribute_not_exists(Author)";

        int inserted = 0, skipped = 0, failed = 0;

        for (Item book : books) {
            try {
                PutItemSpec spec = new PutItemSpec()
                        .withItem(book)
                        .withConditionExpression(noOverwriteCondition);  //

                PutItemOutcome out = table.putItem(spec);
                System.out.println("Inserted: " + book.getString("BookId") + " - " + book.getString("Title"));
                inserted++;
            } catch (ConditionalCheckFailedException e) {
                System.out.println("Skipped (already exists): " + book.getString("BookId"));
                skipped++;
            } catch (Exception e) {
                System.out.println("Failed: " + book.getString("BookId") + " → " + e.getMessage());
                failed++;
            }
        }

        System.out.printf("Done. Inserted=%d, Skipped(existing)=%d, Failed=%d%n", inserted, skipped, failed);
    }
}
