package org.hyperskill.rest.controllers;

import org.hyperskill.rest.user.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class UserInfoController {
    private List<UserInfo> usersInfo = new CopyOnWriteArrayList<>();

    @GetMapping("/users")
    public List<UserInfo> getUsersInfo() {
        return usersInfo;
    }

    @PostMapping("/user")
//    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_XML_VALUE)
    public String userStatus(@RequestBody List<UserInfo> userList) {
        usersInfo.addAll(userList);
        return String.format("Added %d users", userList.size());
    }
}
