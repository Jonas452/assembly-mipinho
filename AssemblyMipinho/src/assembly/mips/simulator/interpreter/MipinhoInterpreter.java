package assembly.mips.simulator.interpreter;

import java.util.Scanner;
import assembly.mips.simulator.code.Instruction;
import assembly.mips.simulator.code.MipinhoReader;
import assembly.mips.simulator.hardware.DataRegisters;
import assembly.mips.simulator.hardware.InstructionRegisters;
import assembly.mips.simulator.hardware.LabelRegisters;
import assembly.mips.simulator.hardware.Registers;
import assembly.mips.simulator.instruction.InstructionHandler;

public class MipinhoInterpreter 
{
	
	private static final String FILE_ASM = "res/escravo.asm";
	
	public static int interpretingLine;

	public static void main( String[] args)
	{

		System.err.println();
		System.err.println( "    #        #       #    ######  #    #     #   #    #   #######" );
		System.err.println( "   #  #     # #      #    #    #  #    # #   #   #    #   #     #" );
		System.err.println( "  #    #   #   #     #    ######  #    #   # #   ######   #     #" );
		System.err.println( " #      # #     #    #    #       #    #    ##   #    #   #     #" );
		System.err.println( "#        #       #   #    #       #    #     #   #    #   #######" );
		
		System.err.println();
		System.err.println( "<<##############################>>" );
		System.err.println();
		MipinhoReader.startReading( FILE_ASM );
		System.err.println();
		System.err.println( DataRegisters.size() + " variable(s) red." );
		System.err.println( LabelRegisters.size() + " Label(s) to be executed.");
		System.err.println( InstructionRegisters.size() + " Instruction(s) to be executed." );
		System.err.println();
		System.err.println( "Executing..." );
		System.err.println();
		System.err.println( "<<##############################>>" );
		
		System.err.println();

		Scanner scanner = new Scanner(System.in);
		
		for( interpretingLine = 0; interpretingLine < InstructionRegisters.size(); interpretingLine++ )
		{
		
			System.err.println( "EXECUTING LINE " + interpretingLine + ":\n" );
			
			Instruction instruction = InstructionRegisters.get( interpretingLine );
			InstructionHandler.execute( instruction.getInstruction(), instruction.getParams() );
			
			System.err.println( "-----------------------------------------------" );
			
			//String pauser = scanner.nextLine();
			
		}
		
		System.err.println( "Execution ended." );
		System.err.println( "<<##############################>>" );
		
		//-----------------------------------------------------------------------
		System.err.println( "Do you want to see all the registers?(Y/N)" );
		
		
		String answer = scanner.nextLine();
		
		if( answer.toUpperCase().equals( "Y" ) )
		{
			
			DataRegisters.showAllDatasRegisters();
			LabelRegisters.showAllLabelsRegisters();
			InstructionRegisters.showAllInstructionsRegisters();
			Registers.showAllRegisters();
		
		}
		
		scanner.close();
		//-----------------------------------------------------------------------
		
	}

}