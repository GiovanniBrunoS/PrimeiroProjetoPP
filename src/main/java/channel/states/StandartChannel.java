package channel.states;

import channel.Channel;
import video.BasicVideo;
import video.Video;
import video.sponsor.NoSponsor;
import video.sponsor.Sponsor;

public class StandartChannel implements ChannelState {

	Channel channel;

	public StandartChannel(Channel channel) {
		this.channel = channel;
	}
	public void applyVerified() {
		System.out.println("Channel "+ channel.name + " applied for verified!");
		channel.setChannelState(channel.getVerifiedState());
	}

	public void applySponsored() {
		System.out.println("Channel "+ channel.name + " can't apply for sponsored yet!");
	}

	public void getCopyright() {
		System.out.println("Channel "+ channel.name + " got copyrighted!");
		channel.setChannelState(channel.getDemonitizedState());
	}

	public void applyStandart() {
		System.out.println("Channel "+ channel.name + " is already a standart channel!");
	}

	public Sponsor getSponsor() {
		return new NoSponsor();
	}
	
	public void addVideo(String videoTitle) {
		Video newVideo = new BasicVideo(videoTitle, getSponsor());
		System.out.println("Channel " + channel.name + " has uploaded a new video titled " + videoTitle + " , this video revenue is: " + newVideo.sponsor.revenue());
		channel.videos.add(newVideo);
		channel.notifySubscribers(videoTitle);
	}

}
