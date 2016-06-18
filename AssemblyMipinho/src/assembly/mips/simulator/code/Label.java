package assembly.mips.simulator.code;

public class Label
{
	
	private String label;
	private int firstInstructionLine;
	
	public Label( String label, int nextLine )
	{
		
		this.label = label.replace( ":", "" );
		this.firstInstructionLine = nextLine;
		
	}

	public String getLabel() { return label; }
	public int getFirstInstructionLine() { return firstInstructionLine; }
	
}