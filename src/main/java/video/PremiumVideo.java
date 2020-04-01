package video;

import java.util.ArrayList;

import video.sponsor.Sponsor;

public class PremiumVideo extends BasicVideo{
	
	public int likes;
	public ArrayList<Comment> comments;

	public PremiumVideo(String title, Sponsor sponsor) {
		super(title, sponsor);
		this.likes = 0;
		this.comments = new ArrayList<Comment>();
		this.premium = true;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void getComments() {
		for(Comment comments : comments)
			System.out.println("User:" + comments.getOwner() + " Commented: " + comments.getText());
	}
}
