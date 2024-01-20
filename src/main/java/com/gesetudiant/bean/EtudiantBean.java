/**
 * 
 */
package com.gesetudiant.bean;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 
 */
@Named
@RequestScoped
public class EtudiantBean {
	private Etudiant etudiant;
	//private boolean modifiable;
	
	private List<Etudiant> listeEtudiant;
	
	public EtudiantBean() {
		// On va instancier classe etudiant
		etudiant = new Etudiant();
	}
	
	
	/**
	 * @return the modifiable
	 */
	/*public boolean isModifiable() {
		return modifiable;
	}*/


	/**
	 * @param modifiable the modifiable to set
	 */
	/*public void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
	}*/


	// La methode pour ajouter un étudiant
	public String addEtudiant(Etudiant e) {
		try {
			//choisir notre driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// On va se connecter à la base de données
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_crudjsf", "root", "");
			
			// On va définir notre requete
			String req = "INSERT INTO etudiant(prenom,nom,ville) VALUES(?,?,?)";
			
			// On va preparer notre requete
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(req);
			
			//On va renseigner nos parametres dans la requete
			ps.setString(1, e.getPrenom());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getVille());
			
			// On va executer notre requete
			ps.execute();
			
			etudiant = new Etudiant();
			
			return "liste";
	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return "";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "";
		}
	}
	
	// Methode pour supprimer un étudiant
	public String deleteEtudiant(Etudiant e) {
		System.out.println("Suppression de l'étudiant "+e.getIdEtudiant());
		try {
			//choisir notre driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// On va se connecter à la base de données
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_crudjsf", "root", "");
			
			// On va définir notre requete
			String req = "delete from etudiant where id = ?";
			
			// On va preparer notre requete
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(req);
			
			//On va renseigner nos parametres dans la requete
			ps.setInt(1, e.getIdEtudiant());
				
			// On va executer notre requete
			ps.execute();
			return "liste";
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return "";
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "";
		}
		
	}
	

	// Methode pour modifier un étudiant
	
	public void updateEtudiant(Etudiant e) {
		
		System.out.println("Mise à jour de l'étudiant "+e.getIdEtudiant());
	}
	
	public void chargerListeEtudiant() {
		listeEtudiant = new ArrayList<Etudiant>();
		
		try {
			//choisir notre driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// On va se connecter à la base de données
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_crudjsf", "root", "");
			
			// On va preparer notre requete
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM etudiant");
			
			// On va executer notre requete
			ResultSet rs = ps.executeQuery();
			
			// On va récuper la liste des étudiants
			while(rs.next()) {
				// on crée une instance Etudiant
				Etudiant e = new Etudiant();
				e.setIdEtudiant(rs.getInt("id"));
				e.setPrenom(rs.getString("prenom"));
				e.setNom(rs.getString("nom"));
				e.setVille(rs.getString("ville"));
				
				//Ajout de l'étudiant dans la liste des étudiant
				listeEtudiant.add(e);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}

	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	/**
	 * @return the listeEtudiant
	 */
	public List<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}

	/**
	 * @param listeEtudiant the listeEtudiant to set
	 */
	public void setListeEtudiant(List<Etudiant> listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}
	
	
}
