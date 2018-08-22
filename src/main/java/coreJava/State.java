package coreJava;

public class State {
    public enum Case {PROCESSING, OK, CANCELLED, ERROR};
    private String currentState = null;
    
    public State(Case currentState)
    {
	this.currentState= currentState.toString();
    }
    

    

}
