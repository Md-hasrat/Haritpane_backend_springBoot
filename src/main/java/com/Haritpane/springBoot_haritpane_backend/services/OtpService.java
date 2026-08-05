package com.Haritpane.springBoot_haritpane_backend.services;

import com.Haritpane.springBoot_haritpane_backend.entity.providerEntity.ServiceProviderEntity;
import com.Haritpane.springBoot_haritpane_backend.repository.ServiceProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final SendEmailService sendEmailService;

    private static final SecureRandom random = new SecureRandom();

    public String generateOtp() {
        return String.format("%06d", random.nextInt(1000000));
    }

    public void sendOtpEmail(String email, String otp) {

        String html = """
                <html>
                <body>
                    <h2>HaritPane Verification</h2>

                    <p>Your OTP is:</p>

                    <h1>%s</h1>

                    <p>Valid for 5 minutes.</p>

                </body>
                </html>
                """.formatted(otp);

        sendEmailService.sendHtmlEmail(
                email,
                "HaritPane OTP Verification",
                html
        );
    }
}
