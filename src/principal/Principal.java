package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import clases.Empleado;
import clases.Jefe;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opc = 0;
		ArrayList<Empleado> empleados = new ArrayList<>();

		do {
			opc = menu(teclado, opc);

			if (empleados.isEmpty() && opc > 0 && opc < 10) {
				System.out.println("No hay empleados registrados");
			} else {
				switch (opc) {
				case 0:
					introducir_Datos(empleados, teclado);
					break;
				case 1:
					visualizar_TodosEmpleados(empleados);
					break;
				case 2:
					visualizar_Jefes(empleados);
					break;
				case 3:
					visualizarJefes_PorDepartamento(empleados, teclado);
					break;
				case 4:
					visualizar_DniyAntiguedad(empleados, teclado);
					break;
				case 5:
					mostrar_Sueldos(empleados, teclado);
					break;
				case 6:
					visualizarJefes_Porantiguedad(empleados, teclado);
					break;
				case 7:
					dar_DeBaja(empleados, teclado);
					break;
				case 8:
					ordenar_alfabeticamente(empleados);
					break;
				case 9:
					ordenarPorNombreEmpleado(empleados);
					break;
				case 10:
					System.out.println("Hasta luego");
					break;
				default:
					System.out.println("Opcion invalida. Intenta denuevo.");

				}
			}

		} while (opc != 10); 
	}

	
	private static void ordenarPorNombreEmpleado(ArrayList<Empleado> empleados) {
		
		Collections.sort(empleados);
		visualizar_TodosEmpleados(empleados);
		
	}


	private static void ordenar_alfabeticamente(ArrayList<Empleado> empleados) {
		Empleado p1;
		Empleado p2;
		
		ArrayList<Empleado> departamentos= new ArrayList<>();
		
		for(Empleado empleado : empleados) {
			if(empleado instanceof Jefe) {
				for(int i=0; i < departamentos.size();i++) {
					departamentos.add(empleado);
				}
			}
		}
		for(int i=0; i < departamentos.size();i++) {
			for(int j = i+1; j < departamentos.size();j++) {
				
			}
		}
		
		
	}

	private static void dar_DeBaja(ArrayList<Empleado> empleados, Scanner teclado) {
		String dniaux;
		System.out.println("Introduce DNI para dar de baja un empleado");
		dniaux= teclado.next();
		boolean baja= false;
		
		for(int i=0; i < empleados.size(); i++) {
			if(empleados.get(i).getDni().equalsIgnoreCase(dniaux)) {
				empleados.remove(i);
				baja= true;
			}
		}
		if(!baja) {
			System.out.println("No se ha encontrado ningun trabajador con ese DNI");
		}else {
			System.out.println("Baja realizada correctamente");
		}
		
	}

	private static void visualizarJefes_Porantiguedad(ArrayList<Empleado> empleados, Scanner teclado) {
		int antiguedadaux;
		
		
		System.out.println("Introduce un numero de años");
		antiguedadaux= teclado.nextInt();
		for(Empleado empleado : empleados) {
			if(empleado.antiguedad() >= antiguedadaux && empleado instanceof Jefe) {
				System.out.println(empleado);
			}
		}
		
	}

	private static void mostrar_Sueldos(ArrayList<Empleado> empleados, Scanner teclado) {
		float sueldoaux;
		boolean esmayor= false;
		System.out.println("Introduce una cantidad para mostrar los sueldos que superen esa cantidad");
		sueldoaux= teclado.nextFloat();
		
		for(Empleado empleado : empleados) {
			if(empleado.sueldoFinal() >= sueldoaux) {
				esmayor= true;
				System.out.print(empleado.getNombreEmpleado()+ empleado.sueldoFinal());
			    if (empleado instanceof Jefe) {
			    	System.out.println( " Jefe: SI.");
			    }
			}
		}
		if(!esmayor) {
			System.out.println("No hay empleados ni jefes con salarios superiores al introducido");
		}
		
	}

	private static void visualizar_DniyAntiguedad(ArrayList<Empleado> empleados, Scanner teclado) {
		String nombreaux;
		boolean encontrado= false;
		
		System.out.println("Introduce nombre o un gurpo de caracteres");
		nombreaux= teclado.next();
		for(Empleado emp : empleados) {
			if(emp.getNombreEmpleado().contains(nombreaux) ) {
				System.out.println(emp.getDni() + emp.antiguedad());
				encontrado= true;
			}
			
		}
		if(encontrado= false) {
			System.out.println("No se ha encontrado nungun empleado con ese nombre");
		}
	}

	private static void visualizarJefes_PorDepartamento(ArrayList<Empleado> empleados, Scanner teclado) {
		String departamentoaux;
		boolean hayJefes = false;
		
		System.out.println("Introduce el departento para mostrar los jefes");
		departamentoaux= teclado.next();
		
		for(Empleado empleado : empleados) {
			
			if(empleado instanceof Jefe && ((Jefe) empleado).getNombreDepartamento().equalsIgnoreCase(departamentoaux) ) {
				if(hayJefes==false) {
					System.out.println("Jefe/s del departamento " + departamentoaux);
					hayJefes=true;
				}
				System.out.println(empleado.getNombreEmpleado());
			
			}
		}
		
		if (hayJefes==false) {
			System.out.println("No hay ningún Jefe");
		}

	}

	private static void visualizar_Jefes(ArrayList<Empleado> empleados) {

		for (Empleado empleado : empleados) {

			if (empleado instanceof Jefe) {
				System.out.println(empleado);
			}
		}

	}

	private static void visualizar_TodosEmpleados(ArrayList<Empleado> empleados) {
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println(empleados.toString());
		}

	}

	private static void introducir_Datos(ArrayList<Empleado> empleados, Scanner teclado) {
		String dni, esjefe = "SI";
		int dnicheck;
		Empleado empleado;
		boolean seguir = true;

		do {
			System.out.println("Introduce DNI para registrar empleado");
			dni = teclado.next();
			dnicheck = buscarDni(empleados, dni);

			if (dnicheck == -1) {
				empleado = new Empleado();

				empleado.setDatos(dni);
				empleados.add(empleado);
				System.out.println("Empleado añadido correctamente");

				System.out.println("¿el empleado registrado es Jefe?");
				esjefe = teclado.next();
				if (esjefe.equalsIgnoreCase("si")) {
					empleado = new Jefe();
					empleado.setDatos(dni);
					empleados.add(empleado);
					System.out.println("Jefe añadido correctamente");
				}
			} else {
				System.out.println("Ya existe un empleado con ese DNI");
			}

			System.out.println("¿Quieres seguir registrando empleados?");
			seguir = teclado.next().equalsIgnoreCase("si");
		} while (seguir);

	}

	private static int buscarDni(ArrayList<Empleado> empleados, String dni) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getDni().equalsIgnoreCase(dni)) {
				return i;
			}
		}
		return -1;
	}

	private static int menu(Scanner teclado, int opc) {
		System.out.println("******MENU******");
		System.out.println("0. Introducir datos de empleados y/o jefes");
		System.out.println("1. Visualizar todos los empleados");
		System.out.println("2. Visualizar los jefes");
		System.out.println("3. visualizar los jefes de un departamento");
		System.out.println("4. buscar DNI y años de que lleva en la empresa");
		System.out.println("5. ordenar sueldo y puesto");
		System.out.println("6. Mostrar jefes por años");
		System.out.println("7. Dar de baja un empleado");
		System.out.println("8. Estadistica ordenada");
		System.out.println("9. Estadistica ordenada");
		System.out.println("10. Salir");

		return opc = teclado.nextInt();
	}

}
