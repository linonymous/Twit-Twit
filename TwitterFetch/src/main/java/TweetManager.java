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
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Enter-Consumer-Key")
                .setOAuthConsumerSecret("Enter-Consumer-Secret")
                .setOAuthAccessToken("Enter-Access-Token")
                .setOAuthAccessTokenSecret("Enter-Access-Secret-Token");
        TwitterFactory tf = new TwitterFactory(cb.build());
        //Twitter twitter = tf.getInstance();
        Twitter twitter = tf.getInstance();
        String a="Tweeting through twitter4j! Its Amazing! #FUN #Twitter #TensedMSE";
        Status status = twitter.updateStatus(a);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        /*
        ArrayList<String> tweetList = new ArrayList<String>();
        try {
            Query query = new Query("MWC16");
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
        System.out.print(tweetList);*/
    }
}
