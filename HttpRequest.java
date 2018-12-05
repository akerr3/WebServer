
public class HttpRequest
{
	String filename;
	public HttpRequest(String request)
	{
		String lines[] = request.split("\n");
		System.out.println(lines[0]);
		lines = lines[0].split(" ");
		filename = lines[1];
	}
}
