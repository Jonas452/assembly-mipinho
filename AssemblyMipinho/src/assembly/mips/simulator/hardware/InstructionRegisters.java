package assembly.mips.simulator.hardware;

import java.util.ArrayList;

import assembly.mips.simulator.code.Instruction;

public class InstructionRegisters 
{

	private static ArrayList<Instruction> instructionRegisters = new ArrayList<>();
	
	public static void add( Instruction instruction )
	{
		
		instructionRegisters.add( instruction );
		
	}
	
	public static Instruction get( int position )
	{
		
		return instructionRegisters.get( position );
		
	}
	
	public static int getLastInstructionPosition()
	{
		
		return instructionRegisters.size();
		
	}
	
	public static int size()
	{
		
		return instructionRegisters.size();
		
	}
	
	public static void showAllInstructionsRegisters()
	{
		
		System.err.println( "<<##############################>>" );
		System.err.println( "INSTRUCTIONS: \n" );
		
		for( int i = 0; i < instructionRegisters.size(); i++ )
			System.err.println( "LINE " + i + ": " + instructionRegisters.get( i ).getInstruction() + " " + instructionRegisters.get( i ).getParams() );
		
		System.err.println( "" );
		
	}
	
}