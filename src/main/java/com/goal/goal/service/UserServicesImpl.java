/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goal.goal.service;

import com.goal.goal.model.Goal;
import com.goal.goal.model.Type;
import com.goal.goal.model.Users;
import com.goal.goal.repository.GoalRepository;
import com.goal.goal.repository.TypeRepository;
import com.goal.goal.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    UserRepository userRepository;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    GoalRepository goalRepository;
    
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void deleteType(int id) {
        Type type = typeRepository.getOne(id);
        typeRepository.delete(type);
    }

    @Override
    public Goal addGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal updateGoal(int id,Goal goal) {
        Optional<Goal> test = goalRepository.findById(id);
        
        return goalRepository.save(goal);
    }

    @Override
    public void deleteGoal(int id) {
        Goal goal = goalRepository.getOne(id);
        goalRepository.delete(goal);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Users authUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    
}
