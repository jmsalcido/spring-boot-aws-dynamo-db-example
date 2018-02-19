## spring-boot-aws-dynamo-db-example
--

Hi, I created this as an example to understand how does Amazon Dynamo DB works.

Nothing special.

### How to
--
1. Create an AWS Account: [Here][aws-free-link]
2. Create a DynamoDB table in US_WEST_2 (or change region in [AppConfiguration.java][app_configuration_file])
3. Run with gradle: `./gradlew bootRun`
4. Use curl/postman/HTTPie to send a request:
    ```bash
    http POST :8080/persons/ firstName=Don lastName=Jose age=128 -v
    ```
5. That's it.

>Be happy, bye!


[aws-free-link]: https://aws.amazon.com/free/
[app_configuration_file]: /src/main/java/org/otfusion/training/application/AppConfiguration.java