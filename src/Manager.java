/**
 * Created by R2 on 23.07.2015.
 */
public class Manager {
    private static int idManager;
    private Info info;

    Manager(String name){
        idManager++;
        info = new Info(name);
    }
    public void deleteAccount(User user, int idAccount){
        for (int i = user.accounts.size(); i >= 0; i--){
            if(user.accounts.get(i).getCurrentIdAccount() == idAccount){
                if (user.accounts.get(i).getCoins() > 0)
                user.accounts.remove(user.accounts.get(i));
            }
        }

    }

    public int getIdManager(){
        return idManager;
    }

    public String getManagerName(){
      return "Manager: " +  this.info.showInfo();
    }
}
