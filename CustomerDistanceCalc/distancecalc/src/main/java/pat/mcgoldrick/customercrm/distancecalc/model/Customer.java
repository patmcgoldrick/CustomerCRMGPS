package pat.mcgoldrick.customercrm.distancecalc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer user_id;
	
	@NotNull
	@Size(max=100)
	private String name;

	@NotNull
	@Size(min=-90,max=90)
	private Double latitude; 
	
	@NotNull
	@Size(min=-180,max=180)
	private Double longitude;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	} 
	
	

}
