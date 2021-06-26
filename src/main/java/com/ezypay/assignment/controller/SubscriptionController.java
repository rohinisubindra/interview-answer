package com.ezypay.assignment.controller;

import com.ezypay.assignment.model.SubscriptionDetails;
import com.ezypay.assignment.model.WSubscriptionDetails;
import com.ezypay.assignment.util.SubscriptionTypeValidator;
import com.ezypay.assignment.util.WSubscriptionDetailsDeserializer;
import com.ezypay.assignment.util.WSubscriptionDetailsTransformer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class SubscriptionController {


    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String adminHomePage(Model model){

        model.addAttribute("wSubscriptionDetails",new WSubscriptionDetails());
        return "SubscriptionPlan";
    }

    @RequestMapping(value = "/uisubscribe",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        public String subscribe(@RequestBody @Valid WSubscriptionDetails wSubscriptionDetails, Model model){
        SubscriptionDetails subscriptionDetails=new WSubscriptionDetailsTransformer().apply(wSubscriptionDetails);


        model.addAttribute("amount",subscriptionDetails.getAmount());
        model.addAttribute("subscriptiontype",subscriptionDetails.getSubscriptionType());
        model.addAttribute("frequencydetails",subscriptionDetails.getFrequencyDetails());
        model.addAttribute("startdate",subscriptionDetails.getSubscriptionStartDate());
        model.addAttribute("enddate",subscriptionDetails.getSubscriptionEndDate());
        return "subscription";

    }




}
