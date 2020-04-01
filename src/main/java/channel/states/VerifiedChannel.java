package channel.states;

import channel.Channel;
import video.PremiumVideo;
import video.Video;
import video.sponsor.SmallSponsor;
import video.sponsor.Sponsor;

public class VerifiedChannel implements ChannelState {
	
	Channel channel;

	public VerifiedChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void applyVerified() {
		System.out.println("Channel "+ channel.name + " is already verified!");
	}

	public void applySponsored() {
		System.out.println("Channel "+ channel.name + " applied for sponsored!");
		channel.setChannelState(channel.getSponsoredState());
	}

	public void getCopyright() {
		System.out.println("Channel "+ channel.name + " got copyrighted!");
		channel.setChannelState(channel.getDemonitizedState());
	}

	public void applyStandart() {
		System.out.println("Channel "+ channel.name + " has lost it's status as verified!");
		channel.setChannelState(channel.getStandartState());
	}

	public Sponsor getSponsor() {
		return new SmallSponsor();
	}
	
	public void addVideo(String videoTitle) {
		Video newVideo = new PremiumVideo(videoTitle, getSponsor());
		System.out.println("Channel " + channel.name + " has uploaded a new video titled " + videoTitle + " , this video revenue is: " + newVideo.sponsor.revenue());
		channel.videos.add(newVideo);
		channel.notifySubscribers(videoTitle);
	}

}
