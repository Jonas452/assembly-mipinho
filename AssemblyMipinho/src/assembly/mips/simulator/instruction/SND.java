package assembly.mips.simulator.instruction;

import assembly.mips.simulator.address.IPHandler;
import assembly.mips.simulator.code.Data;
import assembly.mips.simulator.hardware.DataRegisters;
import assembly.mips.simulator.hardware.Registers;
import assembly.mips.simulator.socket.MipinhoSocket;

class SND
{

	private String instructionType = InstructionHandler.SND;
	private final int PARAMS_AMOUNT = 3;
	
	private String firstParamPosition, secondParamPosition, thirdParamPosition;

	protected boolean execute( String params )
	{
		
		if( validateParams( params ) )
		{
			
			Data dataSegment = DataRegisters.getDataByAddress( Registers.getValueByName( thirdParamPosition ) );
			
			int ipId = Registers.getValueByName( firstParamPosition );
			
			int bitPositionStart = 0;
			int bitPositionEnd = 0;
			
			int numberOfBytes = Integer.parseInt( secondParamPosition );
			
			if( numberOfBytes != dataSegment.size() )
			{
				
				bitPositionStart = ipId * numberOfBytes;
				bitPositionEnd = bitPositionStart + numberOfBytes;
				
			}else if( numberOfBytes == dataSegment.size())
			{
				
				bitPositionStart = 0;
				bitPositionEnd = numberOfBytes;
				
			}
			
			String dataToSend = dataSegment.getValuesAtByteToByte( bitPositionStart, bitPositionEnd );
			
			String ipAddress = IPHandler.getIPAddressById( ipId );

			if( MipinhoSocket.send( ipAddress, dataToSend ) )
			{
			
				System.err.println( 
						"Sended to " + firstParamPosition + "(" + ipAddress + ") " +
						"Bytes " + secondParamPosition +
						" Stored at " + thirdParamPosition + "(" + dataSegment.getAddress() + ") equals to " + dataToSend + ".\n" );

				
			}else
			{
				
				System.err.println( "ERROR WHILE TRYING TO SEND TO " + ipAddress + ".\n" );
				return false;
				
			}

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