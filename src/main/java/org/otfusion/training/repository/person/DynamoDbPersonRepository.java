package org.otfusion.training.repository.person;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.otfusion.training.model.person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DynamoDbPersonRepository implements PersonRepository {

    private static final String TABLE_NAME = "PersonCollection";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final DynamoDB dynamoDB;

    @Autowired
    public DynamoDbPersonRepository(DynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    private Table getTable() {
        return dynamoDB.getTable(TABLE_NAME);
    }

    @Override
    public Person add(Person person) {
        String id = "" + System.currentTimeMillis();

        Item item = new Item()
                .withPrimaryKey("Id", id)
                .withString("firstName", person.getFirstName())
                .withString("lastName", person.getLastName())
                .withInt("age", person.getAge());

        PutItemOutcome putItemOutcome = getTable().putItem(item);

        logger.info(putItemOutcome.toString());

        person.setId(id);

        return person;
    }

    @Override
    public List<Person> getAll() {
        return Collections.emptyList();
    }

}
