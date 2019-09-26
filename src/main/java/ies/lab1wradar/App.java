package ies.lab1wradar;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {

	private static Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug("Program args: {}", Arrays.toString(args));
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.ipma.pt/open-data/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		IpmaService service = retrofit.create(IpmaService.class);

		String userInput = args[0];

		try {
			int cityId = getCityId(userInput, service);
			IpmaCityForecast forecast = getForecast(cityId, service);
			printForecast(forecast);
		} catch (Exception ex) {
			logger.error("Failed to retrieve forecast.", ex);
		}
		
		logger.info("Program is exiting.");
	}
	
	public static int getCityId(String userInput, IpmaService service) throws Exception {
		logger.debug("Retrieving city id for input '{}'", userInput);
		Integer cityId;
		Scanner inputScanner = new Scanner(userInput);
		if (inputScanner.hasNextInt()) {
			cityId = inputScanner.nextInt();
		} else if (inputScanner.hasNext()) {
			NameToCityId converter = buildConverter(service);
			cityId = converter.getCityId(inputScanner.next());
		} else {
			inputScanner.close();
			logger.error("Invalid input {}.", userInput);
			throw new Exception("'" + userInput + "' is not valid as a city name or id.");
		}
		
		if (cityId == null) {
			inputScanner.close();
			logger.error("Could not retrieve city id for input {}.", userInput);
			throw new Exception("'" + userInput + "' is not valid as a city name or id.");
		}
		
		inputScanner.close();
		return cityId;
	}

	public static IpmaCityForecast getForecast(Integer cityId, IpmaService service) throws Exception {
		Call<IpmaCityForecast> callSync = service.getForecastForACity(cityId);
		Response<IpmaCityForecast> apiResponse = callSync.execute();
		
		if (apiResponse.code() != 200) {
			logger.error("Request for forecast (city id: {}) returned with code {}.", cityId, apiResponse.code());
			throw new Exception("Forecast data for the city id " + cityId + " doesn't exist.");
		}

		IpmaCityForecast forecast = apiResponse.body();
		return forecast;
	}
	
	public static void printForecast(IpmaCityForecast forecast) {
			System.out.println("Complete weather forecast for the city ID " + forecast.getGlobalIdLocal());
			System.out.println("Date: " + forecast.getData().listIterator().next().getForecastDate());
			System.out.println("Maximum Temperature: " + forecast.getData().listIterator().next().getTMax());
			System.out.println("Minimum Temperature: " + forecast.getData().listIterator().next().getTMin());
	}

	public static NameToCityId buildConverter(IpmaService service) throws Exception {
		try {
			Call<IpmaCities> callSync = service.getCities();
			Response<IpmaCities> apiResponse = callSync.execute();
			IpmaCities city = apiResponse.body();

			NameToCityId converter = new NameToCityId(city.getData());
			return converter;

		} catch (Exception ex) {
			logger.error("Failed to create NameToCityId converter", ex);
			throw ex;
		}
	}
}
