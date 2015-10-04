package pat.mcgoldrick.customercrm.distancecalc.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;

import org.apache.log4j.Logger;

public class DistanceCalculatorEngine {
	
	final static Logger logger = Logger.getLogger(DistanceCalculatorEngine.class);
	public static final double EARTH_RADIUS = 6371;
	
	
	public Double calcDistance(double lat1, double long1, double lat2, double long2){
		// valid params
		if(lat1 > 90 || lat1 < -90 
				|| long1 > 180 || long1 < -180
				|| lat2 > 90 || lat2 < -90 
				||long2 > 180 || long2 < -180){
			throw new InvalidParameterException("Values outside of Range");
		}
		
		return calcDistanceInRadians(Math.toRadians(lat1), Math.toRadians(long1), Math.toRadians(lat2), Math.toRadians(long2));
	}
	
	protected Double calcDistanceInRadians(double latRad1, double longRad1, double latRad2, double longRad2){
		
		Double longDiff = longRad1 - longRad2;
		
		Double centralAngle = Math.acos(Math.sin(latRad1)*Math.sin(latRad2) + Math.cos(latRad1)*Math.cos(latRad2)*Math.cos(longDiff));
		
		Double distanceInKM = EARTH_RADIUS*centralAngle;
		
		BigDecimal bdDistance = new BigDecimal(Math.abs(distanceInKM));
		return bdDistance.setScale(1, RoundingMode.UP).doubleValue();
	}

}
