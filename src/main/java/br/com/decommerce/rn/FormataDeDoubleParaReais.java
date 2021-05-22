package br.com.decommerce.rn;

import java.text.NumberFormat;
import java.util.Locale;

public class FormataDeDoubleParaReais {
	private final Locale local = new Locale("pt","BR");

	public String executa(Double valor) {
		return NumberFormat.getCurrencyInstance(local).format(valor);
	}

}
