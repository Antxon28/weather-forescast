package training.weather;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import training.utils.Constants;
import training.utils.Utils;

/**
 * Clase dedicada a la recogida de información del tiempo meterológico en una
 * zona
 * 
 * @author Antonio Soto
 *
 */
public class WeatherForecast {

	/**
	 * Obtención del tiempo en una ciudad para una fecha específica.
	 * 
	 * @param city         nombre de la ciudad
	 * @param userDatetime fecha específica del tiempo
	 * @return clima previsto para el día
	 */
	public String getCityWeather(String city, String userDatetime) {
		String weather = null;
		Date dateTime = Utils.parseStringToDate(userDatetime, Constants.USER_DATE_FORMAT);
		if (dateTime.before(Constants.SIX_DAYS_LATER)) {
			String cityWoe = getWoeidCity(city);
			if (StringUtils.isNotBlank(cityWoe)) {
				userDatetime = Utils.parseDateToString(dateTime, Constants.API_DATE_FORMAT);
				JSONArray consolidations = getConsolidatedWeather(cityWoe);
				for (Object jsonObject : consolidations) {
					if (userDatetime.equals(((JSONObject) jsonObject).get(Constants.WEATHER_DATE).toString())) {
						weather = ((JSONObject) jsonObject).get(Constants.WEATHER_NAME).toString();
					}
				}
			}
		}

		return weather;
	}

	/**
	 * Genera la conexión con los endpoints enviados por parámetro.
	 * 
	 * @param URL dirección del endpoint a conectar
	 * @return respuesta recibida por parte del endpoint
	 */
	private String createConectivity(String URL) {
		String apiResponse = null;
		try {
			HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
			HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(URL));
			apiResponse = request.execute().parseAsString();
		} catch (IOException e) {
			System.out.println("Error de conectividad.");
		}

		return apiResponse;
	}

	/**
	 * Obtiene el WOE ID de una ciudad.
	 * 
	 * @param city nombre de la ciudad
	 * @return valor WOEID de la ciudad
	 */
	private String getWoeidCity(String city) {
		String woeid = null;
		String response = createConectivity(Constants.API_URL_SEARCH + city);
		if (StringUtils.isNotBlank(response)) {
			JSONArray dataCity = new JSONArray(response);
			if (dataCity.length() != 0) {
				woeid = dataCity.getJSONObject(0).get(Constants.CITY_WOE).toString();
			}
		}

		return woeid;
	}

	/**
	 * Obtiene el clima meteorológico de una ciudad a através del WOEID
	 * 
	 * @param woe WOEID de la ciudad
	 * @return valores de clima para una ciudad en diferentes días
	 */
	private JSONArray getConsolidatedWeather(String woe) {
		JSONArray consolidations = null;
		String response = createConectivity(Constants.API_URL_LOCATION + woe);
		if (StringUtils.isNotBlank(response)) {
			consolidations = new JSONObject(response).getJSONArray(Constants.CITY_CONSOLIDATIONS);
		}

		return consolidations;
	}

}
