/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goal.goal.controller;

//import org.springframework.stereotype.Controller;
import com.goal.goal.model.Goal;
import com.goal.goal.model.Type;
import com.goal.goal.model.Users;
import com.goal.goal.service.UserServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    UserServices userServices;
    
    @RequestMapping(method = RequestMethod.GET,value = "/")
    public String firstLoaded(){
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST,path = "/register")
    public Users saveUser(@RequestBody Users user){
        return userServices.addUser(user);
    }
    
    @RequestMapping(method = RequestMethod.POST,path = "/login")
    public Users loginUser(@RequestBody Users user){
        return userServices.authUser(user.getUsername(),user.getPassword());
    }
    
    @RequestMapping(method = RequestMethod.GET,value= "/type")
    public List<Type> listAllTypes(){
        return userServices.getAllTypes();
    }
    
    @RequestMapping(method = RequestMethod.POST,value= "/type")
    public ResponseEntity<Object> insertTypes(@RequestBody Type type){
        userServices.addType(type);
        return new ResponseEntity<>("Goal Type added successfully",HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.POST,value= "/goal")
    public ResponseEntity<Object> insertGoal(@RequestBody Goal goal){
        userServices.addGoal(goal);
        return new ResponseEntity<>("Goal added successfully",HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT,value= "/goal/{id]")
    public ResponseEntity<Object> updateGoal(@PathVariable("id") int id,@RequestBody Goal goal){
        userServices.updateGoal(id, goal);
        return new ResponseEntity<>("Goal updated successfully",HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value= "/goal/{id}")
    public ResponseEntity<Object> deleteGoal(@PathVariable int id){
        userServices.deleteGoal(id);
        return new ResponseEntity<>("Goal Deleted",HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT,value= "/type/{id]")
    public ResponseEntity<Object> updateTypes(@PathVariable("id") int id,@RequestBody Type type){
        userServices.addType(type);
        return new ResponseEntity<>("Type updated successfully",HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value= "/type/{id}")
    public ResponseEntity<Object> deleteTypes(@PathVariable int id){
        userServices.deleteType(id);
        return new ResponseEntity<>("Type Deleted",HttpStatus.OK);
    }
}
