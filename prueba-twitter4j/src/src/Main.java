package src;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class Main {

	public static void main(String[] args) throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
		// PRUEBA 1
		showTimeline(twitter);
		// PRUEBA 2
		findInTimeline(twitter, "DLC");
		// PRUEBA 3
		tellMeMyFollowers(twitter);
	}

	private static void showTimeline(Twitter twitter) {
		List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();
			System.out.println("Mostrando timeline del inicio.\n");
			for (Status status : statuses) {
				System.out.println("Tweet de: " + status.getUser().getName() + "\nContenido : " + status.getText());
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private static void findInTimeline(Twitter twitter, String toFind) {
		List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();
			System.out.println("Mostrando timeline del inicio.\n");
			for (Status status : statuses) {
				if (status.getText().contains(toFind))
					System.out.println("Tweet de: " + status.getUser().getName() + "\nContenido : " + status.getText());
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private static void tellMeMyFollowers(Twitter twitter) {
		List<User> friendList = null;
		try {
			friendList = twitter.getFollowersList(twitter.getId(), -1);
			System.out.println("Mis seguidores son: ");
			int i = 0;
			for (User friend : friendList) {
					System.out.println(++i + ") @" + friend.getScreenName());
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
