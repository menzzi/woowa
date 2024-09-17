package onboarding;

import java.util.*;

public class Problem7 {
    public List<String> friendList(String user, List<List<String>> friends){
        List<String> friendsList = new ArrayList<>();
        for(List<String> friend:friends){
            if(friend.get(0).equals(user)){
                friendsList.add(friend.get(1));
            }else if(friend.get(1).equals(user)){
                friendsList.add(friend.get(0));
            }
        }
        return friendsList;
    }

    public HashMap<String,Integer> point10(String user, List<String> friendList, List<List<String>> friends){
        HashMap<String,Integer> pointFriend = new HashMap<>();

        for(List<String> friend:friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if(friend1.equals(user)||friend2.equals(user)){
                continue;
            }
            if(friendList.contains(friend1)&& !friendList.contains(friend2)){
                pointFriend.put(friend2,pointFriend.getOrDefault(friend2,0)+10);
            }
            if(friendList.contains(friend2)&& !friendList.contains(friend1)){
                pointFriend.put(friend1,pointFriend.getOrDefault(friend1,0)+10);
            }
        }

        return pointFriend;
    }

    public HashMap<String,Integer> point1(HashMap<String,Integer> map,List<String> friendList, List<String> visitors){
        for(String visitor:visitors){
            if(!friendList.contains(visitor)){
                map.put(visitor,map.getOrDefault(visitor,0)+1);
            }
        }
        return map;
    }
    public List<String> sortPoint(HashMap<String,Integer> map){
        List<String> recommendFriends = new ArrayList<>();
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<String,Integer> entry:entryList){
            if(entry.getValue()!=0){
                recommendFriends.add(entry.getKey());
            }
        }
        return recommendFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 T = new Problem7();
        List<String> friendList = T.friendList(user, friends);
        HashMap<String,Integer> map = T.point10(user, friendList, friends);
        map = T.point1(map, friendList, visitors);
        List<String> answer = T.sortPoint(map);
        return answer;
    }
}
