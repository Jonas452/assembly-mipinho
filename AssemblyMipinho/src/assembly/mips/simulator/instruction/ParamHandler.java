package assembly.mips.simulator.instruction;

class ParamHandler 
{

	private String instructionType, params;
	private int paramsAmount;
	
	protected ParamHandler( String instructionType, String params, int paramsAmount )
	{
		
		this.instructionType = instructionType;
		this.params = params.toLowerCase();
		this.paramsAmount = paramsAmount;
		
	}
	
	protected String[] treate()
	{
		
		String[] paramsVetor = null;

		if( this.params != null && this.params.length() != 0 )
		{
			
			int paramPosition = 0;
			
			params = params.replaceAll( " ", "" );
			params = params.replaceAll( "\\(", "," );
			params = params.replaceAll( "\\)", "" );
			
			params += ",";
			
			paramsVetor = new String[paramsAmount];
			String param = "";		
			
			for( int i = 0; i < params.length(); i++ )
			{
				
				char paramValue = params.charAt( i );

				if( paramValue != ',' )
				{

					param += paramValue;
					
				}else
				{
				
					if( paramPosition < paramsAmount )
						paramsVetor[paramPosition] = param;
					
					param = "";
					paramPosition++;
					
				}
				
			}
			
		}
		
		return paramsVetor;
		
	}
	
	protected void printError()
	{
		
		System.err.println( "MIPINHO ERROR: Params "
				+ "( " + params + " ) "
			    + "are incorretec for the instruction ( " 
				+ instructionType + " )." );
		
	}
	
}