package coreJava;

public class Country extends City<Country>{
    
    
    public class Space extends City<Country>
    {
	//VALID
    }
    
    public class Space2 extends City<Space2>
    {
	//VALID
    }
    
    public class Space3 extends City<Space2>
    {
	//VALID
    }
    
/*    public class Space4 extends City<Space3>
    {
	//INVALID
    }
    
    public class Space5 extends City<Integer>
    {
	//INVALID
    }*/
    
    public class Region extends Country
    {
	//IRRELEVANT
    }
    
    public void f()
    {

    }
    
    

}
