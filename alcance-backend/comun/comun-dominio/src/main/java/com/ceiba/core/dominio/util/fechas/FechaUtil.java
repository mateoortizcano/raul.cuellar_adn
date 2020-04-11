package com.ceiba.core.dominio.util.fechas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class FechaUtil {

	private static final String DESCRIPCION_DEL_ERROR = "Descripción del error: ";
	private static final int MINUTO_SEGUNDO_59 = 59;
	private static final int HORA_23 = 23;
	private static final int ANIOS_DE_ESPERA_PARA_ANIO_BISIESTO = 4;
	private static final int MILISEGUNDOS_AL_DIA = 86400000;

	private FechaUtil() {
	}

	public static Calendar asignarTiempoCero(Calendar fecha) {
		fecha.set(Calendar.HOUR_OF_DAY, 0);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
		return fecha;
	}

	public static Calendar asignarFinMes(Calendar fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha.getTime());
		cal.set(Calendar.HOUR_OF_DAY, HORA_23);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, MINUTO_SEGUNDO_59);
		cal.set(Calendar.MINUTE, MINUTO_SEGUNDO_59);
		cal.set(Calendar.DAY_OF_MONTH, fecha.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal;
	}

	public static Calendar asignarInicioMesSiguiente(Calendar fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, fecha.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal;
	}

	public static Calendar asignarInicioMes(Calendar fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.DAY_OF_MONTH, fecha.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal;
	}

	public static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static Calendar localDateTimeToCalendar(LocalDateTime localDateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(
				localDateTime.getYear(),
				localDateTime.getMonthValue()-1,
				localDateTime.getDayOfMonth(),
				localDateTime.getHour(),
				localDateTime.getMinute(),
				localDateTime.getSecond());
		return calendar;
	}

	public static boolean compararMes(Calendar fechaInicio, Calendar fechaFin) {
		return (fechaInicio.get(Calendar.YEAR) == fechaFin.get(Calendar.YEAR))
				? fechaInicio.get(Calendar.MONTH) <= fechaFin.get(Calendar.MONTH)
				: fechaInicio.get(Calendar.YEAR) < fechaFin.get(Calendar.YEAR);
	}

	public static String calendartoSimpleFormat(Calendar fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setTimeZone(fecha.getTimeZone());
		return (dateFormat.format(fecha.getTime()));
	}

	public static Calendar convertirFechaLdapACalendar(String fechaLdap) {

		Calendar fechaCalendar = Calendar.getInstance();
		String[] parts = fechaLdap.split("[.]");
		String dateTimePart = parts[0];
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddhhmmss");
		formato.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date fecha;
		try {
			fecha = formato.parse(dateTimePart);
			fechaCalendar.setTime(fecha);
		} catch (ParseException e) {
			fechaCalendar = null;
		}

		return fechaCalendar;
	}

	public static int obtenerSabadosYDomingosEntreDosFechas(Calendar fechaInicio, Calendar fechaFin) {
		int contadorSabadosYDomingos = 0;
		Calendar fechaCopia = Calendar.getInstance();
		fechaCopia.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DAY_OF_MONTH));
		while (fechaFin.compareTo(fechaCopia)>0) {
			if (fechaCopia.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| fechaCopia.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				contadorSabadosYDomingos += 1;
			}
			fechaCopia.add(Calendar.DATE, 1);
		}
		return contadorSabadosYDomingos;

	}

	public static Calendar convertirDeStringACalendar(String fecha) {
		Calendar cal = Calendar.getInstance();
		try {
			String fechaString = fecha;
			DateFormat formatter;
			Date date;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.parse(fechaString);

			cal.setTime(date);

		} catch (ParseException e) {
		}
		return cal;
	}

	public static Calendar convertirMonthACalendar(String mes) {
		Calendar cal = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M");
			cal.setTime(sdf.parse(mes));
			return cal;
		} catch (ParseException e) {
		}
		return cal;
	}

	public static String convertirDeCalendarAString(Calendar fecha, String formato) {
		SimpleDateFormat format1 = new SimpleDateFormat(formato);
		return format1.format(fecha.getTime());
		
	}

	public static boolean esBisiesto(int anio) {
		return (anio % ANIOS_DE_ESPERA_PARA_ANIO_BISIESTO == 0);		
	}

	public static long diasEntreDosFechasSinContarFestivosNiFinesDeSemana(Calendar fechaInicio, Calendar fechaFin) {
		return (fechaInicio.getTimeInMillis() == fechaFin.getTimeInMillis()) ? 0
				: ((fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis()) / MILISEGUNDOS_AL_DIA)
				- obtenerSabadosYDomingosEntreDosFechas(fechaInicio, fechaFin)
				- FestivosColombia.diasFestivosEntreDosFechas(fechaInicio, fechaFin).size();
	}

	public static Integer diasEntreDosFechasSinContarFestivosNiFinesDeSemana(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {

		Calendar calendarInicial = localDateTimeToCalendar(fechaInicial);
		Calendar calendarFinal = localDateTimeToCalendar(fechaFinal);

		List<Calendar> diasFestivos = FestivosColombia.diasFestivosEntreDosFechas(
				calendarInicial,
				calendarFinal);

		Integer diasFinesDeSemana = obtenerSabadosYDomingosEntreDosFechas(
				calendarInicial,
				calendarFinal);

		Long diasTotales = fechaInicial.until(fechaFinal.plus(1L, ChronoUnit.SECONDS), ChronoUnit.DAYS);
		return diasTotales.intValue() - diasFinesDeSemana - diasFestivos.size();
	}

	public static long diasEntreDosFechas(Calendar fechaInicio, Calendar fechaFin) {
		return (fechaInicio.getTimeInMillis() == fechaFin.getTimeInMillis()) ? 0
				: ((fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis()) / MILISEGUNDOS_AL_DIA);
	}

	public static long diferenciaEntreDosFechas(Calendar fechaInicio, Calendar fechaFin) {
		return (fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis());
	}

	public static int revisarDiasRepetidos(List<Calendar> diasFestivosEntreDosFechas) {
		int contador = 0;
		for(int i = 0; i<diasFestivosEntreDosFechas.size();i++) {
			if(diasFestivosEntreDosFechas.size()==i+1) {
				contador ++;
				break;
			}
			if(diasFestivosEntreDosFechas.get(i).getTimeInMillis()!=diasFestivosEntreDosFechas.get(i+1).getTimeInMillis()) {
				contador++;
			}
		}
		return contador;
	}

	public static Calendar asignarTiempoFinDia(Calendar fecha) {
		fecha.set(Calendar.HOUR_OF_DAY, HORA_23);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, MINUTO_SEGUNDO_59);
		fecha.set(Calendar.MINUTE, MINUTO_SEGUNDO_59);
		return fecha;
	}

}
