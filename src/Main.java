import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by R2 on 21.07.2015.
 */
public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("KazanBankNumberOne");

        Info firstCustomer = new Info("FirstCustomer");
        Info secondCustomer = new Info("SecondCustomer");
        Info thirdCustomer = new Info("Mila", "Martin", "Brown", "10.04.1990", "f", "13691369");

        Manager firstManager = new Manager("Oleg Ivanov");
        Manager secondManager = new Manager("Mark Evan");

        Branch firstBranch = new Branch("FirstBranch", firstManager);
        Branch secondBranch = new Branch("SecondBranch", secondManager);

        User firstUser = new User(firstCustomer, "1234", firstBranch.getIdCurrentBranch());
        User secondUser = new User(secondCustomer, "2468", firstBranch.getIdCurrentBranch());
        User thirdUser = new User(thirdCustomer, "0000", secondBranch.getIdCurrentBranch());

        Account firstUserFirstAccount = new Account(TypeOfAccount.BUSINESS);
        Account secondUserFirstAccount = new Account(TypeOfAccount.SAVING);
        Account thirdUserFirstAccount = new Account(TypeOfAccount.CHEQUING);
        thirdUserFirstAccount.changeType(TypeOfAccount.BUSINESS);


        firstBranch.addCustomer(firstUser);
        firstBranch.addCustomer(secondUser);

        secondBranch.addCustomer(thirdUser);

        bank.createBranch(firstBranch);
        bank.createBranch(secondBranch);

        //*********************************************************************
        //all transaction here:



        firstUser.openAccount(firstUserFirstAccount);
        secondUser.openAccount(secondUserFirstAccount);
        thirdUser.openAccount(new Account(TypeOfAccount.CHEQUING));

        System.out.println("secondUser.completeTransaction(TypeOfTransaction.WITHDRAW, null, 997777779, 0, 0);");
        secondUser.completeTransaction(TypeOfTransaction.WITHDRAW, null, 997777779, 0, 0);
        System.out.println("firstUser.completeTransaction(TypeOfTransaction.DEPOSIT, null, 400000000, 0, 0);");
        firstUser.completeTransaction(TypeOfTransaction.DEPOSIT, null, 400000000, 0, 0);
        System.out.println("firstUser.completeTransaction(TypeOfTransaction.WITHDRAW, null, 30000, 0, 0);");
        firstUser.completeTransaction(TypeOfTransaction.WITHDRAW, null, 30000, 0, 0);
        System.out.println("firstUserFirstAccount.monthlyPercent();");
        firstUserFirstAccount.monthlyPercent();
        System.out.println("Balance after percent is " + firstUserFirstAccount.getBalance());
        System.out.println("firstUser.completeTransaction(TypeOfTransaction.TRANSFER, secondUser, 77777, 0, 0);");
        firstUser.completeTransaction(TypeOfTransaction.TRANSFER, secondUser, 77777, 0, 0);

        System.out.println(" thirdUser.completeTransaction(TypeOfTransaction.DEPOSIT, null, 600099, 0, 0);");
        thirdUser.completeTransaction(TypeOfTransaction.DEPOSIT, null, 600099, 0, 0);
       // System.out.println("");
    //    thirdUser.changeAccount(1, TypeOfAccount.SAVING);

        System.out.println("firstUser.completeTransaction(TypeOfTransaction.TRANSFER, thirdUser, 2000, 0, 0);");
        firstUser.completeTransaction(TypeOfTransaction.TRANSFER, thirdUser, 2000, 0, 0);



        try {
            write(bank.report());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("writing is failed!");
        }

    }

    static void write(String text) throws IOException {
        File file = new File("report.txt");

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.append(text);
        fileWriter.flush();;
        System.out.println("Fail was created");
    }



}
