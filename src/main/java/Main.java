import channel.Channel;
import user.User;
import user.UserDAO;
import video.Video;

public class Main {

	public static void main(String[] args) {
			
		User user1 = UserDAO.getUser("João");
		User user2 = UserDAO.getUser("Maria");
		User user3 = UserDAO.getUser("Lucas");
		User user4 = UserDAO.getUser("Daiane");
		User user5 = UserDAO.getUser("Marcia");
		
		Channel ch1 = new Channel(user1, "canal do joão");
		
		ch1.addSubscribers(user2);
		ch1.addSubscribers(user3);
		ch1.addSubscribers(user5);
		
		System.out.println("");
			
		ch1.addVideo("Primeiro video do canal");
		
		System.out.println("");
		
		ch1.addSubscribers(user4);
		
		System.out.println("");
		
		ch1.applySponsored();
		ch1.applyVerified();
		ch1.applySponsored();
		
		System.out.println("");
		
		ch1.addVideo("Segundo video do canal!");
		
		System.out.println("");
		
		user2.watch(ch1);
		user3.watch(ch1);
		user4.watch(ch1);
		user5.watch(ch1);
		
		System.out.println("");
		
		for(Video video : ch1.getVideos()) {
			video.getComments();
		}
		
		System.out.println("");
		
		ch1.getCopyright();
		ch1.getCopyright();
		ch1.applyStandart();
		
	}

}
