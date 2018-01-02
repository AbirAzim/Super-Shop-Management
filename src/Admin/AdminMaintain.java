package Admin;

import java.util.ArrayList;

public class AdminMaintain {

    private static AdminMaintain adminMaintain;
    private ArrayList<Admin> adminList;

    private AdminMaintain(){
        adminList = new ArrayList<Admin>();
    }

    public static AdminMaintain getInstance(){
        if(adminMaintain == null){
            adminMaintain = new AdminMaintain();
        }
        return adminMaintain;
    }

    public void addAdmin(Admin admin){
        adminList.add(admin);
    }

    public ArrayList<Admin> getAdminList(){
        return adminList;
    }
}
