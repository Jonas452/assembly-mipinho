package assembly.mips.simulator.instruction;

import assembly.mips.simulator.hardware.Registers;

class PRINT 
{

	private String instructionType = InstructionHandler.PRINT;
	
	private String paramPositionToPrint;
	private final int PARAMS_AMOUNT = 1;
	
	protected boolean execute( String params ) 
	{
		
		if( validateParams( params ) )
		{

			System.err.println( "=> " + paramPositionToPrint + " = " + Registers.getValueByName( paramPositionToPrint ) + "\n" );
			return true;
			
		}
		
		return false;
		
	}

	protected boolean validateParams( String params ) 
	{
		
		ParamHandler paramsTreater = new ParamHandler( instructionType, params, PARAMS_AMOUNT );

		String[] paramsTreated = paramsTreater.treate();
		
		if( paramsTreated != null )
		{
			
			paramPositionToPrint = paramsTreated[0];
			
			return true;
			
		}
			
		paramsTreater.printError();

		return false;	
	
	}

}