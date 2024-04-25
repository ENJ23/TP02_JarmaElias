package ar.edu.unju.fi.ejecicio01.model;

public class Producto {
		private String Codigo;
		private String descripcion;
		private Double PrecioU;
		private origenFabricacion origenFabricacion;
		private Categoria categoria;
		
		
		
		
		public Producto(String codigo, String descripcion, Double precioU, origenFabricacion origenFabricacion, Categoria categoria) {
			super();
			Codigo = codigo;
			this.descripcion = descripcion;
			PrecioU = precioU;
			this.origenFabricacion = origenFabricacion;
			this.categoria = categoria;
		}

		
		public String getCodigo() {
			return Codigo;
		}

		public void setCodigo(String codigo) {
			Codigo = codigo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Double getPrecioU() {
			return PrecioU;
		}

		public void setPrecioU(Double precioU) {
			PrecioU = precioU;
		}

		public origenFabricacion getOrigenFabricacion() {
			return origenFabricacion;
		}

		public void setOrigenFabricacion(origenFabricacion origenFabricacion) {
			this.origenFabricacion = origenFabricacion;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}


		public enum origenFabricacion {
			ARGENTINA, CHINA, BRASIL, URUGUAY

		}
		
		public enum Categoria {
			TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
		}

		@Override
		public String toString() {
			return "Producto [Codigo=" + Codigo + ", descripcion=" + descripcion + ", PrecioU=" + PrecioU
					+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + "]";
		}
		
		
}

	