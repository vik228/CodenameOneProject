package userclasses;

import java.util.ArrayList;

import com.codename1.location.Location;
import com.codename1.location.LocationListener;
import com.codename1.location.LocationManager;

public class MyLocationListener implements LocationListener , Runnable 
{
	boolean locationReady;
	int status = LocationManager.OUT_OF_SERVICE;
	double lat = 0;
	double lng = 0;
	double dir=0;
    double logdegree=0;
    double logminute=0;
    double logsecond =0;
    double latdegree=0;
    double latminute=0;
    double latsecond =0;
	public void decimaltomd5(double longitude2, double latitude2) 
	{
		// TODO Auto-generated method stub
         	double log = longitude2;
		    double lat = latitude2;
		    double d1 = Math.floor (log);
		    double d2 = Math.floor (lat);
		    double minfloat1 = (d1-log)*60;
		    double m1 = Math.floor(minfloat1);
		    double secfloat1 = (minfloat1-m1)*60;
		    double s1 = Math.round(secfloat1);
		   if (s1==60) 
		   {
		     m1++;
		     s1=0;
		   }
		   if (m1==60) 
		   {
		     d1++;
		     m1=0;
		   }
		   logdegree=(int)Math.abs(d1);
		   logminute =(int)Math.abs(m1);
		   logsecond = (int)Math.abs(s1);
		   //System.out.println (logdegree + ":" + logminute + ":" + logsecond);
			 
		   double minfloat2 = (d2-lat)*60;
		   double m2 = Math.floor(minfloat2);
		   double secfloat2 = (minfloat2-m2)*60;
		   double s2 = Math.round(secfloat2);
			   // After rounding, the seconds might become 60. These two
			   // if-tests are not necessary if no rounding is done.
		   if (s2==60) 
		   {
			   	m2++;
			    s2=0;
		   }
		   if (m2==60) 
		   {
			    d2++;
			    m2=0;
		   }
		   latdegree=(int)Math.abs(d2);
		   latminute =(int)Math.abs(m2);
		   latsecond = (int)Math.abs(s2);
	 }	
	public void run() 
	{
		System.out.println ("run called");
		while (!locationReady)
		{
			try
			{
				System.out.println ("going to sleep");
				Thread.sleep(100);
			}
			catch (InterruptedException err)
			{
				err.printStackTrace();
			}
		}
		
	}

	public void locationUpdated(Location location) 
	{
		//System.out.println ("Upper me called");
		lat = location.getLatitude();
		lng = location.getLongitude();
		dir=location.getDirection();
		//System.out.println(dir+""+lat+""+lng);
		locationReady = true; 
		
	}

	public void providerStateChanged(int newState) 
	{
		System.out.println ("Me called");
		if (newState == LocationManager.AVAILABLE)
		{
			status = newState;
			locationReady = true;
		}
	}

	public ArrayList<String> getLocationStatus()
	{
		
			ArrayList <String> al1 = new ArrayList<String>();
			decimaltomd5 (lat, lng);
			al1.add (String.valueOf(lat));
			al1.add (String.valueOf(latdegree)); 
			al1.add (String.valueOf(latminute)); 
			al1.add (String.valueOf(latsecond)); 
		    al1.add(String.valueOf(lng));
		   // al1.add (String.valueOf(dir));
		    al1.add (String.valueOf(logdegree)); 
		    al1.add (String.valueOf(logminute)); 
		    al1.add (String.valueOf(logsecond)); 
		  
		    return al1;
	}
	
	
}
