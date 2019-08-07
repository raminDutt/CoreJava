package coreJava;

public enum Week {

    INSTANCE {
	public String getNmame() {
	    return "overriding";
	}
    },
    MON("M");

    private Week(String value) {
	name = value;
    }

    private Week() {
	name = "Monday";
    }

    String name;

    public String getNmame() {
	return name;
    }
}
