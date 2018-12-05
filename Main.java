import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main 
{
	ServerSocket serverSocket;
	
	public static void main(String[] args) throws Exception
	{
		new Main().runServer();
	}
	
	public void runServer() throws Exception
	{
		System.out.println("Server is started");
		serverSocket = new ServerSocket(5102);
		//port number
		acceptRequests();
	}
	
	private void acceptRequests() throws Exception
	{
		while(true)
		{
			Socket s = serverSocket.accept();
			ConnectHandle c = new ConnectHandle(s);
			
			c.start();
		}
	}
	
}
