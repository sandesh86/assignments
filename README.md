# assignments
assignments

Steps to launch the application.

1. Copy repository URL and use this to import this project in eclipse.
2. Chose 'main' branch
3. Import notification project as Maven project in eclipse
4. Service is developed in Java 1.8 version.
5. Update maven project to resolve all the dependencies
6. Run NotificationApplication.java as Java Application, it will launch Spring Boot application in embbeded tomcat server


Steps to Test the application

1. You can use any API testing tool like SOAPUI or Postman to test the service
2. In resources/application.properties below entries are there for SMTP server configuration
  spring.mail.host=127.0.0.1
  spring.mail.port=25
  You can update it as per your configuration. For developing this application I have used Papercut dummy SMTP server in my local.
  
4. Testing URL would be http://localhost:8080/notification/message
5. Request method would be "POST"
6. Input body will be having input like below
  {
    "subject": "Test Mail", 
    "from": "Sandesh@hot.com", 
    "to": "Ghadle@hot.com", 
    "message": "How are you?", 
    "channel": "email"
  }
6. 'channel' can either be "email" or "sms". For any other input it will fail for now.
6. Negative schenarios are not handled as of now. but Junits are written for positive schenarios.
7. Message delivery can be varified either in dummy SMTP server or if its not dummy then can be checked in receiver email
8. Provision to have multiple channel is there in application with very minimal changes. As of now implemented for Email and mocking SMS.
