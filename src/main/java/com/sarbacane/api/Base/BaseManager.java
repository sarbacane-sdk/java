package com.sarbacane.api.Base;


import com.sarbacane.api.Authentication.AuthenticationManager;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * Created by guru on 07/11/14.
 */
public class BaseManager {
    protected static String baseURL = "https://api.primotexto.com/v2";



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
                    conn.setRequestProperty("X-Primotexto-ApiKey", AuthenticationManager.getApiKey());
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
                //System.out.println(line);
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
                //System.out.println(line);
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
                //System.out.println(line);
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
                //System.out.println(line);
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
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//
//            String line;
//            StringBuilder result = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                result.append(line);
//                //System.out.println(line);
//            }
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
                //System.out.println(line);
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
                //System.out.println(line);
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
                //System.out.println(line);
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

//    public static String readFile(String path, Charset encoding)  throws IOException {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded, encoding);
//    }
}