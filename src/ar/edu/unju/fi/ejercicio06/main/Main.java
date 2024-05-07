package ar.edu.unju.fi.ejercicio06.main;
import ar.edu.unju.fi.ejercicio06.model.*;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FelinoDomestico gato = new FelinoDomestico();
        gato.setNombre("Tanner");
        gato.setEdad((byte) 20);
        gato.setPeso(186);

		
		
		
		
		
		FelinoSalvaje leon = new FelinoSalvaje();
        leon.setNombre("Tanner");
        leon.setEdad((byte) 20);
        leon.setPeso(186);

        // Verificar si el objeto a convertir no es nulo utilizando el método estático isNotNull()
        if (Converter.isNotNull(leon)) {
            // Definición de la expresión lambda que convierte FelinoSalvaje a FelinoDomestico
            Converter<FelinoSalvaje, FelinoDomestico> converter = x -> {
                FelinoDomestico felinoDomestico = new FelinoDomestico();
                felinoDomestico.setNombre(x.getNombre());
                felinoDomestico.setEdad(x.getEdad());
                felinoDomestico.setPeso(x.getPeso());
                return felinoDomestico;
            };

            // Realizar la conversión
            FelinoDomestico leonDomestico = converter.convert(leon);

            // Mostrar los datos del objeto FelinoDomestico
            converter.mostrarObjeto(leonDomestico);
        } else {
            System.out.println("El objeto a convertir es nulo.");
        }
    }

		
	}


