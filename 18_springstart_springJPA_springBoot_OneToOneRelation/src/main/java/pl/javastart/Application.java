package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.DaoUser;
import pl.javastart.dao.DaoUserDetails;
import pl.javastart.model.User;
import pl.javastart.model.UserDetails;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
	
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		DaoUser daoUser = ctx.getBean(DaoUser.class);
		DaoUserDetails daoUserDetails = ctx.getBean(DaoUserDetails.class); 
		
		User user = new User("Leszek", "tajneHaslo", "lech@wp.pl");
		UserDetails userDetails = new UserDetails("Leszek", "Kołacz", "Krakowskie przedmiescie");
		
		daoUser.save(user);
		Thread.sleep(19000);

		user.setUserDetails(userDetails);
		
		daoUser.update(user);
		
		Thread.sleep(19000);
		
		
		System.out.println("po user details" + "\n" + daoUserDetails.get(1L).getUser().toString());
		
		
		System.out.println("po user" + "\n" + daoUser.get(1L));
		User userToDel = daoUser.get(3L);
		System.out.println("Użytownik pobrany z baz daych " + userToDel);
		daoUser.delete(userToDel);
		
		ctx.close();
		
		
	
	
	}

}
