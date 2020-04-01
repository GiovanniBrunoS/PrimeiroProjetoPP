package user;

import channel.Channel;
import video.Comment;
import video.PremiumVideo;
import video.Video;

public class RegisteredUser extends User{
	
	public RegisteredUser(String name) {
		this.name = name;
		this.registered = true;
	}

	public void update(String update) {
		System.out.println(this.name + " has been notified of " + update);
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void watch(Channel channel) {
		for(Video video : channel.getVideos()) {
			System.out.println("User " + name + " watched " + video.title);
			if(video.premium)
				commentVideo("Muito bom!", (PremiumVideo) video);
		}
	}
	
	public void commentVideo(String string, PremiumVideo video) {
		video.addComment(new Comment(this, string));
	}
}
