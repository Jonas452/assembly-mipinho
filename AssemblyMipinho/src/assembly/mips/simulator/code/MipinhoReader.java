package assembly.mips.simulator.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import assembly.mips.simulator.hardware.DataRegisters;
import assembly.mips.simulator.hardware.InstructionRegisters;
import assembly.mips.simulator.hardware.LabelRegisters;
import assembly.mips.simulator.instruction.InstructionHandler;

public class MipinhoReader
{

	public static boolean startReading( String fileName )
	{
		
		try 
		{
			
			BufferedReader bufferedReader = new BufferedReader( new FileReader( fileName ) );
		    String line = bufferedReader.readLine();

		    while( line != null ) 
		    {
		    	
		    	line = line.trim();
		    	String instructionName = null;
		    	String instructionParams = null;
		    	
		    	if(  line.length() > 0 && line.charAt( 0 ) != '#' )
		    	{
		    		
		    		StringTokenizer lineToken = new StringTokenizer( line );
		            
		    		while( lineToken.hasMoreTokens() ) 
		            {
		    			
		                String tempCodeLine =  lineToken.nextToken();
		                
		                if( tempCodeLine.charAt( tempCodeLine.length() - 1 ) == ':' )
		                {
		                
		                	if( lineToken.hasMoreTokens() )
		                	{
		                		
		                		String label = tempCodeLine;
		                		String type = null;
		                		String value = "";
		                		
		                		while( lineToken.hasMoreTokens() ) 
					            {
					    			
		                			tempCodeLine =  lineToken.nextToken();
		                			
		                			if( tempCodeLine.charAt( 0 ) == '.' )
		                				type = tempCodeLine;
		                			else
		                				value += tempCodeLine;
		                			
					            }

		                		if( label != null && type != null && value != null )
		                			DataRegisters.add( new Data( label, type, value ) );
		                		
		                	}else
		                	{
		                	
		                		LabelRegisters.add( new Label( tempCodeLine, InstructionRegisters.getLastInstructionPosition() ) );
		                	
		                	}
		                	
		                }else if( InstructionHandler.validate( tempCodeLine ) != null )
		                {
		                	
		                	instructionName = tempCodeLine;
		                	instructionParams = "";
		                	
		                	while( lineToken.hasMoreTokens() ) 
				            {
				    			
		                		instructionParams +=  lineToken.nextToken();
				            
				            }
		                	
		                }else
		                {
		                	
		                	System.err.println( "MIPINHO: Error while trying to read ( " + tempCodeLine + " ) instruction." );
		                	break;
		                	
		                }

		            }

		    	}
		    	
		    	if( instructionName != null && instructionParams != null )
		    		InstructionRegisters.add( new Instruction( instructionName, instructionParams ) );

		    	line = bufferedReader.readLine();
		    	
		    }

		    System.err.println( "FILE EXECUTED: " + fileName );
		    
		    bufferedReader.close();
		    return true;
		    
		}catch( IOException e ) 
		{
			
			e.printStackTrace();
			return false;
			
		}
		
	}
	
}