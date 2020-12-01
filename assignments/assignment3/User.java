public class User{
    private String username;
    private String password;
    private String name;
    private int loginAttempts = 1;

    public User(){}

    public User(String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public int getLoginAttempts(){
        return loginAttempts;
    }

    public int setLoginAttempts(int loginAttempts){
        return this.loginAttempts = loginAttempts;
    }
    
}
