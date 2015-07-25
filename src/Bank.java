import java.util.ArrayList;

/**
 * Created by R2 on 23.07.2015.
 */

public class Bank {
    private static final int MAX_BRANCHES = 5;
    private static int branchCounter;
    ArrayList<Branch> branches;
    ArrayList<Transaction> transactions;
    String bankName;

    Bank(String bankName){
        branches = new ArrayList<>();
        this.bankName = bankName;
    }

    public void createBranch(Branch branch){
        if (branchCounter < MAX_BRANCHES){
            branchCounter++;
            branches.add(branch);
        }else {
            System.out.println("Branch count is exceeded!");
        }
    }


    public String report(){
        String text = "";
        text = "=========================\n Bank: " + bankName + "\n\n";
        for (int i = 0; i < branches.size(); i++){
            text += "**********************\n branch " + i + ": " +
                                branches.get(i).getBranchName() +
                                "  manager is " + branches.get(i).manager.getManagerName() + "\n";
            for (int j = 0; j < branches.get(i).users.size(); j++){
                text+= "______________________________________\n"
                        + "Customer " + j + ": " + branches.get(i).users.get(j).getInfo() + "\n";

                text+=branches.get(i).users.get(j).transactionInfo();
            }
        }
        text += "\n++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        text += "+All TRANSACTION OF BANK:                        +\n";

        int transactionCounter = 0;
        for (int i = 0; i < branches.size(); i++){
            text += "----------------" + "\nBranch: " + branches.get(i).getIdCurrentBranch()
            + "\n";
            for (int j = 0; j < branches.get(i).users.size(); j++){

                text+=branches.get(i).users.get(j).transactionInfo();
//                for(int k = 0; k < branches.get(i).users.get(j).transactions.size(); k++){
//
//                    text += "+Transaction " + transactionCounter;
//                    transactionCounter++;
//                }

            }
        }
        return text;
    }
}
