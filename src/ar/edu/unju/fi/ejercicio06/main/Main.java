package ar.edu.unju.fi.ejercicio06.main;
import ar.edu.unju.fi.ejercicio06.model.*;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FelinoDomestico gato = new FelinoDomestico("garfiel", (byte)45, 12f);
		//definición de expresión lambda que define el convertidor de FelinoDomestico a
		//FelinoSalvaje.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
		x.getEdad(), x.getPeso());
		//se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(gato);
		//mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);
		
		FelinoSalvaje gato2 = new FelinoSalvaje("Tunner", (byte)20, 186f);
		if (Converter.isNotNull(gato2)) {
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(),
		x.getEdad(), x.getPeso());
		//se realiza la conversión
		FelinoDomestico felino2 = converter2.convert(gato2);
		//mostramos los datos del objeto felino salvaje felino1
		converter2.mostrarObjeto(felino2);
		}
		else {
			System.out.println("El objeto es nulo");
		}
		

		
	}
}


