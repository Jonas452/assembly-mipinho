package assembly.mips.simulator.instruction;

import assembly.mips.simulator.hardware.Registers;

class ADDI
{

	private String instructionType = InstructionHandler.ADDI;
	private String firstParamPosition, secondParamPosition, thirdParamValue;
	private final int PARAMS_AMOUNT = 3;
	
	protected boolean execute( String params ) 
	{
		
		if( validateParams( params ) )
		{
			
			int result = Registers.getValueByName( secondParamPosition ) + Integer.valueOf( thirdParamValue );
			
			Registers.setValueByName( firstParamPosition, result );
			
			new PRINT().execute( firstParamPosition );
			
			return true;
			
		}
		
		return false;
		
	}

	protected boolean validateParams(String params) 
	{
		
		ParamHandler paramsTreater = new ParamHandler( instructionType, params, PARAMS_AMOUNT );
		
		String[] paramsTreated = paramsTreater.treate();
			
		if( paramsTreated != null )
		{
				
			firstParamPosition = paramsTreated[0];
			secondParamPosition = paramsTreated[1];
			thirdParamValue = paramsTreated[2];
				
			return true;
				
		}
				
		paramsTreater.printError();

		return false;		
		
	}

}