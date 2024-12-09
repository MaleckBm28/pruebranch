package clases;

import java.util.Scanner;

public class Jefe extends Empleado{

	Scanner teclado= new Scanner(System.in);
	private float plus;
	private String nombreDepartamento;
	
	public Jefe() {
		super();
		this.plus = 250;
	}
	
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	@Override
	public String toString() {
		return super.toString()
				+"Jefe Plus: " + plus 
				+ "  Departamento: " + nombreDepartamento;
	}
	
	public void setDatos(String dni) {
		super.setDatos(dni);
		System.out.println("Introduce nombre del departamento");
		nombreDepartamento= teclado.next();
	}
	public float sueldoFinal() {
		return super.sueldoFinal()+ plus;
		
	}
	
	

}
