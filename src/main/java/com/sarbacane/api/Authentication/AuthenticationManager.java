package com.sarbacane.api.Authentication;


import static com.sarbacane.api.Base.BaseManager.isSet;

/**
 * Created by guru on 07/11/14.
 */


public class AuthenticationManager {



    private static String smsApikey;

    public static String getSmsApikey() {
        return smsApikey;
    }

    public static void setSmsApikey(String smsApikey) {
        if (isSet(smsApikey) && (smsApikey.length()==32)) {
            AuthenticationManager.smsApikey = smsApikey;
        } else {
            throw new RuntimeException("Incorrect SMS tokens !");
        }
    }

    private static boolean smsCredentialsAreSet() {
        return isSet(smsApikey);
    }

    //private static boolean userIsLoggedIn() {
    //    return (isSet(getSmsApikey()));
    //}

    public static void ensureSmsTokens() {
        if (!AuthenticationManager.smsCredentialsAreSet()) {
            throw new RuntimeException("Invalid SMS Credentials !");
        }
    }

    private static String emailUser;
    private static String emailApikey;

    public static String getEmailUser() {
        return emailUser;
    }
    public static String getEmailApikey() {
        return emailApikey;
    }

    public static void setEmailTokens(String emailUser, String emailApikey) {
        if (isSet(emailUser) && isSet(emailApikey) && (emailApikey.length()==32)) {
            AuthenticationManager.emailApikey = emailApikey;
            AuthenticationManager.emailUser = emailUser;
        } else {
            throw new RuntimeException("Incorrect Email tokens !");
        }
    }

    private static boolean emailCredentialsAreSet() {
        return isSet(emailUser) && isSet(emailApikey);
    }

    //private static boolean userIsLoggedIn() {
    //    return (isSet(getSmsApikey()));
    //}

    public static void ensureEmailTokens() {
        if (!AuthenticationManager.emailCredentialsAreSet()) {
            throw new RuntimeException("Invalid Email credentials !");
        }
    }


        private static String proxyHost = null;
        private static Integer proxyPort = null;
        private static String proxyUsername = null;
        private static String proxyPassword = null;


        public static String getProxyHost() {
            return proxyHost;
        }

        public static void setProxyHost(String host) {
            proxyHost = host;
        }

        public static Integer getProxyPort() {
            return proxyPort;
        }

        public static void setProxyPort(Integer port) {
            proxyPort = port;
        }

        public static String getProxyUsername() {
            return proxyUsername;
        }

        public static void setProxyUsername(String username) {
            proxyUsername = username;
        }

        public static String getProxyPassword() {
            return proxyPassword;
        }

        public static void setProxyPassword(String password) {
            proxyPassword = password;
        }



    public static void setProxyConfiguration (String host, Integer port, String username, String password) {
        setProxyHost(host);
        setProxyPort(port);
        setProxyUsername(username);
        setProxyPassword(password);
    }

    public static void setProxyConfiguration (String host, Integer port) {
        setProxyHost(host);
        setProxyPort(port);
    }




}
