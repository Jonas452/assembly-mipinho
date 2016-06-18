package assembly.mips.simulator.code;

import java.util.HashMap;
import assembly.mips.simulator.hardware.DataRegisters;

public class Data 
{

	private String label;
	private String type;
	private String array;
	private int address;
	private HashMap< Integer, Integer> values = new HashMap<>();
	
	public Data( String label, String type, String array )
	{
		
		this.label = label.replace( ":", "" );
		this.type = type.replace( ".", "" );
		this.array = array + ',';
		this.address = DataRegisters.getNextDataAddressEmpty();
		
		treatArray();
		
	}

	private void treatArray()
	{
		
		int byteValue = 0;
		String tempValue = "";
		
		for( int i = 0; i < array.length(); i++ )
		{
			
			if( array.charAt( i ) != ',' )
			{
				
				tempValue += array.charAt( i );
				
			}else
			{

				values.put( byteValue, Integer.valueOf( tempValue ) );
				
				byteValue += 4;
				tempValue = "";
				DataRegisters.incrementAddress();
				
			}
			
		}
		
	}
	
	private void treatArrayNoAddresIncrement()
	{
		
		int byteValue = 0;
		String tempValue = "";
		
		
		
		for( int i = 0; i < array.length(); i++ )
		{
			
			if( array.charAt( i ) != ',' )
			{
				
				tempValue += array.charAt( i );
				
			}else
			{

				values.put( byteValue, Integer.valueOf( tempValue ) );
				
				byteValue += 4;
				tempValue = "";
				
			}
			
		}
		
	}

	public void showAllData()
	{

		System.err.println( "- " + label +  ": ." + type );
		System.err.println();
		
		for( int i = 0; i < ( values.size() * 4 ); i += 4 )
			System.err.println( "Value (+" + i + "): " + values.get( i ) );
		
		System.err.println();

	}
	
	public int size()
	{
		
		return values.size() * 4;
		
	}
	
	public String getLabel() { return label; }
	public String getType() { return type; }
	public String getValue() { return array; }
	public int getAddress() { return address; }
	
	public int getValueAtByte( int byteValue ) { return values.get( byteValue ); }
	public void setValueAtByte( int byteValue, int value ) { values.put( byteValue, value );  }
	
	public void setArray( String array )
	{
		
		this.array = array;
		treatArrayNoAddresIncrement();
		
	}
	
	public String getValuesAtByteToByte( int start, int end )
	{
		
		String bytesArray = "";
		
		for( int i = start; i < end; i += 4 )
		{
			
			bytesArray += values.get( i );
			
			if( i != end - 4 )
				bytesArray += ",";
			
		}
				
		return bytesArray;
		
	}
	
}