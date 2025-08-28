package org.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class UpdateBooks {
    public static void main(String[] args) {
        // 1) Connect to DynamoDB Local
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("BooksCatalog");

        // Example: update the row (B101, George Orwell)
        updateBook(table,
                "B101", "George Orwell",
                "Nineteen Eighty-Four",   // Title
                "Dystopian",              // Genre
                1949);                    // Year

        // Another example
        updateBook(table,
                "B104", "J. R. R. Tolkien",
                "The Hobbit",             // keep same title or change it
                "Fantasy",                // genre
                1938);                    // corrected year
    }


    private static void updateBook(Table table,
                                   String bookId,
                                   String author,
                                   String newTitle,
                                   String newGenre,
                                   int newYear) {
        try {
            UpdateItemSpec spec = new UpdateItemSpec()
                    .withPrimaryKey("BookId", bookId, "Author", author)
                    .withUpdateExpression("SET #T = :t, #G = :g, #Y = :y")
                    .withNameMap(new NameMap()
                            .with("#T", "Title")
                            .with("#G", "Genre")
                            .with("#Y", "Year"))
                    .withValueMap(new ValueMap()
                            .withString(":t", newTitle)
                            .withString(":g", newGenre)
                            .withNumber(":y", newYear))
                    // Ensure the row exists; prevents accidental upsert
                    .withConditionExpression("attribute_exists(BookId) AND attribute_exists(Author)")
                    // Return the whole updated item for verification
                    .withReturnValues(ReturnValue.ALL_NEW);

            UpdateItemOutcome out = table.updateItem(spec);
            System.out.println("Updated (" + bookId + ", " + author + "):\n" + out.getItem().toJSONPretty());
        } catch (Exception e) {
            System.err.println("Update failed for (" + bookId + ", " + author + "): " + e.getMessage());
        }
    }
}

