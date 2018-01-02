package Admin;

import java.util.Date;

public class Admin {

    private String userName;
    private String id;
    private String password;
    private Date joinDate;


    public Admin(){


    }

    public Admin(String userName, String id, String password ) {
        this.userName = userName;
        this.id = id;
        this.password = password;
        this.joinDate = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {


        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
