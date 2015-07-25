package userInterface;

import java.util.Scanner;

/**
 * Created by R2 on 24.07.2015.
 */
public class CustomerInterface {
    static void start(){
   /*     System.out.println("Hello, my diar client, please choose action: " );
        Scanner scanner = new Scanner(System.in);
        String st = "";

        switch (st){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
        }


        if(scanner.hasNextLong())
        {
            summ = Long.parseLong(scanner.next());
            continueFunction(summ);
        }else{

            if (scanner.nextLine().equals("exit")){
                System.out.println("Bye");
            }
        }
*/
    }

  /*  static void continueFunction(long summ){
        ATM resource = new ATM(summ);
        System.out.println("Thank you!");

        while(true){
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("Please choose one what you want:"
                            + "\n\t 1.deposit"
                            + "\n\t 2.withdraw"
                            + "\n\t 3.percent"
                            + "\n\t 4.show balance"
                            + "\n\t 5.exit"
            );
            System.out.println("++++++++++++++++++++++++++++++\n");

            Scanner scanner = new Scanner(System.in);

            String st = scanner.nextLine();
            if(st.equals("exit")){
                break;
            }

            switch (st) {
                case "1":
                    System.out.println("Enter deposit:");
                    resource.deposit();
                    break;
                case "2":
                    System.out.println("Enter withdraw:");
                    resource.withdraw();
                    break;
                case "3":
                    System.out.println("The percent is " + resource.monthlyPercent());
                    break;
                case "4":
                    System.out.println("Your balance is " + resource.toString());
                    break;
                case "5":
                    System.out.println("Thank you! Goodbye");
                    break;
                default:
                    System.out.println("Wrong answer, please again!");
                    break;
            }
        }

    }*/
}
