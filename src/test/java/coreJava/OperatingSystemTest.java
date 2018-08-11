package coreJava;

import static matchers.OperatingSystemAssert.assertThat;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

public class OperatingSystemTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
	OperatingSystem operatingSystem = new OperatingSystem();
	operatingSystem.setName("Windows");
	operatingSystem.setNbOfBits(128);
	operatingSystem.setReleaseYear(2018);
	operatingSystem.setVersion("1803");
	assertThat(operatingSystem).is128bit().wasReleasedIn(2018).hasVersion("1803");
	assertThat(operatingSystem).is64bit();

	
    }

}
