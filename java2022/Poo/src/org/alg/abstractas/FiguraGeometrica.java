package org.alg.abstractas;

public abstract class FiguraGeometrica {
	protected String tipoFigura;
	protected FiguraGeometrica(String tipoFigura) {
		this.tipoFigura = tipoFigura;
	}
	
	public abstract void dibujar();

	public String getTipoFigura() {
		return tipoFigura;
	}

	public void setTipoFigura(String tipoFigura) {
		this.tipoFigura = tipoFigura;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FiguraGeometrica [tipoFigura=");
		builder.append(tipoFigura);
		builder.append("]");
		return builder.toString();
	}

}
