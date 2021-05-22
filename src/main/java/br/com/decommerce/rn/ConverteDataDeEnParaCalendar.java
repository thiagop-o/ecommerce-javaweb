package br.com.decommerce.rn;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ConverteDataDeEnParaCalendar {

	public Calendar executa(String data) {
		String[] dataSplit = data.split("-"); // [2021,02,11]
		Integer ano = Integer.parseInt(dataSplit[0]);
		Integer mes = Integer.parseInt(dataSplit[1]);
		Integer dia = Integer.parseInt(dataSplit[2]);

		Calendar calendar = new GregorianCalendar(ano, (mes - 1), dia);
		return  calendar;

	}

}
