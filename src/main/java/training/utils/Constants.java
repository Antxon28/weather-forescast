package training.utils;

import java.util.Date;

/**
 * Clase utils con constantes usadas en la apicación
 * 
 * @author Antonio Soto
 *
 */
public class Constants {

	/** URL de búsqueda de ciudad */
	public static String API_URL_SEARCH = "https://www.metaweather.com/api/location/search/?query=";

	/** URL de búsqueda del tiempo en la ciudad */
	public static String API_URL_LOCATION = "https://www.metaweather.com/api/location/";

	/** Formato de fecha leíble para el usuario */
	public static String USER_DATE_FORMAT = "dd/MM/yyyy";

	/** Formato de fecha en la respuesta del API */
	public static String API_DATE_FORMAT = "yyyy-MM-dd";

	/** Día actual dentro de seis días */
	public static Date SIX_DAYS_LATER = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6));

	/** Fecha del tiempo en respuesta de API */
	public static String WEATHER_DATE = "applicable_date";

	/** Tipo de tiempo en respuesta de API */
	public static String WEATHER_NAME = "weather_state_name";

	/** Identificador WOE de la ciudad */
	public static String CITY_WOE = "woeid";

	/** Pronóstico en varias fechas del tiempo */
	public static String CITY_CONSOLIDATIONS = "consolidated_weather";

}
