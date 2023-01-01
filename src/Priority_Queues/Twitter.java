package Priority_Queues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Twitter {

    Map<Integer, HashSet<Integer>> fMap;
    Map<Integer, LinkedList<Tweet>> tMap;
    int count = 0;

    public Twitter() {
        fMap = new HashMap<>();
        tMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!fMap.containsKey(userId))
            fMap.put(userId, new HashSet<>());
        fMap.get(userId).add(userId);
        if (!tMap.containsKey(userId))
            tMap.put(userId, new LinkedList<Tweet>());
        tMap.get(userId).addFirst(new Tweet(tweetId, count++));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!fMap.containsKey(userId))
            return new LinkedList<Integer>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        for (int fId : fMap.get(userId)) {
            if (tMap.containsKey(fId)) {
                for (Tweet tweet : tMap.get(fId)) {
                    pq.add(tweet);
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (pq.size() > 0 && res.size() < 10)
            res.add(pq.poll().tweetId);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!fMap.containsKey(followerId))
            fMap.put(followerId, new HashSet<Integer>());

        fMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (fMap.containsKey(followerId) && followerId != followeeId)
            fMap.get(followerId).remove(followeeId);
    }

    class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
}
