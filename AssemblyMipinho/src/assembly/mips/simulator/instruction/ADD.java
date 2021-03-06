package assembly.mips.simulator.instruction;

import assembly.mips.simulator.hardware.Registers;

class ADD
{
	
	private String instructionType = InstructionHandler.ADD;
	private final int PARAMS_AMOUNT = 3;
	
	private String firstParamPosition, secondParamPosition, thirdParamPosition;

	protected boolean execute( String params )
	{
		
		if( validateParams( params ) )
		{

			int result = Registers.getValueByName( secondParamPosition ) + Registers.getValueByName( thirdParamPosition );
			
			Registers.setValueByName( firstParamPosition, result );
			
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
			thirdParamPosition = paramsTreated[2];
			
			return true;
			
		}
			
		paramsTreater.printError();

		return false;	
		
	}
	
}