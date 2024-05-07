package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaz.Pago;

public class PagoTarjeta implements Pago {
	
	    private String numeroTarjeta;
	    private LocalDate fechaPago;
	    private double montoPagado;

	    public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago) {
	        this.numeroTarjeta = numeroTarjeta;
	        this.fechaPago = fechaPago;
	    }

	    public void realizarPago(double monto) {
	        this.montoPagado = monto + (monto * 0.15); // 15% de recarga
	    }

	    public void imprimirRecibo() {
	        System.out.println("Número de tarjeta: " + numeroTarjeta);
	        System.out.println("Fecha de pago: " + fechaPago);
	        System.out.println("Monto pagado: " + montoPagado);
	    }
	}



