package com.ceiba.core.dominio.util.fechas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public final class FestivosColombia {

	private static final int ANIO_2299 = 2299;
	private static final int ANIO_2200 = 2200;
	private static final int ANIO_2199 = 2199;
	private static final int ANIO_2100 = 2100;
	private static final int ANIO_2099 = 2099;
	private static final int ANIO_1900 = 1900;
	private static final int CONSTANTE_1 = 1;
	private static final int CONSTANTE_2 = 2;
	private static final int CONSTANTE_4 = 4;
	private static final int CONSTANTE_6 = 6;
	private static final int CONSTANTE_7 = 7;
	private static final int CONSTANTE_9 = 9;
	private static final int CONSTANTE_10 = 10;
	private static final int CONSTANTE_18 = 18;
	private static final int CONSTANTE_19 = 19;
	private static final int CONSTANTE_22 = 22;
	private static final int CONSTANTE_25 = 25;
	private static final int CONSTANTE_26 = 26;
	private static final int CONSTANTE_28 = 28;
	private static final int CONSTANTE_30 = 30;

	public static final int DIA_LUNES = Calendar.MONDAY;
	public static final int DIA_JUEVES = Calendar.THURSDAY;
	public static final int DIA_VIERNES = Calendar.FRIDAY;
	public static final int DIA_DOMINGO = Calendar.SUNDAY;


	public static List<Calendar> diasFestivosEntreDosFechas(Calendar fechaInicio, Calendar fechaFin) {
		List<Calendar> listaFestivosEntreDosFechas = new ArrayList<>();
		int anioFechaInicio = fechaInicio.get(Calendar.YEAR);
		int anioFechaFin = fechaFin.get(Calendar.YEAR);
		List<Calendar> listaFestivos = new ArrayList<>();
		for (int anio = anioFechaInicio; anio <= anioFechaFin; anio++) {
			listaFestivos.addAll(diasFestivos(anio));
		}
		long fechaInicioEnMilisegundos = fechaInicio.getTimeInMillis();
		long fechaFinEnMilisegundos = fechaFin.getTimeInMillis();
		for (int i = 0; i < listaFestivos.size(); i++) {
			if (listaFestivos.get(i).getTimeInMillis() >= fechaInicioEnMilisegundos
					&& listaFestivos.get(i).getTimeInMillis() <= fechaFinEnMilisegundos
					&& (!esFinDeSemana(listaFestivos.get(i)))) {
				listaFestivosEntreDosFechas.add(listaFestivos.get(i));
			}
		}
		return listaFestivosEntreDosFechas;
	}

	public static boolean esFinDeSemana(Calendar fecha) {

		return (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
	}

	public static List<Calendar> diasFestivos(int anio) {
		List<Calendar> diasFestivos = new ArrayList<>();

		Calendar pascua = calcularPascua(anio);
		Calendar diaFestivo = Calendar.getInstance();

		incluirFechaFestivaFija(anio, Calendar.JANUARY, FestivosColombiaEnum.PRIMERO.getValue(), diasFestivos);

		diaFestivo.set(anio, Calendar.JANUARY, FestivosColombiaEnum.REYES_MAGOS.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		diaFestivo.set(anio, Calendar.MARCH, FestivosColombiaEnum.SAN_JOSE.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_DOMINGO, pascua, true, false), diasFestivos); // Domingo de
																											// Ramos

		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_JUEVES, pascua, true, true), diasFestivos); // Jueves Santo

		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_VIERNES, pascua, true, true), diasFestivos); // Viernes Santo

		incluirFechaVariablePorAnio(pascua, diasFestivos); // Pascua

		incluirFechaFestivaFija(anio, Calendar.MAY, FestivosColombiaEnum.PRIMERO.getValue(), diasFestivos);

		diaFestivo = siguienteDiaSemana(DIA_LUNES, pascua, false, true);
		diaFestivo.add(Calendar.DAY_OF_YEAR, FestivosColombiaEnum.ASCENSION_JESUS.getValue());
		incluirFechaVariablePorAnio(diaFestivo, diasFestivos);

		diaFestivo = siguienteDiaSemana(DIA_LUNES, pascua, false, true);
		diaFestivo.add(Calendar.DAY_OF_YEAR, FestivosColombiaEnum.CORPUS_CHRISTI.getValue());
		incluirFechaVariablePorAnio(diaFestivo, diasFestivos);

		diaFestivo = siguienteDiaSemana(DIA_LUNES, pascua, false, true);
		diaFestivo.add(Calendar.DAY_OF_YEAR, FestivosColombiaEnum.SAGRADO_CORAZON.getValue());
		incluirFechaVariablePorAnio(diaFestivo, diasFestivos);

		diaFestivo.getTime();
		diaFestivo.set(anio, Calendar.JUNE, FestivosColombiaEnum.SAN_PEDRO_PABLO.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		incluirFechaFestivaFija(anio, Calendar.JULY, FestivosColombiaEnum.INDEPENDENCIA.getValue(), diasFestivos);

		incluirFechaFestivaFija(anio, Calendar.AUGUST, FestivosColombiaEnum.BATALLA_BOYACA.getValue(), diasFestivos);

		diaFestivo.set(anio, Calendar.AUGUST, FestivosColombiaEnum.ASCENCION_VIRGEN.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		diaFestivo.set(anio, Calendar.OCTOBER, FestivosColombiaEnum.DIA_RAZA.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		diaFestivo.set(anio, Calendar.NOVEMBER, FestivosColombiaEnum.TODOS_LOS_SANTOS.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		diaFestivo.set(anio, Calendar.NOVEMBER, FestivosColombiaEnum.INDEPENDENCIA_CARTAGENA.getValue());
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true), diasFestivos);

		incluirFechaFestivaFija(anio, Calendar.DECEMBER, FestivosColombiaEnum.INMACULADA_CONCEPCION.getValue(),
				diasFestivos);

		incluirFechaFestivaFija(anio, Calendar.DECEMBER, FestivosColombiaEnum.NAVIDAD.getValue(), diasFestivos);

		return Collections.unmodifiableList(diasFestivos);

	}

	private static void incluirFechaVariablePorAnio(Calendar diaFestivo, List<Calendar> diasFestivos) {

		if (!esfestivo(diasFestivos, diaFestivo)) {
			Calendar fechaAgregar = Calendar.getInstance();
			fechaAgregar.setTime(diaFestivo.getTime());

			FechaUtil.asignarTiempoCero(fechaAgregar);
			diasFestivos.add(fechaAgregar);
		}

	}

	private static Calendar calcularPascua(int anio) {
		int a;
		int b;
		int c;
		int d;
		int e;
		int m = FestivosColombiaEnum.CONSTANTE_ANIO_1900_2100.getValue();
		int n = FestivosColombiaEnum.CONSTANTE_ANIO_2099.getValue();

		if (anioEntre1900Y2099(anio)) {
			m = FestivosColombiaEnum.CONSTANTE_ANIO_1900_2100.getValue();
			n = FestivosColombiaEnum.CONSTANTE_ANIO_2099.getValue();
		} else if (anioEntre2100Y2199(anio)) {
			m = FestivosColombiaEnum.CONSTANTE_ANIO_1900_2100.getValue();
			n = FestivosColombiaEnum.CONSTANTE_ANIO_2199.getValue();
		} else if (anioEntre2200Y2299(anio)) {
			m = FestivosColombiaEnum.CONSTANTE_ANIO_2200.getValue();
			n = FestivosColombiaEnum.CONSTANTE_ANIO_2299.getValue();
		}

		a = anio % CONSTANTE_19;
		b = anio % CONSTANTE_4;
		c = anio % CONSTANTE_7;
		d = ((a * CONSTANTE_19) + m) % CONSTANTE_30;
		e = ((CONSTANTE_2 * b) + (CONSTANTE_4 * c) + (CONSTANTE_6 * d) + n) % CONSTANTE_7;

		int dia = d + e;

		Calendar inicioPascua = Calendar.getInstance();
		if (dia < CONSTANTE_10) { // Marzo
			inicioPascua.set(anio, Calendar.MARCH, dia + CONSTANTE_22);
			return inicioPascua;
		} else if (dia == CONSTANTE_26) {// Abril
			dia = CONSTANTE_19;
		} else if (dia == CONSTANTE_25 && d == CONSTANTE_28 && e == CONSTANTE_6 && a > CONSTANTE_10) {
			dia = CONSTANTE_18;
		} else {
			dia -= CONSTANTE_9;
		}
		inicioPascua.set(anio, Calendar.APRIL, dia);
		return inicioPascua;
	}

	private static boolean anioEntre2200Y2299(int anio) {
		return anio >= ANIO_2200 && anio <= ANIO_2299;
	}

	private static boolean anioEntre2100Y2199(int anio) {
		return anio >= ANIO_2100 && anio <= ANIO_2199;
	}

	private static boolean anioEntre1900Y2099(int anio) {
		return anio >= ANIO_1900 && anio <= ANIO_2099;
	}

	private static Calendar siguienteDiaSemana(int diaSemana, Calendar fechaReferencia, boolean haciaAtras,
			boolean inclusive) {
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(fechaReferencia.getTime());
		if (inclusive) {
			if (fecha.get(Calendar.DAY_OF_WEEK) == diaSemana) {
				return fecha;
			}
		} else {
			if (haciaAtras) {
				fecha.add(Calendar.DAY_OF_YEAR, -CONSTANTE_1);
			} else {
				fecha.add(Calendar.DAY_OF_YEAR, CONSTANTE_1);
			}
		}
		while (fecha.get(Calendar.DAY_OF_WEEK) != diaSemana) {
			if (haciaAtras) {
				fecha.add(Calendar.DAY_OF_YEAR, -CONSTANTE_1);
			} else {
				fecha.add(Calendar.DAY_OF_YEAR, CONSTANTE_1);
			}
		}
		return fecha;
	}

	public static boolean esfestivo(List<Calendar> listafestivos, Calendar fechaFestiva) {
		FechaUtil.asignarTiempoCero(fechaFestiva);

		int anioFecha = fechaFestiva.get(Calendar.YEAR);
		int mesFecha = fechaFestiva.get(Calendar.MONTH);
		int diaFecha = fechaFestiva.get(Calendar.DAY_OF_MONTH);
		try {
			for (int i = 0; i < listafestivos.size(); i++) {
				int anioFechaLista = listafestivos.get(i).get(Calendar.YEAR);
				int mesFechaLista = listafestivos.get(i).get(Calendar.MONTH);
				int diaFechaLista = listafestivos.get(i).get(Calendar.DAY_OF_MONTH);
				if (anioFecha == anioFechaLista && mesFechaLista == mesFecha && diaFecha == diaFechaLista) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;

	}

	private static void incluirFechaFestivaFija(int anio, int mes, int dia, List<Calendar> diasFestivos) {
		Calendar fechaAgregar = Calendar.getInstance();
		fechaAgregar.set(anio, mes, dia);
		FechaUtil.asignarTiempoCero(fechaAgregar);
		diasFestivos.add(fechaAgregar);
	}
}
