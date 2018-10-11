package com.demo.spring;

import org.apache.commons.codec.binary.Base64;

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
		
		String userDetails="pavan:gudla";
		String encodedCred= new String(Base64.encodeBase64(userDetails.getBytes()));
		System.out.println(encodedCred);
		RestTemplate rt= new RestTemplate();
		HttpHeaders headers= new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Authorization", "Basic "+encodedCred);
		Emp e = new Emp(2010,"Spring","US",2400);
		HttpEntity req= new HttpEntity<>(e,headers);
		ResponseEntity<String> resp=rt.exchange("http://localhost:8081/emp/save", HttpMethod.POST, req,
				String.class);
		//new ParameterizedTypeReference<List<Emp>>(){};
		System.out.println("Response:"+resp.getBody());
 		System.out.println("Error Code:"+resp.getStatusCode());
	}
}
