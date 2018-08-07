package deliverybuddy.models.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @NotEmpty
    /*TODO Size constraints*/
    private String fullName;

    @NotNull
    @NotEmpty
    /*TODO password constraints*/
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public UserDto() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPasswordRegistrationMatch();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPasswordRegistrationMatch();
    }

    private void checkPasswordRegistrationMatch() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }


}
