package coreJava;

public class MailClient {

    Email email = null;
    EmailServer emailServer = null;
    
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    public void sendEmail_3() {
	emailServer.sendMail_3(email);
    }

    public EmailServer getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(EmailServer emailServer) {
        this.emailServer = emailServer;
    }

    public void sendEmail(String address, String title, String body) {
	Email email = new Email(address, title, body);
	EmailServer.sendEmail(email);
    }
    
    public void sendEmail_2(String address, String title, String body) {
	Email email = getEmail_2(address, title, body);
	sendMail_2(email);
    }

    void sendMail_2(Email email) {
	EmailServer.sendEmail(email);
    }
    
    Email getEmail_2(String address, String title, String body)
    {
	Email email = new Email(address, title, body);
	return email;
    }

}
