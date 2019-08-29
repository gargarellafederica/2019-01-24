package it.polito.tdp.extflightdelays.model;

public class Uscenti implements Comparable<Uscenti>{
	private String stato;
	private int peso;
	
	public Uscenti(String stato,int peso) {
		super();
		this.stato = stato;
		this.peso = peso;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "\nStato= " + stato+ " peso= " + peso;
	}
	
	@Override
	public int compareTo(Uscenti usc) {
		return Integer.compare(usc.getPeso(),this.peso);
	}

}
