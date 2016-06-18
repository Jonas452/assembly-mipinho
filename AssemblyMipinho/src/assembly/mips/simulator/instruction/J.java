package assembly.mips.simulator.instruction;

import assembly.mips.simulator.hardware.LabelRegisters;
import assembly.mips.simulator.interpreter.MipinhoInterpreter;

class J
{
	
	private String instructionType = InstructionHandler.BNE;
	private final int PARAMS_AMOUNT = 1;
	
	private String firstParamPosition;

	protected boolean execute( String params )
	{
		
		if( validateParams( params ) )
		{

			int instructionLine = LabelRegisters.getLabelInstructionLine( firstParamPosition );
			
			if( instructionLine != -1 )
			{

				MipinhoInterpreter.interpretingLine = instructionLine - 1;

				System.out.println( "=> JUMPED to LABEL (" + firstParamPosition + ":).\n" );

			}else
			{
				
				System.out.println(  "=> WONT JUMP. \n" );
				
			}
			
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
			
			firstParamPosition = paramsTreated[0];
			
			return true;
			
		}
			
		paramsTreater.printError();

		return false;	
		
	}

}