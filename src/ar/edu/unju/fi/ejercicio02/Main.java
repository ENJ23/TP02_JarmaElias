package ar.edu.unju.fi.ejercicio02;
import ar.edu.unju.fi.ejercicio02.model.*;
import ar.edu.unju.fi.ejercicio02.constantes.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Efemeride> efemerides = new ArrayList<>(); 
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			try {
			 System.out.println("Menú de acciones:");
	            System.out.println("1 - Crear efeméride");
	            System.out.println("2 - Mostrar efemérides");
	            System.out.println("3 - Eliminar efeméride");
	            System.out.println("4 - Modificar efeméride");
	            System.out.println("5 - Salir");
	            System.out.print("Elija una opción: ");
	            opcion = scanner.nextInt();
	            switch(opcion) {
                case 1:
                    crearEfemeride(efemerides, scanner);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(efemerides, scanner);
                    break;
                case 4:
                    modificarEfemeride(efemerides, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
	            	}
			}catch (InputMismatchException e){
				 System.out.println("Error: Debe ingresar un número entero con valor del 1 al 5.");
		            scanner.nextLine(); 
		            opcion = 0; // Reiniciar la opción para evitar bucles infinitos
		        }
			
        } while(opcion != 5);

}		
	
		
		
		private static void crearEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		    System.out.println("Ingrese el código de la efeméride:");
		    int dia = 0;
		    String codigo = scanner.next();
		    
		    System.out.println("Ingrese el mes (número del 1 al 12):");
		    int mesNum = scanner.nextInt();
		    while (mesNum < 1 || mesNum > 12) {
		        System.out.println("Número de mes inválido. Ingrese un número del 1 al 12:");
		        mesNum = scanner.nextInt();
		    }
		    Mes mes = Mes.values()[mesNum - 1];
		    //Validacion si es un numero fuera del mes 
		    do {
		    	System.out.println("Ingrese un día:");
		    	dia = scanner.nextInt();
		    	if (mes == Mes.ENERO | mes == Mes.MARZO | mes == Mes.MAYO | mes == Mes.JULIO | mes == Mes.AGOSTO | mes == Mes.OCTUBRE | mes == Mes.DICIEMBRE) {
		    		if (dia < 1 | dia > 31) {
		    		System.out.println("Dia fuera de rango...");
		    		dia = 99;
		    		
		    		}
		    	}
		    	//Validacion para meses de 30 dias
		    	if (mes == Mes.ABRIL | mes == Mes.JUNIO | mes == Mes.SEPTIEMBRE | mes == Mes.NOVIEMBRE ){
		    		if (dia < 1 | dia > 30) {
		    			System.out.println("Dia fuera de rango para este mes...");
		    			dia = 99;
		    			
		    		}
		    	}
		    	//Validacion para mes con 29 dias máximo
		    	if (mes == Mes.FEBRERO) {
		    		if (dia < 1 | dia > 29) {
		    			System.out.println("Dia fuera de rango para este mes...");
		    			dia = 99;
		    			
		    			}
		    		}
		    	
		    } while (dia < 0 | dia > 32);
		    
		    System.out.println("Ingrese el detalle:");
		    scanner.nextLine(); // Limpiar el buffer
		    String detalle = scanner.nextLine();
		    
		    Efemeride nuevaEfemeride = new Efemeride(codigo, mes, dia, detalle);
		    efemerides.add(nuevaEfemeride);
		    System.out.println("Efeméride creada exitosamente.");

		}
		
		private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
		    if (efemerides.isEmpty()) {
		        System.out.println("No hay efemérides para mostrar.");
		    } else {
		        for (Efemeride efemeride : efemerides) {
		            System.out.println("Código: " + efemeride.getCodigo());
		            System.out.println("Mes: " + efemeride.getMes());
		            System.out.println("Día: " + efemeride.getDia());
		            System.out.println("Detalle: " + efemeride.getDetalle());
		            System.out.println("-------------------------");
		        }
		    }
		}

		private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		    if (efemerides.isEmpty()) {
		        System.out.println("No hay efemérides para eliminar.");
		    } else {
		        System.out.println("Ingrese el código de la efeméride a eliminar:");
		        String codigoEliminar = scanner.next();
		        
		        boolean eliminado = efemerides.removeIf(efemeride -> efemeride.getCodigo().equals(codigoEliminar));
		        
		        if (eliminado) {
		            System.out.println("Efeméride eliminada correctamente.");
		        } else {
		            System.out.println("No se encontró una efeméride con ese código.");
		        }
		    }
		}

		private static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		    if (efemerides.isEmpty()) {
		        System.out.println("No hay efemérides para modificar.");
		    } else {
		        System.out.println("Ingrese el código de la efeméride a modificar:");
		        String codigoModificar = scanner.next();
		        
		        for (Efemeride efemeride : efemerides) {
		            if (efemeride.getCodigo().equals(codigoModificar)) {
		                System.out.println("Ingrese el nuevo mes (número del 1 al 12):");
		                int mesNum = scanner.nextInt();
		                while (mesNum < 1 || mesNum > 12) {
		                    System.out.println("Número de mes inválido. Ingrese un número del 1 al 12:");
		                    mesNum = scanner.nextInt();
		                }
		                Mes nuevoMes = Mes.values()[mesNum - 1];
		                efemeride.setMes(nuevoMes);
		                
		                System.out.println("Ingrese el nuevo día:");
		                int nuevoDia = scanner.nextInt();
		                efemeride.setDia(nuevoDia);
		                
		                System.out.println("Ingrese el nuevo detalle:");
		                scanner.nextLine(); // Limpiar el buffer
		                String nuevoDetalle = scanner.nextLine();
		                efemeride.setDetalle(nuevoDetalle);
		                
		                System.out.println("Efeméride modificada exitosamente.");
		                return;
		            }
		        }
		        
		        System.out.println("No se encontró una efeméride con ese código.");
		    }
		}
}

