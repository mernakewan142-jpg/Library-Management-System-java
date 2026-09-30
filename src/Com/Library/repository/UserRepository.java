package Com.Library.repository;

import Com.Library.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UserRepository {

    private ArrayList<User> users;
    private HashMap<Integer, User> usersById;
    private HashSet<Integer> userIds;

    public UserRepository() {
        this.userIds = new HashSet<>();
        this.users = new ArrayList<>();
        this.usersById = new HashMap<>();
    }

    public void addUser(User user){
        if (userIds.contains(user.getId())){
            System.out.println("User with this ID already exists");
            return;
        }
        userIds.add(user.getId());
        users.add(user);
        usersById.put(user.getId() , user);
    }

    public User getUserById(int id){

        return usersById.get(id);
    }

    public ArrayList<User> getAllUsers(){

        return users;
    }



}
