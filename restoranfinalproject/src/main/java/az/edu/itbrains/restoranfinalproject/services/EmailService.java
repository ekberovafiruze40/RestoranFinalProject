package az.edu.itbrains.restoranfinalproject.services;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
