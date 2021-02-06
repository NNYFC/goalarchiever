/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goal.goal.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ACER
 */
@Entity
public class Users {
     @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    int id;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String pseudo;
    @Column(nullable = false)
    String password;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Goal.class)
    private List<Goal> goal;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String username, String pseudo, String password) {
        this.username = username;
        this.pseudo = pseudo;
        this.password = password;
    }

    public Users(String username, String pseudo, String password, List<Goal> goal) {
        this.username = username;
        this.pseudo = pseudo;
        this.password = password;
        this.goal = goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Goal> getGoal() {
        return goal;
    }

    public void setGoal(List<Goal> goal) {
        this.goal = goal;
    }
    
}
