package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio05.interfaz.*;

public class PagoEfectivo implements Pago {

	    private double montoPagado;
	    private LocalDate fechaPago;

	    public PagoEfectivo(LocalDate fechaPago) {
	        this.fechaPago = fechaPago;
	    }

		public void realizarPago(double monto) {
	        this.montoPagado = monto - (monto * 0.10); // 10% de descuento
	    }

	    public void imprimirRecibo() {
	        System.out.println("Fecha de pago: " + fechaPago);
	        System.out.println("Monto pagado: " + montoPagado);
	    }
	}

