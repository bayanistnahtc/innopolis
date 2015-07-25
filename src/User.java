import java.util.ArrayList;
/**
 * Created by R2 on 22.07.2015.
 */
public class User {
    private static int ID = 1;
    private Info info;
    private String password;
    private int currentIdUser;
    private int idBranch;

    ArrayList<Account> accounts;
    private ArrayList<String> transactions;

    User(Info userInfo, String password, int idBranch){
        info = userInfo;
        this.password = password;
        this.currentIdUser = ID;
        this.idBranch = idBranch;
        ID++;
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }
    public int getIdBranch(){
        return idBranch;
    }

    public String getInfo(){
        return info.showInfo();
    }

    public int getNumberOfTransaction(){
        return transactions.size();
    }

    /**
     *
     * @param typeOfTransaction : TypeOfTransaction
     * @param receiveUser : User
     * @param money : long
     * @param idAccount : int
     * @param idAccountReceiver : int
     *                          we can send money from different users' accounts so we should point which
     *                          is type of transaction, which User receive money and which their accounts
     *                          used
     */
    void completeTransaction(TypeOfTransaction typeOfTransaction, User receiveUser, long money, int idAccount,
                             int idAccountReceiver){


        if(TypeOfTransaction.TRANSFER == typeOfTransaction){

            transactions.add("TRANSFER from branch " + this.idBranch + " to " + receiveUser.idBranch +
                                "\n" +  Transaction.completeTransaction(typeOfTransaction, accounts.get(idAccount),
                                     receiveUser.accounts.get(idAccountReceiver), money));
            this.completeTransaction(TypeOfTransaction.WITHDRAW, null, money, idAccount, idAccount);
            receiveUser.completeTransaction(TypeOfTransaction.DEPOSIT, null, money, idAccountReceiver, idAccountReceiver);

        }else {
            transactions.add(Transaction.completeTransaction(typeOfTransaction, accounts.get(idAccount),
                            accounts.get(idAccount), money));
        }
    }

    void openAccount(Account account){
        accounts.add(account);
    }

    void closeAccount(int idAccount){
       // Manager.deleteAccount(this, idAccount);
    }

    public String transactionInfo(){
        String text = "";
        for(int i = 0; i < transactions.size(); i++){
            text+=transactions.get(i);
        }
        return text;
    }

    public void changeAccount(int idAccount, TypeOfAccount typeOfAccount){
       for (int i = 0; i < accounts.size(); i++){
           if(accounts.get(i).getCurrentIdAccount() == idAccount){
               accounts.get(i).changeType(typeOfAccount);
           }
       }
    }
}


