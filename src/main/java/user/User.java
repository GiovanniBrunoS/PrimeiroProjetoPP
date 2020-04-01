package user;

import channel.Channel;

public abstract class User {
	
	public String name;
	public Boolean registered;
	
	public Boolean getRegisterStatus() {
		return registered;
	}

	public abstract void update(String update);
	
	public abstract void watch(Channel channel);
		
		
}
