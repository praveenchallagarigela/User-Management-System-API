package com.user.service;

import com.user.entity.User;
import com.user.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private userRepo repo;
    public User SaveUserData(User user)
    {
        User u1=repo.save(user);
        return u1;
    }


    public List<User> getAllUsersData()
    {
        List<User> list=repo.findAll();
        return list;
    }

    public String deleteData(Integer uid){
        Optional<User> u1=repo.findById(uid);
        if(u1.isPresent()){
           repo.deleteById(uid);
           return "One user Data Deleted successfully";
        }else{

            return null;
        }
    }
    public User updateUserData(User user, Integer uid) {
        User u1 = new User();
        Optional<User> optional = repo.findById(uid);
        if (optional.isPresent())
        {
            u1.setUid(uid);
            u1.setUname(user.getUname());
            u1.setAbout(user.getAbout());
            u1=repo.save(user);
            return u1;
        }
        else{
            u1 = null;
            return u1;
        }

    }
    public User getOneUserInfo(Integer uid)
    {
        User u123=null;
        Optional<User> u2=repo.findById(uid);
        if(u2.isPresent()){
            u123=repo.findById(uid).get();
            System.out.println("Well Done We have Passed data to controller belongs to id "+uid);
        }
        else{
            System.out.println("There is no data belongs to these id " + uid);
        }
        return u123;

    }
}
