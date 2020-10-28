package training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase utils con métodos de ayuda
 * 
 * @author Antonio Soto
 *
 */
public class Utils {

	/**
	 * Convierte una fecha cadena en formato Date
	 * 
	 * @param dateTime   fecha en formato String
	 * @param dateFormat formato a convertir la fecha
	 * @return fecha convertida en formato Date.
	 */
	public static Date parseStringToDate(String dateTime, String dateFormat) {
		Date date = new Date();
		try {
			if (StringUtils.isNotBlank(dateTime)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
				date = simpleDateFormat.parse(dateTime);
			}
		} catch (ParseException e) {
			System.out.println("Error en el parse de fecha. " + e);
		}

		return date;
	}

	/**
	 * Convierte una fecha en formato cadena
	 * 
	 * @param dateTime   fecha a convertir
	 * @param dateFormat formato a convetir la fecha
	 * @return fecha en formato cadena
	 */
	public static String parseDateToString(Date dateTime, String dateFormat) {
		String date = null;
		try {
			if (dateTime != null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
				date = simpleDateFormat.format(dateTime);
			}
		} catch (Exception e) {
			System.out.println("Error en el parse de fecha. " + e);
		}

		return date;
	}

}
