package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
//RESPONSE model,It represents: Data we RECEIVE from API
//Maps API response into Java object
//ie Converts JSON → Java object (Deserialization),Helps in validation using getters
	private String name;
	private String job;
	private String id;
	private String createdAt;

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public String getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}
}