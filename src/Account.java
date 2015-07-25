import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * Created by R2 on 22.07.2015.
 */
public class Account {
    private static final int MAX_TRANSACTION_PER_MONTH = 100;

    private static int idAccount = 1;
    private long coins;
    TypeOfAccount typeOfAccount;
    private int currentIdAccount;

    Account(TypeOfAccount typeOfAccount){
        idAccount++;
        this.typeOfAccount = typeOfAccount;
        this.currentIdAccount = idAccount;
    }

    public int getCurrentIdAccount() {
        return currentIdAccount;
    }

    void deposit(){
        long balance = enter();
        deposit(balance);
    }

    boolean deposit(long balance){
        boolean flag = false;
        if(isGreaterThanZero(balance) && isGreaterThanZero(this.coins)){
            if((this.coins + balance) < 0) {
                System.out.println("You can not save so big summ");
            }else {
                this.coins += balance;
                flag = true;
                System.out.println("You call function \"deposit\"."
                        + " Your balance is " + this.getBalance()
                );
            }
        }
        return flag;
    }

    void withdraw() {
        long balance = enter();
        withdraw(balance);
    }

    boolean withdraw(long balance){
        boolean flag = false;
        if ( isGreaterThanZero(balance) && isGreaterThanZero(this.coins)){

            if (this.coins > balance){
                this.coins -= balance;

                flag = true;
            }else{
                System.out.println("your entered number is greater than balance");
            }
            System.out.println("You call function \"withdraw\"."
                    + "Your balance is " + this.getBalance());
        }
        return flag;
    }

    long monthlyPercent(long percent){
        return this.coins += this.coins*percent/100;
    }

    long monthlyPercent(){
        long percent = 0;
        if(this.typeOfAccount == TypeOfAccount.BUSINESS){
            percent = 7;
        }
        if(this.typeOfAccount == TypeOfAccount.SAVING){
            percent = 5;
        }
        if(this.typeOfAccount == TypeOfAccount.CHEQUING){
            percent = 4;
        }
        return monthlyPercent(percent);
    }

    double dailyPecent(){
        return this.coins += monthlyPercent()/30;
    }

    static long enter(){
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();

        long correctNumberCoins = 0;

        try{
            correctNumberCoins = Long.parseLong(st);
        }catch(NumberFormatException e){
            System.out.println("It is not number");
        }

        if(!isGreaterThanZero(correctNumberCoins)){
            return -1;
        }

        return correctNumberCoins;
    }

    static boolean isGreaterThanZero(long balance){
        if(balance < 0){
            System.out.println("Your number is less than 0");
            return false;
        }
        return true;
    }

    public String getBalance() {
        long dollars = (coins/100);
        long excessCoins = (coins - dollars*100);
        return dollars  + " dollars. " + excessCoins + " coins";
    }

    public long getCoins(){
        return coins;
    }

    public void changeType(TypeOfAccount typeOfAccount){
        if(getCoins() > enoughMoneyToType()){
            System.out.println("Type changed from " + this.typeOfAccount + " to " + typeOfAccount);
            this.typeOfAccount = typeOfAccount;
        }else {
            System.out.println("You don not have enough money to change!");
        }
    }


    private long enoughMoneyToType(){
        long money = 0;

        if(typeOfAccount == TypeOfAccount.BUSINESS){
           money = 5000000;
        }
        if (typeOfAccount == TypeOfAccount.SAVING){
            money = 5000;
        }
        if (typeOfAccount == TypeOfAccount.CHEQUING){
            money = 1000;
        }
        return money;
    }

}
