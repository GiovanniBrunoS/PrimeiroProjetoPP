package channel;

import java.util.ArrayList;

import channel.states.ChannelState;
import channel.states.DemonitizedChannel;
import channel.states.SponsoredChannel;
import channel.states.StandartChannel;
import channel.states.VerifiedChannel;
import user.User;
import video.Video;

public class Channel {
	
	private User owner;
	public String name;
	public ArrayList<Video> videos;
	public ArrayList<User> subscribers;
	
	private ChannelState channelState;
	private ChannelState verified;
	private ChannelState sponsored;
	private ChannelState demonitized;
	private ChannelState standart;
	
	private int copyrightCounter;

	public Channel(User owner, String name) {
		super();
		this.owner = owner;
		this.name = name;
		this.videos = new ArrayList<Video>();
		this.subscribers = new ArrayList<User>();
		this.copyrightCounter = 0;
		
		verified = new VerifiedChannel(this);
		sponsored = new SponsoredChannel(this);
		demonitized = new DemonitizedChannel(this);
		standart = new StandartChannel(this);
		
		channelState = standart;
	}

	public void addSubscribers(User subscriber) {
		if(subscriber.registered) {
			System.out.println("User " + subscriber.name + " has subscribed to channel " + name);
			this.subscribers.add(subscriber);
		}
		else
			System.out.println("User "+ subscriber.name +" isn't registered");
	}
	
	public void removeSubscribers(User subscriber) {
		System.out.println("User " + subscriber.name + " has unsubscribed from channel " + name);
		this.subscribers.remove(subscriber);
	}
	
	public void notifySubscribers(String title) {
		for(User subscriber: subscribers) {
			subscriber.update("New video " + title + " in channel " + name);
		}
	}
	
	public User getOwner() {
		return owner;
	}

	public int getCopyrightCounter() {
		return copyrightCounter;
	}

	public void increaseCopyrightCounter() {
		this.copyrightCounter += 1;
	}
	
	public void resetCopyrightCounter() {
		this.copyrightCounter = 0;
	}
	
	public void addVideo(String videoTitle) {
		channelState.addVideo(videoTitle);
	}
	
	public ArrayList<Video> getVideos(){
		return videos;
	}
	
	public void setChannelState(ChannelState newChannelState) {
		channelState = newChannelState;
	}
	
	public void applyVerified() {
		channelState.applyVerified();
	}
	
	public void applySponsored() {
		channelState.applySponsored();
	}
	
	public void getCopyright() {
		increaseCopyrightCounter();
		channelState.getCopyright();
	}
	
	public void applyStandart() {
		channelState.applyStandart();
	}
	
	public ChannelState getVerifiedState() {
		System.out.println("Channel "+ name + " is now Verified!");
		return verified;
	}
	
	public ChannelState getSponsoredState() {
		System.out.println("Channel "+ name + " is now Sponsored!");
		return sponsored;
	}
	
	public ChannelState getDemonitizedState() {
		System.out.println("Channel "+ name + " is now Demonitized!");
		return demonitized;
	}
	
	public ChannelState getStandartState() {
		System.out.println("Channel "+ name + " is now a Standart Channel!");
		return standart;
	}
}
