import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String name;
    private String role;

    public User() {};

    public User(String username, String password, String name, String role) {
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

    public void selectOption(UserService userService, FileService fileService, User matchUser) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = fileService.getLine(matchUser.getUsername());
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                String usernameToUpdate = userService.updateUsername();
                fileService.updateFile(usernameToUpdate, matchUser.getPassword(), matchUser.getName(), matchUser.getRole(), lineNumber);
                break;
            case 2:
                String passwordToUpdate = userService.updatePassword();
                fileService.updateFile(matchUser.getUsername(), passwordToUpdate, matchUser.getName(), matchUser.getRole(), lineNumber);
                break;
            case 3:
                String nameToUpdate = userService.updateName();
                fileService.updateFile(matchUser.getUsername(), matchUser.getPassword(), nameToUpdate, matchUser.getRole(), lineNumber);
                break;
            case 4:
                System.out.println("Goodbye");
                System.exit(0);
            default:
                System.exit(0);
        }
    }
}
