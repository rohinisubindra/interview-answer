package com.ezypay.assignment.controller;


import com.ezypay.assignment.model.SubscriptionDetails;
import com.ezypay.assignment.model.WSubscriptionDetails;
import com.ezypay.assignment.model.WSubscriptionDetailsRest;
import com.ezypay.assignment.util.SubscriptionDetailsTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class SubscriptionRestController {
    @RequestMapping(value = "/subscribe",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> subscribe(@Valid @RequestBody WSubscriptionDetailsRest wSubscriptionDetails){
        SubscriptionDetails subscriptionDetails= new SubscriptionDetailsTransformer().apply(wSubscriptionDetails);
        return new ResponseEntity<>(subscriptionDetails, HttpStatus.OK);
    }
}
