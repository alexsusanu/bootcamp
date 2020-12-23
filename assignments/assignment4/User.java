public class User{
    private String username;
    private String password;
    private String name;
    private String role;
    private int loginAttempts = 1;
    private final int MAX_ATTEMPTS = 5;

    public User(){}

    public User(String username, String password, String name, String role){
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    public String getUsername(){
        return username.strip();
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password.strip();
    }
    public String getName(){
        return name.strip();
    }
    public int getLoginAttempts(){
        return loginAttempts;
    }

    public int setLoginAttempts(int loginAttempts){
        return this.loginAttempts = loginAttempts;
    }

    public int getMaxAttempts(){
        return MAX_ATTEMPTS;
    }
    
}
