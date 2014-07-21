import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.rapidminer.Process;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.tools.XMLException;

import twitter4j.GeoLocation;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class MonitoraStatus implements StatusListener {

	@Override
    public void onStatus(Status status) {

		Tweet tweet = new Tweet(status);
		String classificacao = tweet.classificaTweet();
		if (classificacao.equals("Positivos")){
//			modeloTemporal.addSensor(status);
			System.out.println(classificacao + ": " + status.getText());
			if( status.getPlace() != null)
				System.out.println("place : " + status.getPlace().getFullName() + status.getPlace().getName());
			
			if( ! status.getUser().getLocation().equals(""))
				System.out.println("location :" + status.getUser().getLocation());
			
			if( status.getGeoLocation() != null) 
				System.out.println("" + status.getGeoLocation().getLatitude()+ status.getGeoLocation().getLongitude());
		}
	
		
	
	}		
		
		
/*		
	String temp = new String("{\"texto\":");
	
	GeoLocation localizacao;
	
	temp += "\"" + status.getText() + "\"}";
	localizacao = status.getGeoLocation();
	
	if (localizacao != null){
		System.out.println(localizacao.toString() + temp  + status.getPlace().getName());
		
	}
	
	
	
		
    }
*/

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
        System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
    }

    @Override
    public void onStallWarning(StallWarning warning) {
        System.out.println("Got stall warning:" + warning);
    }

    @Override
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
    
    

}
