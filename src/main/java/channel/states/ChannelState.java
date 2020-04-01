package channel.states;


public interface ChannelState {

	void applyVerified();
	void applySponsored();
	void getCopyright();
	void applyStandart();
	void addVideo(String videoTitle);
	
}
