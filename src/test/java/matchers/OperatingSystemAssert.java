package matchers;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import coreJava.OperatingSystem;

public class OperatingSystemAssert extends
	AbstractAssert<OperatingSystemAssert, OperatingSystem> {

    public OperatingSystemAssert(OperatingSystem actual) {
	super(actual, OperatingSystemAssert.class);

    }

    public static OperatingSystemAssert assertThat(
	    OperatingSystem operatingSystem) {
	return new OperatingSystemAssert(operatingSystem);
    }

    public OperatingSystemAssert is128bit() {
	isNotNull();
	String errorMessage = "Expected bits for operating system (<%s>) to be 128 bits but was <%s>";
	Assertions.assertThat(actual.getNbOfBits())
		.overridingErrorMessage(errorMessage, actual.getName(), actual.getNbOfBits())
		.isEqualTo(128);
	return this;
    }
    
    public OperatingSystemAssert is64bit() {
	isNotNull();
	String errorMessage = "Expected bits for operating system (<%s>) to be 64 bits but was <%s>";
	Assertions.assertThat(actual.getNbOfBits())
		.overridingErrorMessage(errorMessage, actual.getName(), actual.getNbOfBits())
		.isEqualTo(64);
	return this;
    }

    public OperatingSystemAssert wasReleasedIn(int expectedReleaseYear) {

	isNotNull();
	String errorMessage = "Expected Release for the operating system (<%s>) to be <%s> but was <%s>";
	Assertions
		.assertThat(actual.getReleaseYear())
		.overridingErrorMessage(errorMessage, actual.getName(),
			expectedReleaseYear,actual.getReleaseYear())
		.isEqualTo(expectedReleaseYear);
	return this;
    }

    public OperatingSystemAssert hasVersion(String expectedVersion) {

	isNotNull();
	String errorMessage = "Expected Version for the operating system (<%s>) was to be <%s> but was <%s>";
	Assertions
		.assertThat(actual.getVersion())
		.overridingErrorMessage(errorMessage, actual.getName(),
			expectedVersion, actual.getVersion()).isEqualTo(expectedVersion);
	return this;
    }
}
