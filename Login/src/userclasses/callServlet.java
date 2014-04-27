package userclasses;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class callServlet implements Runnable
{
	String response = "empty";
	NetworkManager nm;
	ConnectionRequest request;
	@SuppressWarnings("static-access")
	boolean isAvailable;
	public void run() 
	{
		while (!isAvailable)
		{
			try
			{
				Thread.sleep(10);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	public void call (ArrayList <String> args, int file, final Dialog progr)
	{
		System.out.println ("hiii");
    	try
        {
            nm = NetworkManager.getInstance();
            nm.start();
            nm.addErrorListener
            (
                    new ActionListener()
                    {
                        public void actionPerformed (ActionEvent e)
                        {
                            NetworkEvent n = (NetworkEvent) e;
                            n.getError().printStackTrace();
                        }
                    }
            ); 
            request = new ConnectionRequest()
            {
                int chr;
                StringBuffer sb = new StringBuffer();
                public void readResponse(InputStream input) throws IOException
                {
                    while ((chr = input.read()) != -1)
                    {
                        sb.append((char) chr);
                    }
                    response = sb.toString();
                    response = response.trim();
                    //System.out.println ("getting the response " + response);
                    isAvailable = true;
                }
                protected void handleException(Exception err)
                {
                	progr.show("Ooops!", "Are you connected to the internet? Check your connection", "Ok", null);
                    progr.dispose();
                }
            };
            if (file == 0)
            {	
            	request.setUrl("http://localhost:8080/hupahoi/initParams");
            	request.setPost(true);
            }
            else
            {
            	//System.out.println("call for http://localhost:8080/hupahoi/initParams"+file);
            	request.setUrl("http://localhost:8080/hupahoi/initParams"+file);
            	request.setPost(true);
            }
            //System.out.println("Sending post args..");
            for (int i = 1; i <= args.size(); i++)
            {
            	System.out.println (args.get(i-1));
            	
            	request.addArgument("arg"+i, args.get(i-1));
            }
            nm.addToQueue(request);  
            
        }
        
        catch (Exception e)
        {
        	progr.show("Error occured", e.getMessage(), "OK" ,null);
        }
    	if (!response.equals("empty"))
    	{
    		//System.out.println ("Thread ends here");
    		isAvailable = true;
    	}
	}
	public String getResponse()
	{
		return response;
	}
	

}
