![alt tag](https://cloud.githubusercontent.com/assets/18444530/22825087/81a050e8-ef8b-11e6-8b33-2508b9be27a8.png)
### Sarbacane SDK JAVA - Send e-mail and text messages (sms)


* Load artefact from pom.xml
* Download JAR
* Download sources
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
  <version>1.0.4</version>
</dependency>
```


#### JAR

[Download](https://oss.sonatype.org/service/local/repositories/releases/content/com/sarbacane/sarbacane-sdk/1.0.3/sarbacane-sdk-1.0.3.jar)


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


#### Credits

[Buy E-mail credits](https://fr.tipimail.com/tarifs) 

[Buy SMS credits](https://www.primotexto.com/tarif-sms-web.asp)


#### Send E-mail

```
    SBEmailMessage email = new SBEmailMessage();
    email.setMailFrom("sender@domain.com");
    email.setMailFromName("Sender Name");
    email.setSubject("Message sent by Sarbacane SDK JAVA");
    email.setHtmlBody("Here is the <b>HTML</b> content of the message.");
    email.setTextBody("Here is the content of the message");
    email.setRecipients(
            Arrays.asList(
                "address1@domain.com",
                "address2@domain.com"
            )
    );
    MessagesManager.sendEmailMessage(email);
```


#### Send SMS

```
    SBSmsMessage msg = new SBSmsMessage();
    msg.setType("notification");
    msg.setNumber("+33600000000");
    msg.setMessage("Confirmation code is: 283951");
    msg.setSender("SBSMS");
    msg.setCategory("confirmationCode");
    msg.setCampaignName("Authentication confirmation code");
    MessagesManager.sendSmsMessage(msg);
```

