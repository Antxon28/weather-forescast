package training.weather;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para la clase WeatherForecast
 * 
 * @author Antonio Soto
 */
public class WeatherForecastTest {

	/**
	 * Objeto principal
	 */
	private WeatherForecast weatherForecast;

	/**
	 * Inicialización previa de las variables globales
	 */
	@Before
	public void init() {
		weatherForecast = new WeatherForecast();
	}

	/**
	 * Test unitario de búsqueda del tiempo en una ciudad en una fecha concreta
	 * 
	 * @throws IOException Excepción en conexión con API.
	 */
	@Test
	public void weatherCityDateTest() throws IOException {
		String forecast = weatherForecast.getCityWeather("Santander", "31/10/2020");
		Assert.assertNotNull(forecast);
		System.out.println(forecast);
	}

	/**
	 * Test unitario de búsqueda del tiempo en una ciudad sin fecha
	 * 
	 * @throws IOException Excepción en conexión con API.
	 */
	@Test
	public void weatherCityNoDateTest() throws IOException {
		String forecast = weatherForecast.getCityWeather("Santander", null);
		Assert.assertNotNull(forecast);
		System.out.println(forecast);
	}

	/**
	 * Test unitario de búsqueda del tiempo en una ciudad con nombre erroneo
	 * 
	 * @throws IOException Excepción en conexión con API.
	 */
	@Test
	public void weatherBadCityTest() throws IOException {
		String forecast = weatherForecast.getCityWeather("Santanderea", "31/10/2020");
		Assert.assertNull(forecast);
	}

}