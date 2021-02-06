/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goal.goal.service;

import com.goal.goal.model.Goal;
import com.goal.goal.model.Type;
import com.goal.goal.model.Users;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface UserServices {
    List<Users> getAllUsers();
    List<Type> getAllTypes();
    Users authUser(String username,String password);
    Users addUser(Users user);
    Users updateUser(Users user);
    Type addType(Type type);
    Type updateType(Type type);
    void deleteType(int id);
    Goal addGoal(Goal goal);
    Goal updateGoal(int id,Goal goal);
    void deleteGoal(int id);
}
