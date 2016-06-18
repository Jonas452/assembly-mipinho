package assembly.mips.simulator.instruction;

import assembly.mips.simulator.address.IPHandler;
import assembly.mips.simulator.code.Data;
import assembly.mips.simulator.hardware.DataRegisters;
import assembly.mips.simulator.hardware.Registers;
import assembly.mips.simulator.socket.MipinhoSocket;

//import assembly.mips.simulator.hardware.Registers;

class RCV
{
	
	private String instructionType = InstructionHandler.RCV;
	private final int PARAMS_AMOUNT = 3;
	
	private String firstParamPosition, secondParamPosition, thirdParamPosition;

	protected boolean execute( String params )
	{
		
		if( validateParams( params ) )
		{
			
			int ipId = Registers.getValueByName( firstParamPosition );

			Data dataSegment = DataRegisters.getDataByCrazyFuckingAddress( Registers.getValueByName( thirdParamPosition ) );
			
			String ipAddress = IPHandler.getIPAddressById( ipId );
			
			String byteValues =  MipinhoSocket.recive( ipAddress );
			if( byteValues != null )
			{
			
			    dataSegment.setArray( byteValues );
			
				System.err.println( 
						"Recived to " + firstParamPosition + "(" + ipAddress + ") " +
						"Bytes " + secondParamPosition +
						" Stored at " + thirdParamPosition + "(" + dataSegment.getAddress() + ") equals to " + byteValues + ".\n" );

				
			}else
			{
				
				System.err.println( "ERROR WHILE TRYING TO SEND TO " + ipAddress + ".\n" );
				return false;
				
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