package coreJava;

import static org.junit.Assert.*;

import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(JUnitParamsRunner.class)
public class UserListTest {

    @Before
    public void setUp() throws Exception {
    }

    private static final Object[] parametersForTestAddUser() {
	return new Object[] {
		new Object[] { new User[] { Mockito.mock(User.class) } },
		new Object[] { new User[] {
			Mockito.mock(User.class),
			Mockito.mock(User.class) } },
		new Object[] { new User[] { null } },
		new Object[] { new User[] { Mockito.mock(User.class), null } } };
    }

    @Test
    @Parameters
    public void testAddUser(User[] users) {

	UserList userList = new UserList();
	Assertions.assertThat(userList.getUsers()).isEmpty();
	for (User user : users) {
	    userList.addUser(user);
	}

	List<User> list = userList.getUsers();
	Assertions.assertThat(list).contains(users);
    }
    
    private static final Object[] parametersForTestAddUser2() {
	return new Object[] {
		new Object[] { Mockito.mock(User.class), true },
		new Object[] { Mockito.mock(User.class), false },
		new Object[] { Mockito.mock(User.class), false }};
    }

    @Test
    @Parameters
    public void testAddUser2(User user, boolean expectedResult) {

	System.out.println(user + " :" + expectedResult);
    }

}
