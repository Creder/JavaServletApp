package business;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String email;
    private String username;
    private String password;

    public User(){

    }

    public User(Long userid, String email, String username, String password){

        this.userId = userid;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username){
        this.username = username;
    }


    public String getEmail(){ return email;}

    public void setEmail(String email){ this.email =email;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }
}
