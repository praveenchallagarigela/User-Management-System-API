package com.user.controller;

import com.user.entity.User;
import com.user.repo.userRepo;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class usersController {
    @Autowired
    private userRepo repo;
    @Autowired
    private UserService service;

    @PostMapping("/save")
    public User saveUserInfo(@RequestBody User user) {
        return service.SaveUserData(user);

    }

    @GetMapping("/getall")
    public List<User> GetAllUserInfo() {
        List<User> list = new ArrayList<User>();
        list = service.getAllUsersData();

        //You can try with direct using repo reference
        //list=repo.findAll();
        return list;

    }
  @DeleteMapping("/delete/{uid}")
    public String deleteData(@PathVariable Integer uid) {

        String s1= service.deleteData(uid);
        return s1;
    }

    @PutMapping("/update/{uid}")
    public User UpdateData(@RequestBody User user,@PathVariable Integer uid)
    {

        return service.updateUserData(user,uid);

    }

    @GetMapping("/{uid}")
    public User getOneUserData(@PathVariable Integer uid)
    {
        return service.getOneUserInfo(uid);
    }


}
