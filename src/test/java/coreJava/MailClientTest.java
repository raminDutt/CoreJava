package coreJava;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(value = { EmailServer.class, MailClient.class })
@RunWith(PowerMockRunner.class)
public class MailClientTest {

    @Test
    public void testWithPowerMock() throws Exception {

	String address = null;
	String title = null;
	String body = null;

	Email emailMock = mock(Email.class);
	PowerMockito.whenNew(Email.class).withArguments(address, title, body)
		.thenReturn(emailMock);

	MailClient client = new MailClient();
	PowerMockito.mockStatic(EmailServer.class);
	client.sendEmail(address, title, body);

	PowerMockito.verifyStatic(EmailServer.class);
	EmailServer.sendEmail(emailMock);

    }

    @Test
    public void testCapture() {
	String address = "montreal@hotmail.com";
	String title = "Powermock tutorial";
	String body = "Keep it up";

	MailClient client = new MailClient();
	PowerMockito.mockStatic(EmailServer.class);
	client.sendEmail(address, title, body);

	ArgumentCaptor<Email> argumentCaptor = ArgumentCaptor
		.<Email, Email> forClass(Email.class);

	PowerMockito.verifyStatic(EmailServer.class);
	EmailServer.sendEmail(argumentCaptor.capture());
	Email actual = argumentCaptor.getValue();

	Assertions.assertThat(actual.getAddress()).isEqualTo(address);
	Assertions.assertThat(actual.getTitle()).isEqualTo(title);
	Assertions.assertThat(actual.getBody()).isEqualTo(body);
    }

    @Test
    public void testInteractionWithSubclassAndOveridePattern() {
	Email expectedMail = mock(Email.class);
	class MailClient2 extends MailClient {
	    @Override
	    Email getEmail_2(String address, String title, String body) {
		return expectedMail;
	    }

	    @Override
	    void sendMail_2(Email actual) {
		Assertions.assertThat(actual).isEqualTo(expectedMail);
	    }
	}
	String address = "montreal@hotmail.com";
	String title = "Powermock tutorial";
	String body = "Keep it up";
	MailClient mailClient = new MailClient2();
	mailClient.sendEmail_2(address, title, body);
    }

    @Test
    public void testStateWithSubclassAndOveridePattern() {
	String address = "montreal@hotmail.com";
	String title = "Powermock tutorial";
	String body = "Keep it up";
	class MailClient2 extends MailClient {

	    @Override
	    void sendMail_2(Email actual) {
		Assertions.assertThat(actual.getAddress()).isEqualTo(address);
		Assertions.assertThat(actual.getTitle()).isEqualTo(title);
		Assertions.assertThat(actual.getBody()).isEqualTo(body);
	    }
	}

	MailClient mailClient = new MailClient2();
	mailClient.sendEmail_2(address, title, body);
    }

    @Test
    public void testInteractionWithSpy() {
	String address = "montreal@hotmail.com";
	String title = "Powermock tutorial";
	String body = "Keep it up";
	MailClient client = spy(new MailClient());
	Email expectedMail = mock(Email.class);
	when(client.getEmail_2(anyString(), anyString(), anyString()))
		.thenReturn(expectedMail);
	client.sendEmail_2(address, title, body);
	verify(client).sendMail_2(expectedMail);
    }

    @Test
    public void testRedesign() {
	Email email = mock(Email.class);
	EmailServer emailServer = mock(EmailServer.class);
	MailClient client = new MailClient();
	client.setEmail(email);
	client.setEmailServer(emailServer);
	client.sendEmail_3();
	verify(emailServer).sendMail_3(email);

    }

}
