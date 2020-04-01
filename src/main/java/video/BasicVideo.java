package video;

import video.sponsor.Sponsor;

public class BasicVideo extends Video {

	public BasicVideo(String title, Sponsor sponsor) {
		super(title, sponsor);
	}

	@Override
	public void getComments() {
		System.out.println("Basic Videos have no comments!");
		
	}
}
