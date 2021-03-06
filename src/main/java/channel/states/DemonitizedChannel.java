package channel.states;

import channel.Channel;
import video.BasicVideo;
import video.Video;
import video.sponsor.NoSponsor;
import video.sponsor.Sponsor;

public class DemonitizedChannel implements ChannelState {

	Channel channel;

	public DemonitizedChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void applyVerified() {
		System.out.println("Channel "+ channel.name + " is demonitized and can't be verified!");
	}

	public void applySponsored() {
		System.out.println("Channel "+ channel.name + " is demonitized and can't be sponsored!");
	}

	public void getCopyright() {
		System.out.println("Channel "+ channel.name + " got copyrighted again!");
	}

	public void applyStandart() {
		System.out.println("Channel "+ channel.name + " has applied for removal of it's demonitized state!");
		if(channel.getCopyrightCounter() > 3)
			System.out.println("This channel was copyrighted too many times, sorry!");
		else {
			System.out.println("Channel had it's demonitized state removed!");
			channel.resetCopyrightCounter();
			channel.setChannelState(channel.getStandartState());
		}
	}
	
	public Sponsor getSponsor() {
		return new NoSponsor();
	}

	public void addVideo(String videoTitle) {
		Video newVideo = new BasicVideo(videoTitle, getSponsor());
		System.out.println("Channel " + channel.name + " has uploaded a new video titled " + videoTitle + " , this channel is demonitized and has no revenue!");
		channel.videos.add(newVideo);
		channel.notifySubscribers(videoTitle);
	}
}
