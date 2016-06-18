package assembly.mips.simulator.hardware;

import java.util.ArrayList;
import assembly.mips.simulator.code.Data;

public class DataRegisters
{

	private static ArrayList<Data> dataRegisters = new ArrayList<>();
	private static int nextDataAddressEmpty = 268500992;
	
	public static void add( Data data )
	{
		
		dataRegisters.add( data );
		
	}
	
	public static void incrementAddress()
	{

		nextDataAddressEmpty += 4;
		
	}
	
	public static Data get( int position )
	{
		
		return dataRegisters.get( position );
		
	}
	
	public static int getNextDataAddressEmpty()
	{
		
		return nextDataAddressEmpty;
		
	}
	
	public static Data getDataByLabel( String label )
	{
		
		for( int i = 0; i < dataRegisters.size(); i++ )
			if( dataRegisters.get( i ).getLabel().toLowerCase().equals( label ) )
				return dataRegisters.get( i );
		
		return null;
		
	}
	
	public static Data getDataByAddress( int address )
	{
		
		for( int i = 0; i < dataRegisters.size(); i++ )
			if( dataRegisters.get( i ).getAddress() == address )
				return dataRegisters.get( i );
		
		return null;
		
	}
	
	public static Data getDataByCrazyFuckingAddress( int address) 
	{
		
		for( int i = dataRegisters.size() - 1; i >= 0; i-- )
			if( dataRegisters.get( i ).getAddress() <= address )
				return dataRegisters.get( i );
		
		return null;
		
	}
	
	public static int size()
	{
		
		return dataRegisters.size();
		
	}
	
	public static void showAllDatasRegisters()
	{
		
		System.err.println( "<<##############################>>" );
		System.err.println( "DATAS: \n" );
		
		for( int i = 0; i < dataRegisters.size(); i++ )
			dataRegisters.get( i ).showAllData();
	
		System.err.println( "" );
		
	}
	
}