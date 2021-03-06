package amortissements;

/**
 * Ligne du tableau d'amortissement d'un crédit.
 */

public class Ligne 
{
	/**
	 * Crée une ligne à partir des valeurs passées en paramètres.
	 */
	private int annee;
	private double capitalInitial;
	private double interets;
	private double amortissements;
	private double annuite;
	private double capitalFinal;
	
	private Ligne(int annee, double capitalInitial, double interets, 
			double amortissements, double annuite, double capitalFinal)
	{
		this.annee = annee;
		this.capitalInitial = capitalInitial;
		this.interets = interets;
		this.amortissements= amortissements;
		this.annuite = annuite;
		this.capitalFinal = capitalFinal;
	}

	/**
	 * Retourne l'indice de l'année concernée par la ligne.
	 * Les indices commencent à 1.
	 */
	
	public int getAnnee()
	{
		return annee;
	}
	
	/**
	 * Retourne le montant du capital restant dû au début 
	 * de la période.
	 */
	
	public double getCapitalInitial()
	{
		return capitalInitial;
	}
	
	/**
	 * Retourne le montant des intérêts versés pendant la période.
	 */
	
	public double getInterets()
	{
		return interets;
	}

	/**
	 * Retourne le montant du capital amorti pendant la période.
	 */
	
	public double getAmortissements()
	{
		return amortissements;
	}

	/**
	 * Retourne le montant de l'annuité pendant la période.
	 */
	
	public double getAnnuite()
	{
		return annuite;
	}
	
	/**
	 * Retourne le montant du capital restant dû à la fin
	 * de la période.
	 */
	
	public double getCapitalFinal()
	{
		return capitalFinal;
	}
	
	/**
	 * Retourne la première ligne du tableau d'amortissement pour
	 * le crédit passé en paramètre.
	 */
	
	public static Ligne premiereLigne(Credit credit)
	{
		double amortissement;
		double interet = credit.montantEmprunte() * credit.taux();
		if (credit.typeCredit() == Credit.AMORTISSEMENT_CONSTANTS)
		{
			amortissement = credit.montantEmprunte()/credit.duree();
			
					
		}
		else
		{
			amortissement = credit.annuiteMaximale()-(credit.montantEmprunte()/credit.taux());
		}
		return new Ligne (1,
				credit.montantEmprunte(), 
				interet,
				amortissement,
				credit.annuiteMaximale(),
				credit.montantEmprunte() - amortissement);
	}

	/**
	 * Retourne la ligne suivant la ligne courante pour le 
	 * passé en paramètre. Retoure null si la ligne courante est
	 * la dernière ligne.
	 */
	
	public Ligne ligneSuivante(Credit credit)
	{	
		double capitalInitial = this.getCapitalFinal();
		double interet = credit.taux()*capitalInitial;
		double amortissement;
		if(this.getAnnee()== credit.duree()) 
		{
			return null;
		}
		else
		{
				
			if (credit.typeCredit() == Credit.AMORTISSEMENT_CONSTANTS)
			{
				
				amortissement = credit.montantEmprunte()/credit.duree();
				return new Ligne (this.getAnnee()+1,credit.montantEmprunte(), 
						interet,
						amortissement,
						amortissement + interet,
						this.capitalFinal-amortissement);
						
			}
			else
			{
				amortissement = credit.annuiteMaximale()-(capitalInitial/100*credit.taux());
				double annuite = this.annuite;
				return new Ligne (this.getAnnee()+1,credit.montantEmprunte(), 
						interet,
						amortissement,
						amortissement + interet,
						this.capitalFinal-amortissement);
			}
		}
		
	}
	
	@Override
	public String toString() {
		String laLigne ="";
		return laLigne = ""+ getAnnee() + getCapitalInitial() + getAmortissements() + getAnnuite() + getCapitalInitial();
	}
}
