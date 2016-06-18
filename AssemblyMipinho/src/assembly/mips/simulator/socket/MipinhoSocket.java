package assembly.mips.simulator.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import assembly.mips.simulator.address.IPHandler;

public class MipinhoSocket 
{
	
	public static boolean send( String ipAddress, String arrayBytes )
	{
		
		boolean sent = false;

		System.err.print( arrayBytes + " vai enviar isso." );
		
		try
		{

			Socket socket = new Socket( ipAddress,  IPHandler.PORT );
			
			OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
            System.err.println( "Trying to send " + arrayBytes );
            
            bw.write( arrayBytes );
            bw.flush();

			socket.close();
			
		}catch( IOException e )
		{
			
			sent = false;
			e.printStackTrace();
			
		}
		
		return sent;
		
	}
	
	public static String recive( String ipAddress )
	{
		
		String arrayBytes = null;
		
		try
		{

			ServerSocket serverSocket = new ServerSocket( IPHandler.PORT );
			Socket socket;
			
			System.err.println( "Receiving..." );
			
			while( true )
			{
				
				socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader( is );
                BufferedReader br = new BufferedReader( isr );
                arrayBytes += "";
                arrayBytes = br.readLine();
				
                if( !arrayBytes.equals( "" )  )
                	break;
                
			}

            serverSocket.close();
			
		}catch( IOException e )
		{
			
			e.printStackTrace();
			
		}
		
		return arrayBytes;
		
	}

}