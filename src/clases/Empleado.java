package clases;

import java.time.LocalDate;
import java.util.Scanner;

public class Empleado implements Comparable<Empleado> {
	Scanner teclado= new Scanner(System.in);
	
	private final String NOMBRE_EMPRESA= "ElectricaS.A.";
	private String dni;
	private String nombreEmpleado;
	private int mesEntrada;
	private int anioEntrada;
	private float incrementoSueldo;
	private float sueldoBase;
	
	public Empleado() {
		super();
		this.sueldoBase = 1000;
	}

	public String getNombreEmpresa() {
		return NOMBRE_EMPRESA;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public int getMesEntrada() {
		return mesEntrada;
	}
	public void setMesEntrada(int mesEntrada) {
		this.mesEntrada = mesEntrada;
	}
	
	public int getAnioEntrada() {
		return anioEntrada;
	}
	public void setAnioEntrada(int anioEntrada) {
		this.anioEntrada = anioEntrada;
	}
	public float getIncrementoSueldo() {
		return incrementoSueldo;
	}
	public void setIncrementoSueldo(float incrementoSueldo) {
		this.incrementoSueldo = incrementoSueldo;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	@Override
	public String toString() {
		return NOMBRE_EMPRESA + "  DNI: " + dni 
				+ " Nombre del empleado: " + nombreEmpleado
				+ " Mes en el que entro: " + mesEntrada 
				+ " Año de entrada: " + anioEntrada
				+ " Porcentaje de incremento de sueldo: " + incrementoSueldo+ " %" 
				+ " Sueldo base: " + sueldoBase 
				+ " Sueldo: " + sueldoFinal() ;
	}
	public void setDatos(String dni) {
		this.dni= dni;
		System.out.println("Introduce nombre del empleado");
		nombreEmpleado= teclado.next();
		System.out.println("Introduce el mes de entrada");
		mesEntrada= teclado.nextInt();
		System.out.println("Introduce año de entrada");
		anioEntrada= teclado.nextInt();
		System.out.println("Introduce el porcentaje de incremento del sueldo");
		incrementoSueldo= teclado.nextFloat();
	}
	
	public int antiguedad() {
		return LocalDate.now().getYear()-anioEntrada;
		
	}
	
	public float sueldoFinal() {
		float sueldofinal;
		sueldofinal= sueldoBase + incrementoSueldo/100;
		if(LocalDate.now().getYear()-anioEntrada > 6 && (LocalDate.now().getYear()-anioEntrada == 6 && LocalDate.now().getMonthValue()<= mesEntrada )) {
			sueldofinal+= 100;
		}
		return sueldofinal;
		
	}
	
	@Override
	public int compareTo(Empleado otroEmpleado) {
		
		//return this.nombreEmpleado.compareTo(otroEmpleado.getNombreEmpleado());
		return Integer.compare(this.anioEntrada, otroEmpleado.getAnioEntrada());
	}
	
	
	
	
	
	
	
	
	
	
	
}
