package Clase;

/**
 *  Clasa User
 * @author Adi
 *
 */

public class User{
	String username;
	String password;
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		this.username="";
		this.password="";
		// TODO Auto-generated constructor stub
	}

//	public void Login(String username, String password) {
//		this.username= username;
//		this.password= password;
//	}
}
