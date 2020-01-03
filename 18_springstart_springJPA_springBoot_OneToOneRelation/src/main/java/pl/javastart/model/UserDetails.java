package pl.javastart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_detalis")
public class UserDetails implements Serializable{
	private static final long serialVersionUID = 4077719731081358762L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_det_id")
	private Long id;
	@Column(name="user_det_first_name")
	private String firstName;
	@Column(name="user_det_last_name")
	private String lastName;
	@Column(name="user_det_adres")
	private String adres;
	@OneToOne(mappedBy = "userDetails")
	private User user;
	

	public UserDetails () {}


	public UserDetails( String firstName, String lastName, String adres) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adres = adres;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAdres() {
		return adres;
	}


	public void setAdres(String adres) {
		this.adres = adres;
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adres=" + adres
				+ "]";
	}
	
}
