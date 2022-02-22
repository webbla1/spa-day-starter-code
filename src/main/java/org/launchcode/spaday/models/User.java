package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message="Username cannot be empty")
    @NotBlank(message="Username cannot be empty")
    @Size(min=5, max=15, message="Username must be 5-15 characters")
    private String username;

    @Email(message = "Please enter a valid email")
    private String email;


    @NotNull(message="Password cannot be empty")
    @NotBlank(message="Password cannot be empty")
    @Size(min=6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message="Passwords do not match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword(this.password, this.getVerifyPassword());
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(this.getPassword(), this.verifyPassword);
    }

    public void checkPassword(String password, String verifyPassword) {
        if(password != null && verifyPassword != null) {
            if(!(password.equals(verifyPassword))) {
                this.setVerifyPassword(null);
            }
        }
    }
}
