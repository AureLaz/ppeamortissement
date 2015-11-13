package amortissements;
import java.lang.Math;

/**
 * ReprÃ©sente un crÃ©dit.
 */

public class Credit 
{
	public final static int AMORTISSEMENT_CONSTANTS = 1,
			ANNUITES_CONSTANTES = 2;
	
	private int typeCredit;
	private double montantEmprunte;
	private double annuiteMaximale;
	private double taux;
	private double duree;

	/**
	 * CrÃ©Ã©e un crÃ©dit.
	 */
	
	Credit (int typeCredit, double montantEmprunte, double annuiteMaximale,
			double taux, double duree)
	{
		this.typeCredit = typeCredit;
		this.montantEmprunte = montantEmprunte;
		this.annuiteMaximale = annuiteMaximale;
		this.taux = taux;
		this.duree = duree;
	}
	
	/**
	 * RetournÃ© le montant empruntÃ©.
	 */
	
	public double montantEmprunte()
	{
		return montantEmprunte;
	}
	
	/**
	 * Retourne le montant de la plus grande annuitÃ©. 
	 */
	
	public double annuiteMaximale()
	{
		return annuiteMaximale;
	}
	
	/**
	 * Retourne le taux du crÃ©dit.
	 */
	
	public double taux()
	{
		return taux;
	}
	
	/**
	 * Retourne nombre d'annuitÃ©s Ã  verser.
	 */
	
	public double duree()
	{
		return duree;
	}
	
	/**
	 * Retourne le tableau d'amortissement du crÃ©dit.
	 */
	
	public TableauAmortissement getTableauAmortissement()
	{
		return null;
	}
	
	/**
	 * Retourne un crÃ©dit en calculant automatiquement le taux.
	 */
	
	
	public static Credit calculeTaux(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double duree)
	{
		double amortissement = montantEmprunte / duree;
		double interet;
		double res = 0;
		double annuiteMaximale2 = annuiteMaximale;
		if (typeCredit == 1)
		{
			interet = annuiteMaximale - amortissement;
			res = interet/montantEmprunte;
		}
		else
		{
			
		}
		Credit C = new Credit(typeCredit, montantEmprunte, annuiteMaximale, res,duree);
		return C;
	}
	
	/**
	 * Retourne un crÃ©dit en calculant automatiquement la durÃ©e.
	 */
	
	public static Credit calculeDuree(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double taux)
	{
		double res = 0;
		double amortissement;
		double interet = montantEmprunte * taux; 
		if (typeCredit == 1)
		{
			amortissement = annuiteMaximale - interet;
			res = montantEmprunte/amortissement;
			
		}
		else
		{
			;
		}
		Credit C = new Credit(typeCredit, montantEmprunte, annuiteMaximale, taux,res);
		return C;
	}

	/**
	 * Retourne un crÃ©dit en calculant automatiquement le montant
	 * 	qu'il est possible d'emprunter.
	 */
	
	public static Credit calculeMontantEmprunte(int typeCredit, 
			double annuiteMaximale,	double taux, int duree)
	{
		double res = 0; 
		if (typeCredit == 1)
		{
			res = annuiteMaximale/(1/duree + taux);
			
		}
		else
		{
			;
		}
		Credit C = new Credit(typeCredit, res, annuiteMaximale, taux, duree);
		return C;
	}

	/**
	 * Retourne un crÃ©dit en calculant automatiquement
	 * l'annuitÃ© maximale.
	 */
	
	public static Credit calculeAnnuiteMaximale(int typeCredit, 
			double montantEmprunte,	double taux, double duree)
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
