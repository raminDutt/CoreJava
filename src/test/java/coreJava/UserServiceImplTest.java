package coreJava;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSettingPassword() {
	UserDAO userDAO = mock(UserDAO.class);
	SecurityService securityService = mock(SecurityService.class);
	User  user = mock(User.class);
	
	String password = "changeMe";
	String passwordMd5 = "4097eee67e358755862c14d03df009cd";
	when(user.getPassword()).thenReturn(password);
	when(securityService.md5(password)).thenReturn(passwordMd5);
	UserServiceImpl userServiceImpl = new UserServiceImpl(userDAO, securityService);
	
	try {
	    userServiceImpl.assignPassword(user);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	verify(user).getPassword();
	verify(securityService).md5(password);
	verify(user).setPassword(passwordMd5);
	verify(userDAO).updateUser(user);
	
    }
    
    

}
