package assembly.mips.simulator.hardware;

class Register 
{
	
	protected String name;
	protected int number;
	protected int value;
	
	protected Register( String name, int number )
	{
		
		this.name = name;
		this.number = number;
		this.value = 0;
		
	}

}