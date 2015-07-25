/**
 * Created by R2 on 22.07.2015.
 */
public class Info {
    private String firstName;
    private String lastName;
    private String patronym;
    private String dateOfBirth;
    private String sex;
    private String passport;

    Info(){
       this("","","","","","");
    }

    Info(String firstName){
        this(firstName, " ", " ", " ", " ", " ");
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param patronym
     * @param dateOfBirth
     * @param sex
     * @param passport
     */
    Info(String firstName, String lastName, String patronym, String dateOfBirth, String sex, String passport){

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronym = patronym;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.passport = passport;
    }

    public String showInfo(){
        //TODO add all info
        return "firstName: " + firstName + ", "
                +"passport: " + passport +". ";
    }

    public void changeInfo(){

    }
}
