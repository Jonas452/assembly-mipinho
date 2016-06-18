package assembly.mips.simulator.instruction;

import assembly.mips.simulator.hardware.Registers;

class LI 
{
	
	private String instructionType = InstructionHandler.LI;
	private final int PARAMS_AMOUNT = 3;
	
	private String firstParamPosition, secondParamPosition;

	protected boolean execute( String params )
	{
		
		if( validateParams( params ) )
		{

			int valueToSet = Integer.valueOf( secondParamPosition );
			
			Registers.setValueByName( firstParamPosition, valueToSet );
			
			new PRINT().execute( firstParamPosition );
			
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
			
			return true;
			
		}
			
		paramsTreater.printError();

		return false;	
		
	}

}