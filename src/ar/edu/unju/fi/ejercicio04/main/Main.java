package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Jugador> listaJugadores = new ArrayList<>();
	        Scanner scanner = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("Menú:");
	            System.out.println("1 - Alta de jugador");
	            System.out.println("2 - Mostrar los datos del jugador");
	            System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
	            System.out.println("4 - Modificar los datos de un jugador");
	            System.out.println("5 - Eliminar un jugador");
	            System.out.println("6 - Mostrar la cantidad total de jugadores");
	            System.out.println("7 - Mostrar la cantidad de jugadores por nacionalidad");
	            System.out.println("8 - Salir");
	            System.out.print("Ingrese una opción: ");
	            opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    altaJugador(listaJugadores, scanner);
	                    break;
	                case 2:
	                    mostrarJugadoresOrdenados(listaJugadores);
	                    break;
	                case 3:
	                    eliminarJugador(listaJugadores, scanner);
	                    break;
	                case 4:
	                    modificarPosicionJugador(listaJugadores, scanner);
	                    break;
	  
	                case 5:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Inténtelo de nuevo.");
	            }

	        } while (opcion != 8);
	    }

	    public static void altaJugador(ArrayList<Jugador> listaJugadores, Scanner scanner) {
	        try {
	            System.out.println("Ingrese los datos del nuevo jugador:");

	            System.out.print("Nombre: ");
	            String nombre = scanner.next();

	            System.out.print("Apellido: ");
	            String apellido = scanner.next();

	            System.out.print("Fecha de nacimiento (formato dd-MM-yyyy): ");
	            String fechaNacimientoStr = scanner.next();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

	            System.out.print("Nacionalidad: ");
	            String nacionalidad = scanner.next();

	            System.out.print("Estatura: ");
	            double estatura = scanner.nextDouble();

	            System.out.print("Peso: ");
	            double peso = scanner.nextDouble();

	            System.out.print("Posición (delantero, medio, defensa, arquero): ");
	            Posicion posicion = scanner.next();

	            Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	            listaJugadores.add(nuevoJugador);

	            System.out.println("¡Jugador añadido con éxito!");
	        } catch (DateTimeParseException e) {
	            System.out.println("Error al convertir la fecha. Inténtalo de nuevo y asegúrate de ingresarla en el formato correcto (dd-MM-yyyy).");
	        } catch (InputMismatchException e) {
	            System.out.println("Error al ingresar un valor numérico. Intentalo de nuevo y asegúrate de ingresar un número válido.");
	        } catch (Exception e) {
	            System.out.println("Ha ocurrido un error al ingresar los datos del jugador. Por favor, inténtalo de nuevo.");

	        } finally {
	            System.out.println("Operación completada.");
	        }
	    }

	    public static void mostrarDatosJugador(ArrayList<Jugador> listaJugadores, Scanner scanner) {
	        System.out.print("Ingrese nombre del jugador: ");
	        String nombre = scanner.next();
	        System.out.print("Ingrese apellido del jugador: ");
	        String apellido = scanner.next();

	        for (Jugador jugador : listaJugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                System.out.println("Datos del jugador:");
	                System.out.println("Nombre: " + jugador.getNombre());
	                System.out.println("Apellido: " + jugador.getApellido());
	                System.out.println("Fechan de nacimiento: "+jugador.getFechaNacimiento());
	                System.out.println("Peso del jugador: "+jugador.getPeso());
	                System.out.println("Estatura del jugador: "+jugador.getEstatura());
	                System.out.println("Nacionalidad: "+jugador.getNacionalidad());
	                System.out.println("Posicion: "+jugador.getPosicion());
	                
	                return;
	            }
	        }
	        System.out.println("Jugador no encontrado.");
	    }

	    public static void mostrarJugadoresOrdenados(ArrayList<Jugador> listaJugadores) {
	        Collections.sort(listaJugadores, (j1, j2) -> j1.getApellido().compareToIgnoreCase(j2.getApellido()));
	        for (Jugador jugador : listaJugadores) {
	            System.out.println(jugador.getApellido() + ", " + jugador.getNombre());
	        }
	    }

	    public static void modificarPosicionJugador(ArrayList<Jugador> listaJugadores, Scanner scanner) {
	        System.out.print("Ingrese nombre del jugador a modificar: ");
	        String nombre = scanner.next();
	        System.out.print("Ingrese apellido del jugador a modificar: ");
	        String apellido = scanner.next();

	        boolean encontrado = false;

	        for (Jugador jugador : listaJugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                System.out.println("Datos actuales del jugador:");
	                System.out.println(jugador);

	                System.out.println("Ingrese los nuevos datos:");

	                System.out.print("Nuevo nombre: ");
	                String nuevoNombre = scanner.next();
	                jugador.setNombre(nuevoNombre);

	                System.out.print("Nuevo apellido: ");
	                String nuevoApellido = scanner.next();
	                jugador.setApellido(nuevoApellido);

	                System.out.print("Nueva fecha de nacimiento (formato dd-MM-yyyy): ");
	                String nuevaFechaNacimientoStr = scanner.next();
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	                LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoStr, formatter);
	                jugador.setFechaNacimiento(nuevaFechaNacimiento);

	                System.out.print("Nueva nacionalidad: ");
	                String nuevaNacionalidad = scanner.next();
	                jugador.setNacionalidad(nuevaNacionalidad);

	                System.out.print("Nueva estatura: ");
	                double nuevaEstatura = scanner.nextDouble();
	                jugador.setEstatura(nuevaEstatura);

	                System.out.print("Nuevo peso: ");
	                double nuevoPeso = scanner.nextDouble();
	                jugador.setPeso(nuevoPeso);

	                System.out.print("Nueva posición (delantero, medio, defensa, arquero): ");
	                String nuevaPosicion = scanner.next();
	                jugador.setPosicion(nuevaPosicion);

	                System.out.println("¡Datos modificados con éxito!");
	                encontrado = true;
	                break;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("Jugador no encontrado.");
	        }
	    }

	    public static void eliminarJugador(ArrayList<Jugador> listaJugadores, Scanner scanner) {
	        System.out.print("Ingrese nombre del jugador a eliminar: ");
	        String nombre = scanner.next();
	        System.out.print("Ingrese apellido del jugador a eliminar: ");
	        String apellido = scanner.next();

	        Iterator<Jugador> iterator = listaJugadores.iterator();
	        while (iterator.hasNext()) {
	            Jugador jugador = iterator.next();
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                iterator.remove();
	                System.out.println("Jugador eliminado con éxito.");
	                return;
	            }
	        }
	        System.out.println("Jugador no encontrado.");
	    }

	    public static void mostrarCantidadTotalJugadores(ArrayList<Jugador> listaJugadores) {
	        System.out.println("Cantidad total de jugadores: " + listaJugadores.size());
	    }

	    public static void mostrarCantidadJugadoresPorNacionalidad(ArrayList<Jugador> listaJugadores, Scanner scanner) {
	        System.out.print("Ingrese la nacionalidad a buscar: ");
	        String nacionalidad = scanner.next();
	        int count = 0;
	        for (Jugador jugador : listaJugadores) {
	            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
	                count++;
	            }
	        }
	        System.out.println("Cantidad de jugadores de la nacionalidad " + nacionalidad + ": " + count);
	    }
	}


