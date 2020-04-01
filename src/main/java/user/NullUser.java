package user;

import channel.Channel;
import video.Video;

public class NullUser extends User {
	
	public NullUser() {
		this.name = "Guest";
		this.registered = false;
	}

	@Override
	public void update(String update) {}

	@Override
	public void watch(Channel channel) {
		for(Video video : channel.getVideos()) {
			if(video.premium)
				System.out.println("User " + name + " has to register to watch this video!");
			else
				System.out.println("User " + name + " watched " + video.title);
		}
	}

}
