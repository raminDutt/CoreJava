package coreJava;

public abstract class AbstractFactory<A extends AbstractFactory<A>> {
	public abstract A getFactory();
}
