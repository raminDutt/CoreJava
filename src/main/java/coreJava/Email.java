package coreJava;

public class Email {

    String address;
    String title;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    private void setBody(String body) {
        this.body = body;
    }

    String body;
    
    public Email(String address, String title, String body) {
	this.address=address;
	this.title=title;
	this.body=body;

    }


}
