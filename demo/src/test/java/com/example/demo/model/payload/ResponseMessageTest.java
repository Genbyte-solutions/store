package com.example.demo.model.payload;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResponseMessageTest {

    @Test
    public void testBuilder() {
        String message = "This is a test message";
        Object object = new Object(); // Puedes proporcionar cualquier objeto como ejemplo

        ResponseMessage responseMessage = ResponseMessage.builder()
                .message(message)
                .object(object)
                .build();

        assertNotNull(responseMessage);
        assertEquals(message, responseMessage.getMessage());
        assertEquals(object, responseMessage.getObject());
    }

    @Test
    public void testGettersAndSetters() {
        String message = "Another test message";
        Object object = new Object(); // Puedes proporcionar cualquier objeto como ejemplo

        ResponseMessage responseMessage = new ResponseMessage(message,object);

        assertNotNull(responseMessage);
        assertEquals(message, responseMessage.getMessage());
        assertEquals(object, responseMessage.getObject());
    }

}