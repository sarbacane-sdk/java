package com.sarbacane.api.Base;


import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Messages.SBEmailMessage;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class BaseManager {
    private static final String TYPE = "text/html; charset=utf-8";
    protected static String baseURL = "https://api.primotexto.com/v2";
    protected static String smtpHost = "smtp.tipimail.com";
    protected static Integer smtpPort = 587;
    private static Properties props = new Properties();

    private static SMTPTransport smtpTransport;
    private static Session session;


    protected static String sendTransport(SBEmailMessage email) throws MessagingException {
        try {
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", String.valueOf(smtpPort));
            props.put("mail.smtp.port", String.valueOf(smtpPort));
            props.put("mail.smtp.connectiontimeout", 60000);
            session = Session.getInstance(props);
            smtpTransport = (SMTPTransport) session.getTransport("smtp");
            smtpTransport.connect(smtpHost, smtpPort, AuthenticationManager.getEmailUser(), AuthenticationManager.getEmailApikey());
            Message msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            msg.setContent("", TYPE);
            msg.setHeader("X-Sarbacane-SDK-Java", "1.0.5");
            msg.setFrom(new InternetAddress(email.getMailFrom()));
            msg.setSubject(email.getSubject());

            InternetAddress[] address = new InternetAddress[email.getRecipients().size()];
            int counter = 0;
            for (String recipient : email.getRecipients()) {
                address[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            msg.setRecipients(Message.RecipientType.TO, address);

            msg.setText(email.getTextBody());
            msg.setContent(email.getHtmlBody(), "text/html; charset=utf-8");
            System.out.println("message: " + email.getHtmlBody());
            smtpTransport.sendMessage(msg, msg.getAllRecipients());
            smtpTransport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return smtpTransport.getLastServerResponse();
    }

    private static HttpURLConnection httpWithTokens(String url, String method) {
        try {
            Properties systemSettings = System.getProperties();
            URL to = new URL(url);

            if (isSet(AuthenticationManager.getProxyHost()) && isSet(AuthenticationManager.getProxyPort().toString()) && isSet(AuthenticationManager.getProxyUsername()) && isSet(AuthenticationManager.getProxyPassword())) {

                systemSettings.put("proxySet", "true");
                systemSettings.put("https.proxyHost", AuthenticationManager.getProxyHost());
                systemSettings.put("https.proxyPort", AuthenticationManager.getProxyPort().toString());
                systemSettings.put("https.proxyUser", AuthenticationManager.getProxyUsername());
                systemSettings.put("https.proxyPassword", AuthenticationManager.getProxyPassword());
            } else if (isSet(AuthenticationManager.getProxyHost()) && isSet(AuthenticationManager.getProxyPort().toString()) && !isSet(AuthenticationManager.getProxyUsername()) && !isSet(AuthenticationManager.getProxyPassword())) {
                systemSettings.put("https.proxySet", "true");
                systemSettings.put("https.proxyHost", AuthenticationManager.getProxyHost());
                systemSettings.put("https.proxyPort", AuthenticationManager.getProxyPort().toString());
            }
            HttpURLConnection conn = (HttpURLConnection) to.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("X-Primotexto-ApiKey", AuthenticationManager.getSmsApikey());
            conn.setRequestMethod(method);
            return conn;
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        throw new RuntimeException("Failed create an API KEY connection.");
    }


    protected static String httpGet(String url) throws IOException {

        HttpURLConnection conn = httpWithTokens(url, "GET");
        if (conn.getResponseCode() != 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getErrorStream())));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode()
                    + "\nReason:"
                    + result.toString());
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            return result.toString();
        }
    }

    protected static String httpPost(String url, String args) throws IOException {


        HttpURLConnection conn = httpWithTokens(url, "POST");
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(args.getBytes());
        os.flush();

        if (conn.getResponseCode() != 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getErrorStream())));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode()
                    + "\nReason:"
                    + result.toString());
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            return result.toString();
        }
    }

    protected static String httpPostH(String url, String args) throws IOException {


        HttpURLConnection conn = httpWithTokens(url, "POST");
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(args.getBytes());
        os.flush();

        if (conn.getResponseCode() != 201) {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getErrorStream())));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);
                //System.out.println(line);
            }
            conn.disconnect();
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode()
                    + "\nReason:"
                    + result.toString());
        } else {

            String header = conn.getHeaderField("Location");
            conn.disconnect();
            return header.toString();
        }
    }


    protected static String httpPut(String url, String args) throws IOException {
        HttpURLConnection conn = httpWithTokens(url, "PUT");
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(args.getBytes());
        os.flush();
        if (conn.getResponseCode() != 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getErrorStream())));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode()
                    + "\nReason:"
                    + result.toString());
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            return result.toString();
        }
    }

    protected static String httpDelete(String url) throws IOException {

        HttpURLConnection conn = httpWithTokens(url, "DELETE");

        if (conn.getResponseCode() != 204) {

            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode()
                    + "\nReason:"
                    + conn.getResponseMessage());
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);

            }
            conn.disconnect();
            return result.toString();
        }
    }

    public static boolean isSet(String args) {
        return args != null && args.length() > 0;
    }

    public static String getDate(Long ts) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(ts);
    }

    public static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

}