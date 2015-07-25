import java.util.ArrayList;

/**
 * Created by R2 on 23.07.2015.
 */
public class Branch {
    private static final int MAX_CUSTOMERS = 100;
    private static int customersCounter;
    private static int idBranch;

    //  BranchInfo branchInfo;
    private String branchName;
    Manager manager;
    ArrayList<User> users;

    private int idCurrentBranch;


   public Branch(String branchName, Manager manager){
       this.idCurrentBranch = idBranch;
       idBranch++;
       this.branchName = branchName;
       this.manager = manager;
       users = new ArrayList<>();
   }
    public String getBranchName() {
        return branchName;
    }
    public int getIdCurrentBranch(){
        return idCurrentBranch;
    }
    public void addCustomer(User user){
        if(customersCounter < MAX_CUSTOMERS){
            customersCounter++;
            users.add(user);
            }else {
            System.out.println("Customer count is exceeded!");
        }
    }

    public void deleteCustomer(User user){
        customersCounter--;
        for(int i = 0; i < user.accounts.size(); i++){
            this.manager.deleteAccount(user, i);
        }
    }

//    public void closeAccount(User user, int idAccount){
//        manager.deleteAccount(user, idAccount);
//    }
}
