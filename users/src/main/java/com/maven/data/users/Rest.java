package com.maven.data.users;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.maven.data.users.Users;

public class Rest {

	public void getUsersByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8086/use/users/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Users> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Users.class,
				1);
		Users users = responseEntity.getBody();
		System.out.println("Id:" + users.getId() + ", Name:" + users.getName() + ", Email:" + users.getEmail());
	}

	public void getAllUsersDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8086/use/data1";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try{
		ResponseEntity<Users[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Users[].class);
		Users[] data1 = responseEntity.getBody();
		
		for (Users users : data1) {
			System.out.println("Id:" + users.getId() + ", Name:" + users.getName() + ", Email: " + users.getEmail());
		}
		}
		catch (ResourceAccessException e) {
            handleConnectionRefused(url);}
        
		}
		
	

	private void handleConnectionRefused(String url) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		Rest rest = new Rest();

		rest.getAllUsersDemo();
	}
}
