package org.otfusion.training.application;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "org.otfusion.training")
public class AppConfiguration {

    @Value("${aws.key}")
    private String awsKey;

    @Value("${aws.secret}")
    private String awsSecret;

    @Bean
    public AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(awsKey, awsSecret);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDBClient(AWSCredentials awsCredentials) {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    @Bean
    public DynamoDB dynamoDB(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDB(amazonDynamoDB);
    }

}
