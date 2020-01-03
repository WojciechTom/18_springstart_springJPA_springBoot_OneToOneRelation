package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pl.javastart.model.UserDetails;


@Repository
public class DaoUserDetails {
	
	@PersistenceContext
	private EntityManager manago;
	
//KONSTRUKTORY ------------------------------------------------------------------
	public DaoUserDetails () {}

	public DaoUserDetails(EntityManager manago) {
		this.manago = manago;
	}
	
//METODY ------------------------------------------------------------------------
	
	
	public void save (UserDetails userDetails) {
		manago.persist(userDetails);
	}
	
	
	public UserDetails get(Long id) {
		UserDetails ud = manago.find(UserDetails.class, id);
		return ud;
	}

	
	public void remove(UserDetails userDetails) {
		manago.remove(userDetails);
	}
	
	public void update(UserDetails userDetails) {
		userDetails = manago.merge(userDetails);
		
		userDetails.getUser().setUserDetails(userDetails);
		manago.merge(userDetails);
	}
	
		
	
	

}
