package assembly.mips.simulator.instruction;

public class InstructionHandler 
{

	public static final String ADD = "ADD";
	public static final String ADDI = "ADDI";
	public static final String SUB = "SUB";
	public static final String MULT = "MULT";
	public static final String MULI = "MULI";
	public static final String LW = "LW";
	public static final String SW = "SW";
	public static final String LI = "LI";
	public static final String LA = "LA";
	public static final String BNE = "BNE";
	public static final String SND = "SND";
	public static final String RCV = "RCV";
	public static final String J = "J";
	public static final String BEQ =  "BEQ";
	public static final String PRINT = "PRINT";

	public static final String[] allInstruction = 
	{
		ADD,
		ADDI,
		SUB,
		MULT,
		MULI,
		LW,
		SW,
		LI,
		LA,
		BNE,
		SND,
		RCV,
		J,
		BEQ,
		PRINT
	};
	
	public static String validate( String instruction )
	{

		instruction = instruction.toUpperCase();
		
		for( int i = 0; i < allInstruction.length; i ++ )
		{
			
			if( instruction.equals( allInstruction[i] ) )
				return allInstruction[i];
			
		}
		
		return null;
		
	}
	
	public static boolean execute( String instruction, String params )
	{

		instruction = instruction.toUpperCase();
		
		if( validate( instruction ) != null )
		{

			System.err.println( instruction + " " + params + "\n" );
			
			switch( instruction ) 
			{
				
				case LI:
					return new LI().execute( params );
					
				case ADD:
					return new ADD().execute( params );

				case ADDI:
					return new ADDI().execute( params );
					
				case SUB:
					return new SUB().execute( params );
				
				case MULT:
					return new MULT().execute( params );
					
				case MULI:
					return new MULI().execute( params );
					
				case LW:
					return new LW().execute( params );
					
				case SW:
					return new SW().execute( params );
					
				case BNE:
					return new BNE().execute( params );
					
				case LA:
					return new LA().execute( params );
					
				case BEQ:
					return new BEQ().execute( params );
					
				case J:
					return new J().execute( params );
					
				case SND:
					return new SND().execute( params );
					
				case RCV:
					return new RCV().execute( params );
					
				case PRINT:
					return new PRINT().execute( params );
					
			}
			
		}
		
		System.err.println( "MIPINHO ERROR: Incorret instruction (" + instruction + ")." );
		return false;
		
	}
	
}