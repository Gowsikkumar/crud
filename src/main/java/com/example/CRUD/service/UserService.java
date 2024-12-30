package com.example.CRUD.service;

import com.example.CRUD.model.User;
import com.example.CRUD.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repoobj;
    public UserService(UserRepository repoobj)
    {
        this.repoobj=repoobj;
    }
    public List<User> create(User user)
    {
        return Collections.singletonList(repoobj.save(user));
    }
    public Optional<User>getById(long id){
        return repoobj.findById(id);
    }
    public void deleteById(long id)
    {
        repoobj.deleteById(id);
    }
    public List<User> Read(){
        return repoobj.findAll();
    }
}
