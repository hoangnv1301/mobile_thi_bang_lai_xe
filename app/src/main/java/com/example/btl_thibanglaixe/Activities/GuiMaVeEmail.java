package com.example.btl_thibanglaixe.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;

public class GuiMaVeEmail extends AsyncTask<String, Void, Integer> {

    private Context context;

    public GuiMaVeEmail(Context context) {
        this.context = context;
    }

    @Override
    protected Integer doInBackground(String... params) {
       // System.out.println(params[0]);
        // Sender's email address and password
        String senderEmail = "tam210402@gmail.com";
        String senderPassword = "iizv mclf mkkc vqit";

        // Recipient's email address
        String EmailNguoiNhan = params[0];

        // SMTP server configuration
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587; // SMTP port (e.g., 587 for TLS)

        // Create properties for the SMTP connection
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the SMTP server
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(EmailNguoiNhan));


            Random random = new Random();

            // Generate a random integer
            int min = 100000;
            int max = 999999;
            int randomNumber = random.nextInt(max - min) + min;

            String content = "Mã xác nhận của bạn là: " + Integer.toString(randomNumber);

            // Set the subject and content of the email
            message.setSubject("Mã xác nhận");
            message.setText(content);

            // Send the email
            Transport.send(message);


            return randomNumber;
        } catch (MessagingException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        // Handle the result of email sending (e.g., show a toast or update UI)
        if (result != null) {
            Toast.makeText(context, "Mã xác nhận đã được gửi về email của bạn! Vui lòng kiểm tra tin nhắn", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, NhapMaXacNhan.class);
            intent.putExtra("RANDOM_NUMBER", result);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Lỗi gửi tin nhắn", Toast.LENGTH_SHORT).show();
        }
    }
}