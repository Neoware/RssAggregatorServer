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
        userDao.findUserByUsername(username)

    }

    public void DeleteUser(String username){

    }

    public void UpdateUser(String username, String password, String email){

    }
}
