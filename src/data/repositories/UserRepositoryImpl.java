package data.repositories;

import data.models.Diary;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private final List<User> users = new ArrayList();
    @Override
    public User save(User user) {
        if(user != null){
            users.add(user);
            return user;
        }
        return null;
        //users.add(user);
       /* User foundUser = findBy(user.getUserName());
        if(foundUser != null){
            update(diary, foundUser);
        }
        else{
            diaries.add(diary);
        }*/

       /* for(User user1: users){
            users.add(user);
            return user;
        }*/
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
