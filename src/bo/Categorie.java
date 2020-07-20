package bo;

import java.io.Serializable;

public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int no_categorie;
	
	private String libelle;
	
	
	/* CONSTRUCTEURS */
	
	public Categorie() {
		
	}
	
	public Categorie(int id) {
		this.no_categorie = id;
	}
	
	public Categorie(String lib) {
		this.libelle = lib;
	}
	
	public Categorie(int id, String lib) {
		this.no_categorie = id;
		this.libelle = lib;
	}
	
	/* GETTERS AND SETTERS */

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
