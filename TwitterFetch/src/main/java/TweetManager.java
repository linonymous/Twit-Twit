/**
 * Created by LINONYMOUS on 22-02-2016.
 */
import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetManager {

    public static void main(String []args) throws Exception{
        ConfigurationBuilder cb = new ConfigurationBuilder();
        
        // Setting all the keys
        
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Enter-Consumer-Key")
                .setOAuthConsumerSecret("Enter-Consumer-Secret")
                .setOAuthAccessToken("Enter-Access-Token")
                .setOAuthAccessTokenSecret("Enter-Access-Secret-Token");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = new TwitterFactory().getInstance();
        String topic="CurrentTopic";
        ArrayList<String> tweetList = new ArrayList<String>();
        try {
            Query query = new Query(topic);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    tweetList.add(tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        System.out.print(tweetList);
    }
}
