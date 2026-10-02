class Twitter {

    class Tweet{
        public int tweetId;
        public int time;
        public Tweet next;

        public Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, Tweet> tweets;
    Map<Integer, Set<Integer>> followers;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, time++);
        newTweet.next = tweets.get(userId);
        tweets.put(userId, newTweet);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a,b) -> 
                b.time - a.time
            
        );

        if(tweets.containsKey(userId)){
            maxHeap.add(tweets.get(userId));
        }
        if(followers.containsKey(userId)){
            for(int follower: followers.get(userId)){
                if(follower!= userId && tweets.containsKey(follower)){
                    maxHeap.add(tweets.get(follower));
                }
            }
        }

        while(!maxHeap.isEmpty() && result.size()<10){
            Tweet latest = maxHeap.poll();
            result.add(latest.tweetId);

            if(latest.next!= null){
                maxHeap.add(latest.next);
            }
        }

        return result;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
        }
    }
}
