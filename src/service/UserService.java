/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;

/**
 *
 * @author pc asus
 */
public class UserService extends AbstractFacade<User>{
    
    public UserService() {
        super(User.class);
    }
    
    public User createUser(String id,String password){
        User user=new User(id, password);
        user.setBloqued(0);
        user.setNbtrentatifRestant(3);
        create(user);
        return user;
    }
    
    public int login(String id,String password){
        User user =find(id);
        if(user==null){
            return -1;
        }else if(user.getBloqued()!=0){
            return -2;
        }else if(!password.equals(user.getPassword())){
            if(user.getNbtrentatifRestant()!=0){
                user.setNbtrentatifRestant(user.getNbtrentatifRestant()-1);
                if(user.getNbtrentatifRestant()==0){
                    user.setBloqued(1);
                    edit(user);
                    return -3;
                }
                edit(user);
                return -4;
            }
        }
        return 1;
    }
    
    
}
