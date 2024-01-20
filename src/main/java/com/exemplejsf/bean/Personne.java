/**
 * 
 */
package com.exemplejsf.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * 
 */
@Named
@RequestScoped
public class Personne {
	private String nom;
	private String prenom;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
