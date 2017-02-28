package com.accenture.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCisRequest;
import io.spring.guides.gs_producing_web_service.GetCisResponse;

@Endpoint
public class CisEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/cis-producing-web-service";

	private CisRepository cisRepository;
	
	@Autowired
	public CisEndpoint(CisRepository cisRepository) {
		this.cisRepository = cisRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCisRequest")
	@ResponsePayload
	public GetCisResponse getCisDetails(@RequestPayload GetCisRequest request) {
		GetCisResponse response = new GetCisResponse();
		response.setCisdetails(cisRepository.findCisDetails(request.getNino()));
		return response;
	}
}
