package VaTou;

import java.text.DecimalFormat;
import java.util.Vector;

/*
 * Cette classe sert à récupérer les résultats des différents traitements pour pouvoir les organiser en tableau 
 * et graphique
 * 
 */
public class Resultat_tableau {

	private Vector<Integer> nbr_feuilles = new Vector<Integer>();
	private Vector<Double> pourcentage_reussite = new Vector<Double>();

	public void affichage() {
		
		DecimalFormat df2 = new DecimalFormat(".##");

		 
		// affichage d'un tableau moche pour l'instant
		System.out.println(" nbr min de feuilles \t|% de réussite \t| ");
		for (int i = 0; i < nbr_feuilles.size(); i++) {
			System.out.println("|" + nbr_feuilles.get(i) + "\t\t\t|" + df2.format(pourcentage_reussite.get(i)) + "\t\t|");

		}
	}

	public Vector<Integer> getNbr_feuilles() {
		return nbr_feuilles;
	}

	public void setNbr_feuilles(Vector<Integer> nbr_feuilles) {
		this.nbr_feuilles = nbr_feuilles;
	}

	public Vector<Double> getPourcentage_reussite() {
		return pourcentage_reussite;
	}

	public void setPourcentage_reussite(Vector<Double> pourcentage_reussite) {
		this.pourcentage_reussite = pourcentage_reussite;
	}

}
