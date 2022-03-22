package com.calc.app;

import com.calc.model.Decimal;
import com.calc.model.Entero;
import com.calc.model.Numero;

public class Aritmetica {
	
	/**
	 * Esta es la clase Aritmética en la cual tenemos tanto su constructor como varios metodos.
	 */
	
	public Aritmetica() {}

	
	/**
	 * Suma de dos numeros: La cual comprueba, que la base del numero 1 (n1) es igual que la del Numero 2 (n2),
	 * si el numero que le pasamos por parametros es una estancia de la clase Entero y una serie de
	 * valores que devuelve un numero nuevo creado. 
	 * @param n1 Es la variable del Numero 1
	 * @param n2 Es la varibale del Numero 2
	 * @return Un nuevo numero creado
	 */
	public Numero suma(Numero n1, Numero n2) { //Metodo suma, nos devuelve un nuevo numero
		Numero resultado = null;
		
		if(n1.getBase().equals(n2.getBase())) {
			
			if (n1 instanceof Entero && n2 instanceof Entero) {
				resultado = new Entero(n1.getValorEntero()+n2.getValorEntero());
				
			}else if(n1 instanceof Decimal && n2 instanceof Decimal) {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n1).getValorDecimal()+((Decimal)n2).getValorDecimal(),
						n1.getBase()
				);
			}else if(n1 instanceof Decimal) {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n1).getValorDecimal(),
						n1.getBase());
			}else {
				resultado = new Decimal(n1.getValorEntero()+n2.getValorEntero(),
						((Decimal)n2).getValorDecimal(),
						n1.getBase());
			}
			
		}
		
		return resultado;
	}
	/**
	 * Resta: Recibe por parametros dos numeros, y nos devuelve un tipo numero, que es tanto sustraer, inicializado a null
	 * como n1.
	 * @param n1 Numero 1
	 * @param n2 Numero 2
	 * @return Tipo numero al que se la hace la suma mediante el método anterior realizado
	 */
	public Numero resta(Numero n1, Numero n2) { //Metodo resta, devuelve un tipo numero.
		Numero sustraer = null;
		if (n2 instanceof Decimal) {
			Decimal tmp = (Decimal)n2;
			sustraer = new Decimal(-tmp.getValorEntero(), -tmp.getValorDecimal(), tmp.getBase()); 
		}else {
			sustraer = new Entero(-n2.getValorEntero());
		}
		return suma(n1, sustraer);
	}
	
	/**
	 * 
	 * @param objs Tipo objeto al cual le vamos a realizar el método realizado
	 * @return Un tipo numero, llamado decimal, que es una clase que hereda de numero, por lo cual
	 * es un tipo de numero.
	 */
	public Numero calcularMedia(Object[] objs) { 
		Numero acumulador = new Entero(0);
		
		for(int i=0; i<objs.length; i++) {
			acumulador = suma(acumulador, (Numero)objs[i]);
		}
		return new Decimal(acumulador.getValorEntero()/objs.length, 
						((Decimal)acumulador).getValorDecimal()*objs.length);
	}
}
