package ies.lab1wradar;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {
	
	 private static Logger logger = LogManager.getLogger(App.class);

	//private static final int CITY_ID_AVEIRO = 1010500;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.ipma.pt/open-data/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		IpmaService service = retrofit.create(IpmaService.class);
		
		//Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);
		
		int CITY_ID = Integer.valueOf(args[0]);
		Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID);
		try {
			Response<IpmaCityForecast> apiResponse = callSync.execute();
			IpmaCityForecast forecast = apiResponse.body();
			//System.out.println("max temp for today: " + forecast.getData().listIterator().next().getTMax());
			
			
			System.out.println("Complete weather forecast for the city ID " + CITY_ID);
			System.out.println("Date: " + forecast.getData().listIterator().next().getForecastDate());
			System.out.println("Maximum Temperature: " + forecast.getData().listIterator().next().getTMax());
			System.out.println("Minimum Temperature: " + forecast.getData().listIterator().next().getTMin());
			
		} catch (Exception ex) {
			logger.error("Weather request for city {} has failed.", CITY_ID, ex);
		}
		
		logger.debug("Debug log");
		logger.error("Error log");
		logger.info("Info log");
	}

}
