package com.ezypay.assignment.util;

import com.ezypay.assignment.model.WSubscriptionDate;
import com.ezypay.assignment.model.WSubscriptionDetails;
import com.ezypay.assignment.model.WSubscriptionType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.io.IOException;


@JsonComponent
public class WSubscriptionDetailsDeserializer extends JsonDeserializer<WSubscriptionDetails> {

    @Override
    public WSubscriptionDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        System.out.println("*****@@@@@"+node.asText());
        String amountString = node.get("amount").asText();
        double amount=Double.parseDouble(amountString);
        System.out.println("amount : "+amount);
        String subscriptionType = node.get("subscriptionType").asText();
        String frequencyDetails = node.get("frequencyDetails").asText();
        String subscriptionStartDate = node.get("subscriptionStartDate").asText();
        String subscriptionEndDate = node.get("subscriptionEndDate").asText();
        System.out.println("************ subscriptionType --> " + subscriptionType);
        System.out.println("*********** frequencyDetails --> " + frequencyDetails);

        return new WSubscriptionDetails(amount,
                                        new WSubscriptionType(subscriptionType, frequencyDetails),
                                        new WSubscriptionDate(subscriptionStartDate, subscriptionEndDate));
    }
}
