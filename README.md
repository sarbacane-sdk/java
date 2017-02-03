### Sarbacane SDK JAVA - Send e-mail and text messages (sms)


* Load artefact by pom.xml
* Sources
* Authentication
* Send E-mail
* Send SMS
* Webhooks

#### pom.xml

```
<dependency>
  <groupId>com.sarbacane</groupId>
  <artifactId>sarbacane-sdk</artifactId>
  <version>1.0.1</version>
</dependency>
```


#### Sources

```
git clone https://github.com/sarbacane-sdk/java.git .
```

#### Authentication

###### E-mail

```
AuthenticationManager.setEmailTokens("31649838f306ebc8sca6b67be8cd7e20", "3413e65fbef014493537e77f811ca5ca");
```

###### SMS

```
AuthenticationManager.setApiKey("da3f2a93592ad9f43fb38977e8f64d76");
```