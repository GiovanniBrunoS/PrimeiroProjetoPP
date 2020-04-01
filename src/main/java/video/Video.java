package video;

import video.sponsor.Sponsor;

public abstract class Video {
	
	public String title;
	public int views;
	public Sponsor sponsor;
	public Boolean premium;

	public Video(String title, Sponsor sponsor) {
		super();
		this.title = title;
		this.views = 0;
		this.sponsor = sponsor;
		this.premium = false;
	}
	
	public abstract void getComments();
}
