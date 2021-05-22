package br.com.decommerce.rn;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatarData {

	public String executa(Calendar data) {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		return  dataFormatada;
	}

}
