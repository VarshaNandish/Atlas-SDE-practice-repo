package org.example.mapperdb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBMapperExample {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8001", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("dummy", "dummy")))
                .build();

        DynamoDBMapper mapper = new DynamoDBMapper(client);

        // Create a new movie object
        Movie movie = new Movie();
        movie.setMovieId("M200");
        movie.setTitle("Avengers: Endgame");
        movie.setGenre("Action");
        movie.setYear(2019);

        // Save movie to DynamoDB
        mapper.save(movie);
        System.out.println("✅ Movie saved!");

        // Retrieve movie
        Movie retrieved = mapper.load(Movie.class, "M200", "Avengers: Endgame");
        System.out.println("🎬 Retrieved: " + retrieved.getTitle() + " (" + retrieved.getYear() + ")");
    }
}

