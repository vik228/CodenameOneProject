package userclasses;
import java.util.ArrayList;

import com.codename1.components.InfiniteProgress;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
public class GpsConnection extends Location
{
	
	double lat = 0;
	double lng = 0;
	LocationManager lm = null;
	ArrayList <String> ret_val = new ArrayList <String>();
	public ArrayList <String> getLocation()
	{
		lm = LocationManager.getLocationManager();
		InfiniteProgress inf = new InfiniteProgress();            
	    final Dialog progress = inf.showInifiniteBlocking();
	    MyLocationListener m = new MyLocationListener();
	    lm.setLocationListener(m);
	    Display.getInstance().invokeAndBlock(m);
        progress.dispose();
        lm.setLocationListener(null);
        ret_val = m.getLocationStatus();
        return ret_val;
	}
}
 