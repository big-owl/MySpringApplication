package com.app.service;

import com.app.user.UserDto;
import com.app.user.UserList;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final Map<Long, UserDto> users = new ConcurrentHashMap<>();

    public UserDto getUser(long id) {
        return users.get(id);
    }

    public UserList getAllUsers() {
        UserList userList = new UserList();
        users.values().forEach(userList::addUser);
        return userList;
    }

    public void saveUser(UserDto user) {
        users.put(user.getId(), user);
    }

    public boolean updateUserName(long id, String name) {
        UserDto user = users.get(id);
        if (user != null) {
            return user.setName(id, name);
        }
        return false;
    }
}

