package assembly.mips.simulator.hardware;

import java.util.ArrayList;

import assembly.mips.simulator.code.Label;


public class LabelRegisters 
{
	
	private static ArrayList<Label> labelRegisters = new ArrayList<>();
	
	public static void add( Label label )
	{
		
		labelRegisters.add( label );
		
	}
	
	public static Label get( int position )
	{
		
		return labelRegisters.get( position );
		
	}
	
	public static int size()
	{
		
		return labelRegisters.size();
		
	}
	
	public static int getLabelInstructionLine( String labelName )
	{
		
		for( int i = 0; i < labelRegisters.size(); i++ )
			if( labelRegisters.get( i ).getLabel().toLowerCase().equals( labelName ) )
				return labelRegisters.get( i ).getFirstInstructionLine();

		System.out.println( "NÃO ACHOU " + labelName );
		return -1;	
		
	}
	
	public static void showAllLabelsRegisters()
	{
		
		System.err.println( "<<##############################>>" );
		System.err.println( "LABELS: \n" );
		
		for( int i = 0; i < labelRegisters.size(); i++ )
			System.err.println( "SEQUENCE " + i + ": " + labelRegisters.get( i ).getLabel() + " - INSTRUCTION LINE " + labelRegisters.get( i ).getFirstInstructionLine() );
	
		System.err.println( "" );
		
	}
	
}