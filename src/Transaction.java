/**
 * Created by R2 on 22.07.2015.
 */
public class Transaction {

    private static int idTransaction;
    private Account userAccount;
    private Account receiveAccount;
    private TypeOfTransaction typeOfTransaction;

    private int currentIdTransaction;

    Transaction transaction;


    Transaction(TypeOfTransaction typeOfTransaction, Account userAccount, Account receiveAccount){
        idTransaction++;
        this.userAccount = userAccount;
        this.receiveAccount = receiveAccount;
        this.typeOfTransaction = typeOfTransaction;

        this.currentIdTransaction = idTransaction;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public Account getReceiveAccount() {
        return receiveAccount;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public int getCurrentIdTransaction() {
        return currentIdTransaction;
    }

    public static String completeTransaction(TypeOfTransaction typeOfTransaction, Account userAccount,
                                              Account receiveAccount, long money){
        String text = "";
        Transaction transaction = new Transaction(typeOfTransaction, userAccount, receiveAccount);
        boolean flag = false;

        switch (typeOfTransaction){
            case DEPOSIT:
                flag = userAccount.deposit(money);
                break;
            case WITHDRAW:
                flag = userAccount.withdraw(money);
                break;
            case TRANSFER:
                if (userAccount.withdraw(money)){
                    if(receiveAccount.deposit(money)){
                        flag = true;
                    }else {
                        userAccount.deposit(money);
                    }
                }
                break;
            default:
                break;
        }

        text += "Transaction " + transaction.showTransactionInfo() +  "status: ";

        if(flag){
                text += "complete";
        }else {
            text += "fail";
        }

        return text + "\n ~~~~~~~~~~~~~~~~~~~~~~~ \n";
    }


    public String showTransactionInfo(){
        return "idTransaction: " + currentIdTransaction + ", " +
                "idUserAccount: " + userAccount.getCurrentIdAccount() + ", " +
                "idReceiveAccount: " + receiveAccount.getCurrentIdAccount() + ", "+
                "TypeOfTransaction: " + typeOfTransaction + ".\n";

    }

    public void changeAccountType(User user, int idAccount, TypeOfAccount typeOfAccount){
        /**
         * user
         * users Account id
         * to changing Type pf account
         */
        user.changeAccount(idAccount, typeOfAccount);

    }
}
