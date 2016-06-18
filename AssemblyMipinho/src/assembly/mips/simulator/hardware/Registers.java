package assembly.mips.simulator.hardware;

import java.util.HashMap;
import java.util.Map;

public class Registers 
{
	
	private static final String ZERO = "$zero";
	private static final String AT = "$at";
	private static final String V0 = "$v0";
	private static final String V1 = "$v1";
	private static final String A0 = "$a0";
	private static final String A1 = "$a1";
	private static final String A2 = "$a2";
	private static final String A3 = "$a3";
	private static final String T0 = "$t0";
	private static final String T1 = "$t1";
	private static final String T2 = "$t2";
	private static final String T3 = "$t3";
	private static final String T4 = "$t4";
	private static final String T5 = "$t5";
	private static final String T6 = "$t6";
	private static final String T7 = "$t7";
	private static final String S0 = "$s0";
	private static final String S1 = "$s1";
	private static final String S2 = "$s2";
	private static final String S3 = "$s3";
	private static final String S4 = "$s4";
	private static final String S5 = "$s5";
	private static final String S6 = "$s6";
	private static final String S7 = "$s7";
	private static final String T8 = "$t8";
	private static final String T9 = "$t9";
	private static final String K0 = "$k0";
	private static final String K1 = "$k1";
	private static final String GP = "$gp";
	private static final String SP = "$sp";
	private static final String FP = "$fp";
	private static final String RA = "$ra";
	private static final String PC = "pc";
	private static final String HI = "hi";
	private static final String LO = "lo";
	
	private static final String[] registersNames =
	{
		ZERO,
		AT,
		V0,
		V1,
		A0,
		A1,
		A2,
		A3,
		T0,
		T1,
		T2,
		T3,
		T4,
		T5,
		T6,
		T7,
		S0,
		S1,
		S2,
		S3,
		S4,
		S5,
		S6,
		S7,
		T8,
		T9,
		K0,
		K1,
		GP,
		SP,
		FP,
		RA,
		PC,
		HI,
		LO
	};

	@SuppressWarnings("serial")
	private static HashMap< String, Register > registers = new HashMap< String, Register >()
	{

		{
	    	
	    	for( int i = 0; i < registersNames.length; i++ )	
	    		put( registersNames[i], new Register( registersNames[i], i ) );
	        
	    }
	    
	};
	
	//############################################################################
	//Gets Registers
	
	public static int getValueByName( String name )
	{
		
		return registers.get( name ).value;
		
	}
	
	public static int getValueByNumber( int number )
	{
		
		for( Map.Entry<String, Register> entry : registers.entrySet() ) 
		{ 
		
			Register register = (Register) entry.getValue();
		
			if( register.number == number )
				return register.value;

		}
		
		return 0;
		
	}
	
	public static String getNameByNumber( int number )
	{
		
		for( Map.Entry<String, Register> entry : registers.entrySet() ) 
		{ 
		
			Register register = (Register) entry.getValue();
		
			if( register.number == number )
				return register.name;

		}
		
		return "";
		
	}
	
	//############################################################################
	//Set Registers
	
	public static void setValueByName( String name, int value )
	{
		
		Register tempRegister = registers.get( name );
		tempRegister.value = value;
		
		registers.put( name, tempRegister );
		
	}
	
	public static void setValueByNumber( int number, int value )
	{
		
		for( Map.Entry<String, Register> entry : registers.entrySet() ) 
		{ 
		
			Register register = (Register) entry.getValue();
		
			if( register.number == number )
			{
				
				Registers.setValueByName( register.name, value );
				
			}
			
		}
		
	}
	
	//############################################################################
	//Utils Registers
	
	public static void showAllRegisters()
	{
		
		System.err.println( "<<##############################>>" );
		System.err.println( "REGISTERS:" );
		System.err.println( "NAME     NUMBER     VALUE" );
		
		for( Map.Entry<String, Register> entry : registers.entrySet() ) 
		{ 
		
			Register register = (Register) entry.getValue();
		
			System.err.println( register.name + "        " +  register.number + "         " + register.value ); 
			
		}
		
		System.err.println( "<<##############################>>" );
		
	}
	
	public static String showAllRegistersUI()
	{
		
		String text = "";
		
		for( Map.Entry<String, Register> entry : registers.entrySet() ) 
		{ 
		
			Register register = (Register) entry.getValue();
		
			text += register.name + "                             " +  register.number + "                  " + register.value + "\n"; 
			
		}
		
		return text;
		
	}
	
}