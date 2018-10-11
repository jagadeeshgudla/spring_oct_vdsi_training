package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetClient {
	public static void main(String[] args) {
		RestTemplate rt= new RestTemplate();
		HttpHeaders headers= new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		Emp e = new Emp(2010,"Spring","US",2400);
		HttpEntity req= new HttpEntity<>(e,headers);
		ResponseEntity<String> resp=rt.exchange("http://localhost:8081/save", HttpMethod.POST, req,
				String.class);
		System.out.println("Response:"+resp.getBody());
 		System.out.println("Error Code:"+resp.getStatusCode());
	}
}
