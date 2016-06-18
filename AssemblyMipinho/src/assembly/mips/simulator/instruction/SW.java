package assembly.mips.simulator.instruction;

import assembly.mips.simulator.code.Data;
import assembly.mips.simulator.hardware.DataRegisters;
import assembly.mips.simulator.hardware.Registers;

class SW
{
	
	private String instructionType = InstructionHandler.SW;
	private String firstParamPosition, secondParamPosition, thirdParamValue;
	private final int PARAMS_AMOUNT = 3;
	
	protected boolean execute( String params ) 
	{
		
		if( validateParams( params ) )
		{
			
			int address = Registers.getValueByName( thirdParamValue );
			
			
			Data tempData = DataRegisters.getDataByCrazyFuckingAddress( address );
			int byteValue = Integer.parseInt( secondParamPosition ) + ( address - tempData.getAddress() );
			int value = Registers.getValueByName( firstParamPosition );
			
			DataRegisters.getDataByCrazyFuckingAddress( address ).setValueAtByte( byteValue, value );

			System.err.print( "=> Value from " + firstParamPosition + "(" + value + ") set at " + address + " in Value (+" + byteValue + ")\n\n" );
			
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