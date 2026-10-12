class Twitter {
    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet head;

        User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // Automatically follow yourself
            head = null;
        }

        public void follow(int followeeId) {
            followed.add(followeeId);
        }

        public void unfollow(int followeeId) {
            // Cannot unfollow yourself
            if (followeeId != this.id) {
                followed.remove(followeeId);
            }
        }

        public void post(int tweetId) {
            Tweet t = new Tweet(tweetId);
            t.next = head;
            head = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add the head tweet of all followed users into the max-heap
        for (int fId : followedUsers) {
            User fUser = userMap.get(fId);
            if (fUser != null && fUser.head != null) {
                pq.offer(fUser.head);
            }
        }

        // Extract up to 10 most recent tweets
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;

            // Move to the next tweet in the user's linked list
            if (t.next != null) {
                pq.offer(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}