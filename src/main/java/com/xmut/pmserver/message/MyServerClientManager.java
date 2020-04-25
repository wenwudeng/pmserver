package com.xmut.pmserver.message;

import java.util.ArrayList;
import java.util.List;

public class MyServerClientManager {
    private List<User> list = new ArrayList<>();

    private static MyServerClientManager manager = new MyServerClientManager();
    private MyServerClientManager() { }
    public static MyServerClientManager getInstance() {
        return manager;
    }

    public List<User> getClientList() {
        return list;
    }

    public void addClient(User user) {
        list.add(user);
    }

    public void removeClient(User user) {
        list.remove(user);
    }

}
