### Sarbacane SDK JAVA - Send e-mail and text messages (sms)


* Load artefact with pom.xml
* Sources
* Authentication
* Buy credits
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
AuthenticationManager.setSmsApikey("da3f2a93592ad9f43fb38977e8f64d76");
```


#### Buy credits

Email credits: https://fr.tipimail.com/tarifs
SMS credits: https://www.primotexto.com/tarif-sms-web.asp


#### Send E-mail

```
    SBEmail email = new SBEmail();
    email.setMailFrom("sender@domain.com");
    email.setSubject("Message sent by Sarbacane SDK");
    email.setMessage("Here is the content of the message");
    email.setRecipients(
            Arrays.asList(
                "address1@domain.com",
                "address2@domain.com"
            )
    );
    MessagesManager.sendEmail(email);
```


#### Send SMS

```
    SBSms msg = new SBSms();
    msg.setType("notification");
    msg.setNumber("+33600000000");
    msg.setMessage("Confirmation code is: 283951");
    msg.setSender("SBSMS");
    msg.setCategory("confirmationCode");
    msg.setCampaignName("Authentication confirmation code");
    MessagesManager.sendSms(msg);
```

