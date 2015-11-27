package amortissements;

/**
 * Représente le tableau d'amortissement d'un crédit.
 */

public class TableauAmortissement 
{
	/**
	 * Crée le tableau d'amortissement du crédit passé en paramêtre.
	 */
	private Ligne [] tableauAmort;
	private int nbLignes;
	
	public TableauAmortissement(Credit credit)
	{
		nbLignes = credit.duree();
		Ligne[] tableauAmort = new Ligne[nbLignes];
	}
	
	/**
	 * Retourne la durée de l'amortissement.
	 */
	
	public int getNbLignes()
	{
		return nbLignes;
	}
	
	/**
	 * Retourne la i-Ã¨me ligne du tableau d'amortissement.
	 * Les indices commencent Ã  0.
	 */
	
	public Ligne getLigne(int i)
	{
		return tableauAmort[i-1];		
	}
	
	/**
	 * Retourne une représentation du tableau au format 
	 * chaîne de caractères.
	 */
	
	public String toString() {
		String leTableauAmortissement = "";
		for (int i = 0; i < tableauAmort.length; i++) {
			leTableauAmortissement += getLigne(i).toString();
		}
		return leTableauAmortissement;
	}
}
