
package org.example;



import com.amazon.dax.client.dynamodbv2.AmazonDaxClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DaxClientExample {
    public static void main(String[] args) throws Exception {
        // 1. Replace with your cluster endpoint
        String daxEndpoint = "daxs://mydaxcluster01.rbwyfz.dax-clusters.ap-south-1.amazonaws.com";

        // 2. Build DAX client
        AmazonDaxClientBuilder daxClientBuilder = AmazonDaxClientBuilder.standard();
        daxClientBuilder.withRegion("us-east-1"); // your region
        daxClientBuilder.withEndpointConfiguration(daxEndpoint);

        AmazonDynamoDB client = daxClientBuilder.build();

        // 3. Wrap into DynamoDB Document API
        DynamoDB dynamoDB = new DynamoDB(client);

        // 4. Access a table
        Table table = dynamoDB.getTable("Songs");

        // 5. Put an item (write-through to DynamoDB, cached in DAX)
        Item item = new Item()
                .withPrimaryKey("SongId", "S200", "Title", "DAX Speed")
                .withString("Artist", "Cache Band")
                .withString("Album", "Fast Beats")
                .withNumber("Year", 2025);

        table.putItem(item);
        System.out.println("✅ Inserted item into DAX-enabled table");

        // 6. Get the item (served from DAX cache if recently read)
        Item retrieved = table.getItem("SongId", "S200", "Title", "DAX Speed");
        System.out.println("🎶 Retrieved: " + retrieved.toJSONPretty());
    }
}
