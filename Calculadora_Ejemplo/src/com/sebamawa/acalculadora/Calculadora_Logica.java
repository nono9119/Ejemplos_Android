/** Clase que representa la logica utilizada al operar por la calculadora */

package com.sebamawa.acalculadora;

public class Calculadora_Logica {
		
	//enumerado para las operaciones
	public static enum Operacion{SUMA, RESTA, PRODUCTO, DIVISION, NINGUNA}
	
	//atributos
	private int resultado = 0;
	private Operacion operacionActual = Operacion.NINGUNA;
	
	//asigna una operacion y el primer operando
	public void setOperacion(Operacion op, int operando){
		this.operacionActual = op;
		resultado = operando;
	}
	
	//realiza la operacion usando la operacion y el primer
	//operando de setOperacion(), y ademos el valor pasado (segundo operando)
	//Retorna el resultado y establece como operacion pendiente a NINGUNA
	public int realizarOperacion(int operando){
		switch (operacionActual){
			case SUMA: resultado += operando; break;
			case RESTA: resultado -= operando; break;
			case PRODUCTO: resultado *= operando; break;
			case DIVISION: resultado /= operando; break;
		}
		operacionActual = Operacion.NINGUNA;
		return resultado;
	}
	
	//devuelve el resultado actual de la calculadora
	public int getResultado(){
		return resultado;
	}
	
	//devuelve la operacion actual asignada a la calculadora
	public Operacion getOperacion(){
		return this.operacionActual;
	}
	
	//establece el resultado a cero y como operacion pendiente a NINGUNA
	public void reiniciar(){
		resultado = 0;
		operacionActual = Operacion.NINGUNA;
	}

}


