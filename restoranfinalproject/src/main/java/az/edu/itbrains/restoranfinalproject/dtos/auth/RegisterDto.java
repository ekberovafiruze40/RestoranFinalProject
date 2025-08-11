package az.edu.itbrains.restoranfinalproject.dtos.auth;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotEmpty(message = "First name cannot be empty.")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty.")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters.")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty.")
    @Email(message = "Enter a valid email address.")
    private String email;

    @NotEmpty(message = "Password cannot be empty.")
    @Pattern(
            regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})",
            message = "Password must be at least 8 characters long, and contain a digit, lowercase, uppercase, and special character."
    )
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty.")
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match.")
    public boolean isPasswordsMatching() {
        return password != null && password.equals(confirmPassword);
    }
}