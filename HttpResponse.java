import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HttpResponse 
{
	
	HttpRequest req;
	String response;
	String root = "C:/test";
	
	
	public HttpResponse(HttpRequest request)
	{
		req = request;
		File f = new File(root + req.filename);
		
		try
		{
			FileInputStream fis = new FileInputStream(f);
			response = "HTTP/1.1 200 \r\n";
			response += "Server: Our Java Server/1.0 \r\n";
			response += "Content-Type: text/html \r\n";
			response += "Connection: close \r\n";
			response += "Content-Length: " + f.length() + " \r\n";
			response += "\r\n";
			int s;
			while((s = fis.read())!= -1)
			{
				response += (char) s;
			}
			fis.close();
			
		}
		catch(FileNotFoundException e)
		{
			response = response.replaceAll("200", "404");
		}
		catch(Exception e)
		{
			response = response.replace("200" , "500");
		}
	}
}
