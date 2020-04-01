package user;

import java.util.ArrayList;
import java.util.Arrays;

public class UserDAO {

	public static final ArrayList<String> users = new ArrayList<String>(Arrays.asList("João", "Lucas", "Marcos", "Daiane"));

	public static User getUser(String name) {
		if (users.contains(name)) 
			return new RegisteredUser(name);			
		return new NullUser();
	}
}
