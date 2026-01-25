package com.app.service;

import com.app.user.UserDto;
import com.app.user.UserList;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    // Note: ConcurrentHashMap does not allow duplicate keys.
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
        // Note: if user with same id exists, it will be replaced.
        users.put(user.getId(), user);
    }

    public void updateUserName(long id, String name) {
        UserDto user = users.get(id);
        if (user != null) {
            // user id exists, update the name
            user.setName(name);
            // save updated user
            saveUser(user);
        }
        else {
            // user does not exist, so add new user
            user = new UserDto();
            user.setId(id);
            user.setName(name);
            saveUser(user);
        }
    }
}

