package com.ezypay.assignment;

import com.ezypay.assignment.model.WSubscriptionDate;
import com.ezypay.assignment.model.WSubscriptionDetails;
import com.ezypay.assignment.model.WSubscriptionType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AssignmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello, World")));
	}

	@Test
	public void subscription_daily_success() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("daily", "");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(status().isOk());

	}

	@Test
	public void subscription_weekly_success() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("weekly", "monday");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);
		System.out.println(asJsonString(wSubscriptionDetails));
		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(status().isOk());

	}

	@Test
	public void subscription_monthly_success() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("monthly", "1");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(status().isOk());

	}

	@Test
	public void subscription_weekly_invalid_subscriptiontype() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("weeekly", "monday");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(MockMvcResultMatchers.status().is4xxClientError());
		;

	}

	@Test
	public void subscription_weekly_invalid_frequency() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("weekly", "1");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(MockMvcResultMatchers.status().is4xxClientError());

	}


	@Test
	public void subscription_monthly_invalid_subscriptiontype() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("monthlyy", "1");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(MockMvcResultMatchers.status().is4xxClientError());
		;

	}

	@Test
	public void subscription_monthly_invalid_frequency() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("monthly", "monday");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(10.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(MockMvcResultMatchers.status().is4xxClientError());

	}

	@Test
	public void subscription_amount_lessthan10() throws Exception {

		WSubscriptionType wSubscriptionType = new WSubscriptionType("daily", "1");
		WSubscriptionDate wSubscriptionDate = new WSubscriptionDate("2021-06-05", "2021-08-05");
		WSubscriptionDetails wSubscriptionDetails = new WSubscriptionDetails(9.00, wSubscriptionType, wSubscriptionDate);

		mockMvc.perform(post("/subscribe").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(wSubscriptionDetails)))
			   .andExpect(MockMvcResultMatchers.status().is4xxClientError());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
