![alt tag](https://cloud.githubusercontent.com/assets/18444530/23370454/08b3a170-fd15-11e6-946c-ecc2db251ad7.png)
### Sarbacane SDK JAVA - Send e-mail and text messages (sms)

* Account & API Key
* Load artefact from pom.xml
* Download JAR
* Download sources
* Authentication
* Buy credits
* Send E-mail
* Send SMS
* Webhooks

#### Account & API Key

##### E-mail

[Create E-mail account](https://www.tipimail.com/register)


[Generate your E-mail Tokens (be logged in first)](https://app.tipimail.com/#/app/settings/smtp_and_apis)

![email tokens](https://cloud.githubusercontent.com/assets/18444530/23396595/dd275f1c-fd94-11e6-8b92-1f3c3a707ddc.jpg)



##### SMS

[Create SMS account](https://www.primotexto.com/creer_compte.asp)


[Generate your SMS API Key (be logged in first)](https://www.primotexto.com/webapp/#/developer/keys)

![api_key_real](https://cloud.githubusercontent.com/assets/18444530/23396617/f0e0f996-fd94-11e6-9440-cb41f54c5a4b.png)




#### pom.xml

```
<dependency>
  <groupId>com.sarbacane</groupId>
  <artifactId>sarbacane-sdk</artifactId>
  <version>1.0.6</version>
</dependency>
```


#### JAR

[Download](https://oss.sonatype.org/service/local/repositories/releases/content/com/sarbacane/sarbacane-sdk/1.0.6/sarbacane-sdk-1.0.6.jar)


#### Sources

```
git clone https://github.com/sarbacane-sdk/java.git .
```


#### Authentication

###### E-mail

```
AuthenticationManager.setEmailTokens('MY_EMAIL_USERNAME', 'MY_EMAIL_APIKEY');
```


###### SMS

```
AuthenticationManager.setSmsApikey('MY_SMS_APIKEY');
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

