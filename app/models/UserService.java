package models;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }


    public void CreateUser(String username, String password, String email){
        User temp = userDao.findUserByUsername(username);
        if (temp == null){
            User toCreate = new User(username, password, email);
            userDao.createUser(toCreate);
        }
        else{
            System.out.println("User already exists");
        }

    }

    public void DeleteUser(String username){
        User temp = userDao.findUserByUsername(username);
        if (temp == null){
            //Normally should never get there
            System.out.println("User doesn't exist");
        }
        else{
            userDao.deleteUser(temp);
        }
    }

    public void UpdateUser(String username, String password, String email){
        User temp = userDao.findUserByUsername(username);
        if (temp == null){
            System.out.println("User doesn't exist");
        }
        else{
            User toUpdate = new User(temp.getId(), username, password, email);
            userDao.updateUser(toUpdate);
        }
    }
}
