import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private Integer loginAttempts = 4;
    private final String NORMAL_USER = "normal_user";
    private final String SUPER_USER = "super_user";
    private FileService fileService = new FileService();
    private List<User> userArrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public String getNORMAL_USER() { return NORMAL_USER; }
    public String getSUPER_USER() { return SUPER_USER; }
    public Integer getLoginAttempts(){ return loginAttempts; }
    public void setLoginAttempts(Integer loginAttempts){
        if(loginAttempts == 0){
            System.out.println("Too many attempts. You are now locked out.");
        }
        this.loginAttempts = loginAttempts;
    }

    /*
        read file data.txt
        split by comma
        create new User object based on csv position
        0 - username
        1 - password
        2 - name
     */
    public List<User> addUsers(){
        List<String> listStrings = fileService.readFile();
        for (String s : listStrings){
            userArrayList.add(new User(s.split(",")[0], s.split(",")[1], s.split(",")[2], s.split(",")[3]));
        }
        return userArrayList;
    }

    public String[] askLoginDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your username: ");
        String username = scanner.nextLine();
        System.out.println("Insert your password: ");
        String password = scanner.nextLine();
        return new String[] {username, password};
    }

    public User isMatch(String username, String password, List<User> listOfUsers){
        for (User u : listOfUsers){
            if((u.getUsername().equalsIgnoreCase(username)) && (u.getPassword().equals(password))) {
                System.out.println("Welcome " + u.getName());
                return u;
            }
        }
        return null;
    }

    public User validateUserDetails(User matchUser, List<User> users) {
        String username, password;
        while (loginAttempts > 0 && matchUser == null) {
            System.out.println("Invalid login. Try again.");
            System.out.println("Insert your username: ");
            username = scanner.nextLine();
            System.out.println("Insert your password: ");
            password = scanner.nextLine();

            matchUser = isMatch(username, password, users);
            if(matchUser == null){
                setLoginAttempts(loginAttempts - 1);
                loginAttempts = getLoginAttempts();
            }
        }
        return matchUser;
    }

    public void menuNormalUser(){
        System.out.println("Please choose from the following options: ");
       System.out.println("(1) Update username");
       System.out.println("(2) Update password");
       System.out.println("(3) Update name");
       System.out.println("(4) Exit");
   }

    public void menuSuperUser(){
        System.out.println("Please choose from the following options: ");
        System.out.println("(0) Log in as another user");
        System.out.println("(1) Update username");
        System.out.println("(2) Update password");
        System.out.println("(3) Update name");
        System.out.println("(4) Exit");
    }


    public String updateUsername(){
        System.out.println("Type in your new username: ");
        return scanner.nextLine();
    }

    public String updatePassword(){
        System.out.println("Type in your new password: ");
        return scanner.nextLine();
    }

    public String updateName(){
        System.out.println("Type in your new name: ");
        return scanner.nextLine();
    }

}
