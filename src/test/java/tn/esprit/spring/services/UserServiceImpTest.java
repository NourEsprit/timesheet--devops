package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

//Ctrl+Shift+O pour faire l import automatique

public class UserServiceImpTest {

	
	
	
	
	@Autowired
	IUserService us;

	
	@Order(1)
	@Test
	public void testRetrieveAllUsers() {
	List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(0, listUsers.size());
	}
	
	
	
	

	@Test
	@Order(3)
	public void testModifyUser() throws ParseException {
	SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	
		Date d =dateFormat.parse("2015-03-23");
		User u =new User(1L,"Nourrr2","Nour",d,Role.INGENIEUR);
		User userUpdated=us.updateUser(u);
		Assertions.assertEquals(u.getLastName(),userUpdated.getLastName());
		
		
	}
	
	
	
	@Order(4)
	public void testRetrieveUser() {
	    User userRetrived = us.retrieveUser("1");
	    Assertions.assertEquals(1L, userRetrived.getId());
	}
	@Order(5)
	public void testDeleteUser() {
	us.deleteUser("1");
	Assertions.assertNull(us.retrieveUser("1"));

	}
		
	 @Test
	 @Order(2)
	 public void addUser() throws ParseException {
	 SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	 Date d= dateFormat.parse("2015-03-23");
	 User u=new User("Nour1", "Nour2", d, Role.INGENIEUR);
	 User userAdded = us.addUser(u);
	 Assertions.assertEquals (u.getLastName(), userAdded.getLastName());

	 }
	
	
	
	
	
	
}
