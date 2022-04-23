package by.it.academy.MK_JD2_90_22.taskAPI.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private final String login;
    private final String password;
    private final String lastName;
    private String firstName;
    private LocalDate dateOfBirthday;
    private final LocalDateTime dateOfRegistration;
    private Role role;


    public User(String login, String password, String lastName,String firstName, String dateOfBirthday) {
        this.login = login;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        if (!Objects.equals(dateOfBirthday, "")){
            this.dateOfBirthday = LocalDate.parse(dateOfBirthday);
        }
        this.dateOfRegistration = LocalDateTime.now();
        this.role = Role.USER;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

