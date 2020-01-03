package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javastart.model.User;
import pl.javastart.model.UserDetails;

@Repository
@Transactional
public class DaoUser {

	
	private EntityManager entityManager;
	
//KONSTRUKTORY ---------------------------------------------------------
	public DaoUser() {}

	@Autowired
	public DaoUser(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	
//METODY ---------------------------------------------------------------
	public void save(User user) {
		UserDetails ud = user.getUserDetails();
		
		if (ud != null && ud.getId() == null ) { 
			entityManager.persist(ud);
		}
			entityManager.persist(user);
	}
	

	
	public User get(Long id) {
		return entityManager.find(User.class, id);
	}
	
	
	public void update(User user) {
		UserDetails ud = user.getUserDetails();
		if(ud != null) {
			ud = entityManager.merge(ud);
			user.setUserDetails(ud);
		}
		entityManager.merge(user);
	}
	
	
	
	public void delete(User user) {
		User userToDel = entityManager.merge(user);
		entityManager.remove(userToDel.getUserDetails());
		entityManager.remove(userToDel);
	}
	
	
	
	
}
