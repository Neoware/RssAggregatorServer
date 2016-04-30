package models;

import play.api.libs.Crypto;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public void CreateUser(String username, String password, String email){
        User temp = userDao.findUserByUsername(username);
        if (temp == null){
            User toCreate = new User(username, password, email);
            toCreate.setUserHash(MD5(username+password));
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
            toUpdate.setUserHash(MD5(username+password));
            userDao.updateUser(toUpdate);
        }
    }

    public User authenticateByHash(String userHash){
        return userDao.findByHash(userHash);
    }
}
