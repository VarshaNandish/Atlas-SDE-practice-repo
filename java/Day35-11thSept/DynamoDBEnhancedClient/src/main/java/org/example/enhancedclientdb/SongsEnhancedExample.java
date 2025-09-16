package org.example.enhancedclientdb;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.*;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.net.URI;
import java.time.Duration;

public class SongsEnhancedExample {
    public static void main(String[] args) {
        // 1) Build a DynamoDbClient pointing to local instance on port 8001
        DynamoDbClient ddb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8001")) // local endpoint
                .region(Region.of("ap-south-1"))                       // region string for local SDK usage
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("dummy", "dummy")))   // dummy creds for local
                .overrideConfiguration(ClientOverrideConfiguration.builder()
                        .apiCallTimeout(Duration.ofSeconds(30))
                        .build())
                .build();

        // 2) Create Enhanced client
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();

        // 3) Map to a table (must exist or create separately)
        DynamoDbTable<Song> songTable = enhancedClient.table("Songs", TableSchema.fromBean(Song.class));

        // ---- Put items ----
        Song s1 = new Song();
        s1.setSongId("S101");
        s1.setTitle("Shape of You");
        s1.setArtist("Ed Sheeran");
        s1.setAlbum("Divide");
        s1.setYear(2017);
        s1.setGenre("Pop");

        Song s2 = new Song();
        s2.setSongId("S102");
        s2.setTitle("Blinding Lights");
        s2.setArtist("The Weeknd");
        s2.setAlbum("After Hours");
        s2.setYear(2020);
        s2.setGenre("Synthwave/Pop");

        songTable.putItem(s1);
        System.out.println("Inserted: " + s1);
        songTable.putItem(s2);
        System.out.println("Inserted: " + s2);

        // ---- Read an item (by PK + SK) ----
        Key key = Key.builder().partitionValue("S101").sortValue("Shape of You").build();
        Song fetched = songTable.getItem(r -> r.key(key));
        if (fetched != null) {
            System.out.println("Fetched: " + fetched);
        } else {
            System.out.println("Song not found");
        }

        // ---- Scan all items (example) ----
        System.out.println("Scanning all songs:");
        songTable.scan().items().stream().forEach(System.out::println);

        // close client
        ddb.close();
    }
}

