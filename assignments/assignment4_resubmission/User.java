public class User {
    private String username;
    private String password;
    private String name;
    private String role;

    public User(String username, String password, String name, String role){
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    public String getUsername() {
        return username.strip();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password.strip();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name.strip();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role.strip();
    }

    public void setRole(String role) {
        this.role = role;
    }
}
