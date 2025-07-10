package linkedlist;
import java.util.ArrayList;
import java.util.List;

class FriendNode {
    int friendId;
    FriendNode next;
    
    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;
    
    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

class SocialMediaLinkedList {
    private UserNode head;
    private int userCount;
    
    SocialMediaLinkedList() {
        this.head = null;
        this.userCount = 0;
    }
    
    void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = this.head;
        this.head = newUser;
        this.userCount++;
    }
    
    UserNode searchByUserId(int userId) {
        UserNode current = this.head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    List<UserNode> searchByName(String name) {
        List<UserNode> results = new ArrayList<>();
        UserNode current = this.head;
        while (current != null) {
            if (current.name.toLowerCase().contains(name.toLowerCase())) {
                results.add(current);
            }
            current = current.next;
        }
        return results;
    }
    
    boolean addFriendConnection(int user1Id, int user2Id) {
        UserNode user1 = searchByUserId(user1Id);
        UserNode user2 = searchByUserId(user2Id);
        
        if (user1 == null || user2 == null) {
            return false;
        }
        
        if (user1Id == user2Id) {
            return false;
        }
        
        if (isFriend(user1, user2Id)) {
            return false;
        }
        
        FriendNode newFriend1 = new FriendNode(user2Id);
        newFriend1.next = user1.friends;
        user1.friends = newFriend1;
        
        FriendNode newFriend2 = new FriendNode(user1Id);
        newFriend2.next = user2.friends;
        user2.friends = newFriend2;
        
        return true;
    }
    
    boolean removeFriendConnection(int user1Id, int user2Id) {
        UserNode user1 = searchByUserId(user1Id);
        UserNode user2 = searchByUserId(user2Id);
        
        if (user1 == null || user2 == null) {
            return false;
        }
        
        boolean removed1 = removeFriendFromUser(user1, user2Id);
        boolean removed2 = removeFriendFromUser(user2, user1Id);
        
        return removed1 && removed2;
    }
    
    private boolean removeFriendFromUser(UserNode user, int friendId) {
        if (user.friends == null) {
            return false;
        }
        
        if (user.friends.friendId == friendId) {
            user.friends = user.friends.next;
            return true;
        }
        
        FriendNode current = user.friends;
        while (current.next != null) {
            if (current.next.friendId == friendId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    private boolean isFriend(UserNode user, int friendId) {
        FriendNode current = user.friends;
        while (current != null) {
            if (current.friendId == friendId) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    List<Integer> findMutualFriends(int user1Id, int user2Id) {
        List<Integer> mutualFriends = new ArrayList<>();
        UserNode user1 = searchByUserId(user1Id);
        UserNode user2 = searchByUserId(user2Id);
        
        if (user1 == null || user2 == null) {
            return mutualFriends;
        }
        
        FriendNode current1 = user1.friends;
        while (current1 != null) {
            if (isFriend(user2, current1.friendId)) {
                mutualFriends.add(current1.friendId);
            }
            current1 = current1.next;
        }
        
        return mutualFriends;
    }
    
    List<Integer> getFriendsOfUser(int userId) {
        List<Integer> friends = new ArrayList<>();
        UserNode user = searchByUserId(userId);
        
        if (user == null) {
            return friends;
        }
        
        FriendNode current = user.friends;
        while (current != null) {
            friends.add(current.friendId);
            current = current.next;
        }
        
        return friends;
    }
    
    int getFriendCount(int userId) {
        UserNode user = searchByUserId(userId);
        if (user == null) {
            return 0;
        }
        
        int count = 0;
        FriendNode current = user.friends;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    void displayAllUsers() {
        if (this.head == null) {
            System.out.println("No users in the system");
            return;
        }
        
        UserNode current = this.head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + 
                             ", Name: " + current.name + 
                             ", Age: " + current.age + 
                             ", Friends: " + getFriendCount(current.userId));
            current = current.next;
        }
    }
    
    void displayFriendsOfUser(int userId) {
        UserNode user = searchByUserId(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        
        List<Integer> friends = getFriendsOfUser(userId);
        if (friends.isEmpty()) {
            System.out.println("User " + user.name + " has no friends");
        } else {
            System.out.println("Friends of " + user.name + ":");
            for (int friendId : friends) {
                UserNode friend = searchByUserId(friendId);
                if (friend != null) {
                    System.out.println("- " + friend.name + " (ID: " + friendId + ")");
                }
            }
        }
    }
}

public class SocialMediaFriends {
    public static void main(String[] args) {
        SocialMediaLinkedList socialMedia = new SocialMediaLinkedList();
        
        socialMedia.addUser(1001, "Alice", 25);
        socialMedia.addUser(1002, "Bob", 30);
        socialMedia.addUser(1003, "Charlie", 28);
        socialMedia.addUser(1004, "Diana", 22);
        socialMedia.addUser(1005, "Eve", 27);
        
        System.out.println("All users:");
        socialMedia.displayAllUsers();
        
        System.out.println("\nAdding friend connections:");
        socialMedia.addFriendConnection(1001, 1002);
        socialMedia.addFriendConnection(1001, 1003);
        socialMedia.addFriendConnection(1002, 1003);
        socialMedia.addFriendConnection(1002, 1004);
        socialMedia.addFriendConnection(1003, 1004);
        socialMedia.addFriendConnection(1004, 1005);
        
        System.out.println("\nUpdated user list:");
        socialMedia.displayAllUsers();
        
        System.out.println("\nFriends of Alice:");
        socialMedia.displayFriendsOfUser(1001);
        
        System.out.println("\nFriends of Bob:");
        socialMedia.displayFriendsOfUser(1002);
        
        System.out.println("\nSearching for users by name 'Alice':");
        List<UserNode> aliceUsers = socialMedia.searchByName("Alice");
        for (UserNode user : aliceUsers) {
            System.out.println("Found: " + user.name + " (ID: " + user.userId + ")");
        }
        
        System.out.println("\nMutual friends between Alice and Bob:");
        List<Integer> mutualFriends = socialMedia.findMutualFriends(1001, 1002);
        for (int friendId : mutualFriends) {
            UserNode friend = socialMedia.searchByUserId(friendId);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friendId + ")");
            }
        }
        
        System.out.println("\nFriend counts:");
        System.out.println("Alice has " + socialMedia.getFriendCount(1001) + " friends");
        System.out.println("Bob has " + socialMedia.getFriendCount(1002) + " friends");
        System.out.println("Charlie has " + socialMedia.getFriendCount(1003) + " friends");
        
        System.out.println("\nRemoving friend connection between Alice and Bob:");
        socialMedia.removeFriendConnection(1001, 1002);
        
        System.out.println("\nUpdated friends of Alice:");
        socialMedia.displayFriendsOfUser(1001);
        
        System.out.println("\nUpdated friends of Bob:");
        socialMedia.displayFriendsOfUser(1002);
    }
} 