package assembly.mips.simulator.instruction;

import assembly.mips.simulator.hardware.LabelRegisters;
import assembly.mips.simulator.hardware.Registers;
import assembly.mips.simulator.interpreter.MipinhoInterpreter;

class BNE 
{
	
	private String instructionType = InstructionHandler.BNE;
	private final int PARAMS_AMOUNT = 3;
	
	private String firstParamPosition, secondParamPosition, thirdParamPosition;

	protected boolean execute( String params )
	{
		
		if( validateParams( params ) )
		{

			int firstValue = Registers.getValueByName( firstParamPosition );
			int secondValue = Registers.getValueByName( secondParamPosition );
			
			
			if( firstValue != secondValue )
			{

				int instructionLine = LabelRegisters.getLabelInstructionLine( thirdParamPosition );
				
				if( instructionLine - 1 > 0 )
				{
					
					MipinhoInterpreter.interpretingLine = instructionLine - 1;
					System.err.println( "=> JUMPED to LABEL(" + thirdParamPosition + ":) with next instruction line (" + instructionLine + ").\n" );
					
				}

			}else
			{
				
				System.err.println(  "=> WONT JUMP. \n" );
				
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
			secondParamPosition = paramsTreated[1];
			thirdParamPosition = paramsTreated[2];
			
			return true;
			
		}
			
		paramsTreater.printError();

		return false;	
		
	}

}