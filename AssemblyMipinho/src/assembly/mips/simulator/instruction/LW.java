package assembly.mips.simulator.instruction;

import assembly.mips.simulator.code.Data;
import assembly.mips.simulator.hardware.DataRegisters;
import assembly.mips.simulator.hardware.Registers;

class LW
{
	
	private String instructionType = InstructionHandler.LW;
	private String firstParamPosition, secondParamPosition, thirdParamValue;
	private final int PARAMS_AMOUNT = 3;
	
	protected boolean execute( String params ) 
	{
		
		if( validateParams( params ) )
		{

			Data data = DataRegisters.getDataByCrazyFuckingAddress( Registers.getValueByName( thirdParamValue ) );

			int value = 0;

			int bytePosition = Integer.valueOf( secondParamPosition ) + ( Registers.getValueByName( thirdParamValue ) - data.getAddress() ) ;
			
			value = data.getValueAtByte( bytePosition );
			
			Registers.setValueByName( firstParamPosition, value );

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