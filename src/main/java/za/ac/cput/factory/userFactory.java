package za.ac.cput.factory;
/*
 * Mogamad Taariq Phillips - 220166153
 * userFactory.java
 * Creation of factory for user
 *
 */
import za.ac.cput.domain.user;
import za.ac.cput.util.Helper;

public class userFactory {
    public static user createUser(String emailAddress, String Password, String passwordConfirmation, int grade, String userType)
    {

        if (Helper.isEmpty(emailAddress) || Helper.isEmpty(Password) || Helper.isEmpty(passwordConfirmation) || Helper.isEmpty(passwordConfirmation) || Helper.isEmpty(userType)) {
            return null;
        }

        if(!Helper.isValidEmail(emailAddress)){
            return null;
        }

        return new user
                .Builder()
                .emailAddress(emailAddress)
                .Password(Password)
                .passwordConfirmation(passwordConfirmation)
                .grade(grade)
                .userType(userType)
                .build();
    }
}
