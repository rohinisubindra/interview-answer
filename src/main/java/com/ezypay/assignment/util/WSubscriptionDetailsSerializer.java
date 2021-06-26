package com.ezypay.assignment.util;

import com.ezypay.assignment.model.WSubscriptionDetails;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;


public class WSubscriptionDetailsSerializer extends JsonSerializer<WSubscriptionDetails> {
    @Override
    public void serialize(WSubscriptionDetails wSubscriptionDetails, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

    }
}
