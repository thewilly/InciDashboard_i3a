package com.uniovi.client;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.uniovi.entitites.Agent;

public class AgentService {

	static String API_GATEWAY = "http://asw-i3a-zuul-eu-west-1.guill.io/agents_service";

	public static List<Agent> getAllSensors() {
		try {
			HttpResponse<JsonNode> response = Unirest.post(API_GATEWAY + "/agents?kindCode=3").asJson();
			ObjectMapper mapper = new ObjectMapper();
			List<Agent> items = mapper.readValue(response.getBody().toString(),
					mapper.getTypeFactory().constructParametricType(List.class, Agent.class));

			return items;
		} catch (IOException | UnirestException e) {
			e.printStackTrace();
			return null;
		}
	}

}
