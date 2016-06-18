package assembly.mips.simulator.address;

import java.util.HashMap;

public class IPHandler 
{
	
	public static final int PORT = 1234;

	@SuppressWarnings("serial")
	private static final HashMap< Integer, String > ADDRESSES = new HashMap< Integer, String >()
	{

		{
	    
	    	put( 0, "10.7.12.199" ); //PEDRO
	    	//put( 0, "10.37.129.2" ); //ESCRAVO 1
	    	//put( 2, "10.0.0.4" ); //ESCRAVO 2
	    	//put( 3, "10.0.0.5" ); //ESCRAVO 3
	    	//put( 4, "10.0.0.6" ); //ESCRAVO 4
	    	//put( 5, "10.0.0.7" ); //ESCRAVO 5
	    	
	    	//put( 0, "10.7.12.145" ); //MESTRE - ANDRE
	        
	    }
	    
	};
	
	public static String getIPAddressById( int id )
	{
		
		return ADDRESSES.get( id );
		
	}
	
}