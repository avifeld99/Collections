package opdracht;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        //your cards
        PostCard belgium = new PostCard("Belgium", "Europe");
        PostCard france = new PostCard("France", "Europe");
        PostCard japan = new PostCard("Japan", "Asia");
        PostCard rdc = new PostCard("Democratic Republic of Congo", "Africa");
        PostCard southKorea = new PostCard("South Korea", "Asia");
        PostCard belgium2 = new PostCard("Belgium", "Europe");
        PostCard southAfrica = new PostCard("South Africa", "Africa");
        PostCard france2 = new PostCard("France", "Europe");
        PostCard belgium3 = new PostCard("Belgium", "Europe");
        PostCard usa = new PostCard("United States of America", "North America");
        PostCard canada = new PostCard("Canada", "North America");
        PostCard peru = new PostCard("Peru", "South America");
        PostCard samoa = new PostCard("Samoa", "Oceania");
        PostCard belgium4 = new PostCard("Belgium", "Europe");
        PostCard france3 = new PostCard("France", "Europe");

        List<PostCard> yourPostCardList = new ArrayList<>();
        yourPostCardList.add(belgium);
        yourPostCardList.add(france);
        yourPostCardList.add(japan);
        yourPostCardList.add(rdc);
        yourPostCardList.add(southKorea);
        yourPostCardList.add(belgium2);
        yourPostCardList.add(southAfrica);
        yourPostCardList.add(france2);
        yourPostCardList.add(belgium3);
        yourPostCardList.add(usa);
        yourPostCardList.add(canada);
        yourPostCardList.add(peru);
        yourPostCardList.add(samoa);
        yourPostCardList.add(belgium4);
        yourPostCardList.add(france3);

        //your friend’s cards
        PostCard northKorea = new PostCard("North Korea", "Asia");
        PostCard usa2 = new PostCard("United States of America", "North America");
        PostCard botswana = new PostCard("Botswana", "Africa");
        PostCard northKorea2 = new PostCard("North Korea", "Asia");

        List<PostCard> yourFriendsPostCardList = new ArrayList<>();
        yourFriendsPostCardList.add(northKorea);
        yourFriendsPostCardList.add(usa2);
        yourFriendsPostCardList.add(botswana);
        yourFriendsPostCardList.add(northKorea2);

        //your friends
        Friend bobby = new Friend("Bobby", false, 3, 5);
        Friend melissa = new Friend("Melissa", false, 1, 6);
        Friend darla = new Friend("Darla", true, 14, 2);
        Friend bert = new Friend("Bert", false, 10, 4);
        Friend grandma = new Friend("Nana", true, 12, 7);
        Friend fester = new Friend("Fester", false, 1, 2);
        Friend anna = new Friend("Anna", false, 8, 4);

        System.out.println("BEFORE TRADING:");
        System.out.println(yourPostCardList);
        System.out.println("^ MY LIST | FRIENDS LIST v");
        System.out.println(yourFriendsPostCardList);

        sortListByCountry(yourPostCardList);
        exercise(yourPostCardList, yourFriendsPostCardList);
        sortListByCountry(yourPostCardList);

        System.out.println("AFTER TRADING:");
        System.out.println(yourPostCardList);
        System.out.println("^ MY LIST | FRIENDS LIST v");
        System.out.println(yourFriendsPostCardList);

        List<PostCard> duplicates = new ArrayList<>();
        for (int i = 0; i < yourPostCardList.size(); i++) {
            PostCard postCard = yourPostCardList.get(i);
            int amount = Collections.frequency(yourPostCardList, postCard);
            System.out.println(postCard.getCountry() + ": " + amount);
            if (amount > 1) {
                duplicates.add(postCard);
                yourPostCardList.remove(postCard);
                i--;
            }
        }

        System.out.println(yourPostCardList);
        System.out.println(duplicates);

        Comparator<Friend> compareFamily = (friend1, friend2) -> Boolean.compare(friend2.isFamily(), friend1.isFamily());
        Comparator<Friend> compareFriendship = (friend1, friend2) -> Integer.compare(friend2.getFriendshipLevel(), friend1.getFriendshipLevel());
        Comparator<Friend> compareDuration = (friend1, friend2) -> Integer.compare(friend2.getYearsKnown(), friend1.getYearsKnown());

        Queue<Friend> sortedFriends = new PriorityQueue<>(
                compareFamily.thenComparing(compareFriendship).thenComparing(compareDuration)
        );
        sortedFriends.offer(bobby);
        sortedFriends.offer(melissa);
        sortedFriends.offer(darla);
        sortedFriends.offer(bert);
        sortedFriends.offer(grandma);
        sortedFriends.offer(fester);
        sortedFriends.offer(anna);

        while (sortedFriends.size() > 0) {
            System.out.println(sortedFriends.poll());
        }

        /*//opdracht 1
        yourFriendsPostCardList.add(yourPostCardList.get(0));
        yourPostCardList.set(0, yourFriendsPostCardList.get(0));
        yourFriendsPostCardList.remove(0);
        yourFriendsPostCardList.forEach(cards -> System.out.println("Friends card: \n" + cards));
        yourPostCardList.forEach(cards -> System.out.println("My card: \n" + cards));

        System.out.println("-------------");

        // opdracht 2
        yourPostCardList.sort(Comparator.comparing(postCard -> postCard.getCountry()));
        yourPostCardList.forEach(cards -> System.out.println(cards));

        System.out.println("-------------");

        // opdracht 3
        int freq = Collections.frequency(yourPostCardList, france3);

        System.out.println(freq);
        */
    }

    private static void exercise(List<PostCard> myList, List<PostCard> friendsList) {
        PostCard myPostCardToTrade = null;
        PostCard myFriendsPostCardToTrade = null;

        int myIndex = 0;

        for (int i = 0; i < myList.size(); i++) {
            PostCard postCard = myList.get(i);
            for (int j = i + 1; j < myList.size(); j++) {
                if (myList.get(j).getCountry().equals(postCard.getCountry())) {
                    myPostCardToTrade = postCard;
                    myIndex = i;
                    break;
                }
            }
            if (myPostCardToTrade != null) {
                break;
            }
        }

        for (int i = 0; i < friendsList.size(); i++) {
            PostCard postCard = friendsList.get(i);
            for (int j = i + 1; j < friendsList.size(); j++) {
                if (friendsList.get(j).getCountry().equals(postCard.getCountry())) {
                    myFriendsPostCardToTrade = postCard;
                    break;
                }
            }
            if (myFriendsPostCardToTrade != null) {
                break;
            }
        }

        if (myPostCardToTrade != null && myFriendsPostCardToTrade != null) {
            myList.set(myIndex, myFriendsPostCardToTrade);
            friendsList.remove(myFriendsPostCardToTrade);
            friendsList.add(myPostCardToTrade);
        }
    }

    private static void sortListByCountry(List<PostCard> myList) {
        Collections.sort(myList, Comparator.comparing(postCard -> postCard.getCountry()));
    }
}
