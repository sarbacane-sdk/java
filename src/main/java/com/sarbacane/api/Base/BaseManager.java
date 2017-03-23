package com.sarbacane.api.Base;


import com.sarbacane.api.Authentication.AuthenticationManager;
import com.sarbacane.api.Messages.SBEmailMessage;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class BaseManager {

    private static final String propertiesFileName = "sdk.properties";
    private static Properties props = new Properties();

    static {
        try {
            props.load(BaseManager.class.getClassLoader().getResourceAsStream(propertiesFileName));

        } catch (Exception e) {
            throw new RuntimeException("Error loading configuration: " + e, e);
        }
    }


    protected static final String smsUrl = props.getProperty("smsUrl");
    protected static final String smtpHost = props.getProperty("smtpHost");
    protected static final Integer smtpPort = Integer.parseInt(props.getProperty("smtpPort"));
    protected static final Integer smtpConnectionTimeout = Integer.parseInt(props.getProperty("smtpConnectionTimeout"));
    protected static final String smtpStartTlsEnable = props.getProperty("smtpStartTlsEnable");
    protected static final String smtpAuthEnable = props.getProperty("smtpAuthEnable");
    protected static final String smtpDefaultHtmlEncoding = props.getProperty("smtpDefaultHtmlEncoding");
    protected static final String smtpDefaultTextEncoding = props.getProperty("smtpDefaultTextEncoding");
    protected static final String sdkHeader = props.getProperty("sdkHeader");
    protected static final String sdkVersion = props.getProperty("sdkVersion");
    private static SMTPTransport smtpTransport;
    private static Session session;

    private static Properties internalProps = new Properties();


    protected static String sendTransport(SBEmailMessage email) throws MessagingException {
        try {
            internalProps.put("mail.smtp.host", smtpHost);
            internalProps.put("mail.smtp.starttls.enable", smtpStartTlsEnable);
            internalProps.put("mail.smtp.auth", smtpAuthEnable);
            internalProps.put("mail.smtp.socketFactory.port", String.valueOf(smtpPort));
            internalProps.put("mail.smtp.port", String.valueOf(smtpPort));
            internalProps.put("mail.smtp.connectiontimeout", smtpConnectionTimeout);
            session = Session.getInstance(internalProps);
            smtpTransport = (SMTPTransport) session.getTransport("smtp");
            smtpTransport.connect(smtpHost, smtpPort, AuthenticationManager.getEmailUser(), AuthenticationManager.getEmailApikey());
            Message msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            msg.setHeader(sdkHeader, sdkVersion);
            msg.setFrom(new InternetAddress(email.getMailFrom()));
            msg.setSubject(email.getSubject());

            InternetAddress[] address = new InternetAddress[email.getRecipients().size()];
            int counter = 0;
            for (String recipient : email.getRecipients()) {
                address[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            msg.setRecipients(Message.RecipientType.TO, address);

            final MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(email.getTextBody(), smtpDefaultTextEncoding);
            final MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(email.getHtmlBody(), smtpDefaultHtmlEncoding);
            final Multipart mp = new MimeMultipart("alternative");
            mp.addBodyPart(textPart);
            mp.addBodyPart(htmlPart);
            msg.setContent(mp);
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
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("X-Primotexto-ApiKey", AuthenticationManager.getSmsApikey());
            conn.setRequestProperty(sdkHeader, sdkVersion);
            conn.setRequestMethod(method);
            return conn;
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        throw new RuntimeException("Failed create an API KEY connection.");
    }


    protected static String httpGet(String url) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource.header("X-Primotexto-ApiKey", AuthenticationManager.getSmsApikey())
                    .header(sdkHeader,sdkVersion)
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            String output = response.getEntity(String.class);
            return output;
        } catch (Exception e) {
            return e.toString();
        }
    }

    protected static String httpPost(String url, String args) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource.header("Content-Type", "application/json;charset=UTF-8")
                    .header(sdkHeader,sdkVersion)
                    .header("X-Primotexto-ApiKey", AuthenticationManager.getSmsApikey())
                    .post(ClientResponse.class, args);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);
            return output;

        } catch (Exception e) {

            return e.toString();

        }

    }

    protected static String httpPostH(String url, String args) throws IOException {


        HttpURLConnection conn = httpWithTokens(url, "POST");
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(args.getBytes("UTF-8"));
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
        try {

            Client client = Client.create();

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource.header("Content-Type", "application/json;charset=UTF-8")
                    .header("X-Primotexto-ApiKey", AuthenticationManager.getSmsApikey())
                    .header(sdkHeader,sdkVersion)
                    .put(ClientResponse.class, args);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);
            return output;

        } catch (Exception e) {

            return e.toString();

        }
    }

    protected static String httpDelete(String url) throws IOException {

        try {

            Client client = Client.create();

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource.header("X-Primotexto-ApiKey", AuthenticationManager.getSmsApikey())
                    .header(sdkHeader,sdkVersion)
                    .delete(ClientResponse.class);

            if ((response.getStatus() != 200) || (response.getStatus() != 204)) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            String output = response.getEntity(String.class);
            return output;
        } catch (Exception e) {
            return e.toString();
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