package az.edu.itbrains.restoranfinalproject.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender emailJavaMailSender() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // .env olmasa, app çökməsin
                .load();

        // Əsas dəyişənlərin olub-olmadığını yoxlayırıq
        if (isMissing(dotenv, "MAIL_HOST", "MAIL_PORT", "MAIL_USERNAME", "MAIL_PASSWORD")) {
            throw new IllegalStateException(".env faylında mail üçün tələb olunan dəyişənlər tapılmadı");
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(dotenv.get("MAIL_HOST"));
        mailSender.setPort(getInt(dotenv.get("MAIL_PORT"), 587)); // default port əlavə etdik
        mailSender.setUsername(dotenv.get("MAIL_USERNAME"));
        mailSender.setPassword(dotenv.get("MAIL_PASSWORD"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", getBool(dotenv.get("MAIL_SMTP_AUTH"), true));
        props.put("mail.smtp.starttls.enable", getBool(dotenv.get("MAIL_SMTP_STARTTLS"), true));
        props.put("mail.smtp.ssl.trust", dotenv.get("MAIL_SMTP_SSL_TRUST", "smtp.gmail.com"));
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "false");

        return mailSender;
    }

    private boolean isMissing(Dotenv dotenv, String... keys) {
        for (String key : keys) {
            String value = dotenv.get(key);
            if (value == null || value.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private int getInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private boolean getBool(String value, boolean defaultValue) {
        if (value == null) return defaultValue;
        return Boolean.parseBoolean(value);
    }
}
