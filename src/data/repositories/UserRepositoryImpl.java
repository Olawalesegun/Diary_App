package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private List<User> users = new ArrayList();
    @Override
    public User save(User user) {
        for(User user1: users){
            users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public User findBy(String userName) {
        for(User user: users){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteBy(String userName) {
        User theUserToBeRemoved = null;
        for(User user: users){
            if(user.getUserName().equals(userName)){
                theUserToBeRemoved = user;
                users.remove(user);
            }
        }
    }

    @Override
    public void deleteBy(User userName) {
        User theUserToBeRemoved = null;
        for(User user: users){
            if(user.getUserName().equals(userName)){
                theUserToBeRemoved = user;
                users.remove(user);
            }
        }
    }

    @Override
    public long count() {
        return users.size();
    }
}
