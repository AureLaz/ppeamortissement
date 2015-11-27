package amortissements;
import java.lang.Math;

/**
 * Représente un crédit.
 */

public class Credit 
{
	public final static int AMORTISSEMENT_CONSTANTS = 1,
			ANNUITES_CONSTANTES = 2;
	
	private int typeCredit;
	private double montantEmprunte;
	private double annuiteMaximale;
	private double taux;
	private int duree;

	/**
	 * Crée un crédit.
	 */
	
	Credit (int typeCredit, double montantEmprunte, double annuiteMaximale,
			double taux, int duree)
	{
		this.typeCredit = typeCredit;
		this.montantEmprunte = montantEmprunte;
		this.annuiteMaximale = annuiteMaximale;
		this.taux = taux;
		this.duree = duree;
	}
	
	/**
	 * Retourne le montant emprunté.
	 */
	
	public double montantEmprunte()
	{
		return montantEmprunte;
	}
	
	/**
	 * Retourne le montant de la plus grande annuité. 
	 */
	
	public double annuiteMaximale()
	{
		return annuiteMaximale;
	}
	
	/**
	 * Retourne le taux du crédit.
	 */
	
	public double taux()
	{
		return taux;
	}
	
	/**
	 * Retourne nombre d'annuités à  verser.
	 */
	
	public int duree()
	{
		return duree;
	}
	
	public int typeCredit()
	{
		return typeCredit;
	}
	/**
	 * Retourne le tableau d'amortissement du crédit.
	 */
	
	public TableauAmortissement getTableauAmortissement()
	{
		return new TableauAmortissement (this);
	}
	
	/**
	 * Retourne un crédit en calculant automatiquement le taux.
	 */
	
	
	public static Credit calculeTaux(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			int duree)
	{
		double amortissement = montantEmprunte / duree;
		double interet;
		double res = 0;
		if (typeCredit == 1)
		{
			interet = annuiteMaximale - amortissement;
			res = interet/montantEmprunte;
		}
		else
		{
			;
		}
		Credit C = new Credit(typeCredit, montantEmprunte, annuiteMaximale, res,duree);
		return C;
	}
	
	/**
	 * Retourne un crédit en calculant automatiquement la durée.
	 */
	
	public static Credit calculeDuree(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double taux)
	{
		double res = 0;
		int duree = 0;
		double amortissement;
		double interet = montantEmprunte * taux; 
		if (typeCredit == 1)
		{
			amortissement = annuiteMaximale - interet;
			res = montantEmprunte/amortissement;
			duree = (int)Math.ceil(res);
			
		}
		else
		{
			;
		}
		Credit C = new Credit(typeCredit, montantEmprunte, annuiteMaximale, taux,duree);
		return C;
	}

	/**
	 * Retourne un crédit en calculant automatiquement le montant
	 * 	qu'il est possible d'emprunter.
	 */
	
	public static Credit calculeMontantEmprunte(int typeCredit, 
			double annuiteMaximale,	double taux, int duree)
	{
		double res = 0; 
		if (typeCredit == 1)
		{
			res = annuiteMaximale/(1/(duree + taux));
			
		}
		else
		{
			;
		}
		Credit C = new Credit(typeCredit, res, annuiteMaximale, taux, duree);
		return C;
	}

	/**
	 * Retourne un crédit en calculant automatiquement
	 * l'annuité maximale.
	 */
	
	public static Credit calculeAnnuiteMaximale(int typeCredit, 
			double montantEmprunte,	double taux, int duree)
	{
		double res = 0;
		double amortissement;
		double interet = montantEmprunte * taux; 
		if (typeCredit == 1)
		{
			amortissement = montantEmprunte / duree;
			res = amortissement + interet;
			
		}
		else
		{
			;
		}
		Credit C = new Credit(typeCredit, montantEmprunte, res, taux,duree);
		return C;
	}
}
