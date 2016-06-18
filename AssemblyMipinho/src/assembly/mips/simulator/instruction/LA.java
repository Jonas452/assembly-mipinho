package assembly.mips.simulator.instruction;

import assembly.mips.simulator.code.Data;
import assembly.mips.simulator.hardware.DataRegisters;

class LA 
{
	
	private String instructionType = InstructionHandler.LA;
	private String firstParamPosition, secondParamPosition;
	private final int PARAMS_AMOUNT = 2;
	
	protected boolean execute( String params ) 
	{
		
		if( validateParams( params ) )
		{
			
			Data data = DataRegisters.getDataByLabel( secondParamPosition );

			new LI().execute( firstParamPosition + "," + data.getAddress()  );

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
				
			return true;
				
		}
				
		paramsTreater.printError();

		return false;	
		
	}

}