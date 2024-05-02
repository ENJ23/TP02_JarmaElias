package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(1000000, 53223), // Valores inventados
    SALTA(1500000, 75432),
    TUCUMAN(1200000, 64321),
    CATAMARCA(800000, 42123),
    LA_RIOJA(600000, 31234),
    SANTIAGO_DEL_ESTERO(1300000, 68213);

	private int cantidadPoblacion;
    private int superficie;
	
	Provincia(int cantidadPoblacion, int superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }
}

