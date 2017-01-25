package com.sarbacane.api.Authentication;


import static com.sarbacane.api.Base.BaseManager.isSet;

/**
 * Created by guru on 07/11/14.
 */


public class AuthenticationManager {



    private static String apiKey;

    public static String getApiKey() {
        return apiKey;
    }


    public static void setApiKey(String apiKey) {
        if (isSet(apiKey) && (apiKey.length()==32)) {
            AuthenticationManager.apiKey = apiKey;
        } else {
            throw new RuntimeException("Incorrect (or null?) API Key !");
        }
    }




    private static boolean credentialsAreSet() {
        return isSet(apiKey);
    }

    private static boolean userIsLoggedIn() {
        return (isSet(getApiKey()));
    }

    public static void ensureLogin() {
        if (!AuthenticationManager.credentialsAreSet()) {
            throw new RuntimeException("API Key is not defined !");
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
