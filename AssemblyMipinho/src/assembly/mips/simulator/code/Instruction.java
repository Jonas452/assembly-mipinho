package assembly.mips.simulator.code;

public class Instruction 
{
	
	private String instruction;
	private String params;
	
	public Instruction( String instruction, String params )
	{
		
		this.instruction = instruction;
		this.params = params;
		
	}

	public String getInstruction() { return instruction; }
	public String getParams() { return params; }

}