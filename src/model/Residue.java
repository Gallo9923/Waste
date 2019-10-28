package model;

public class Residue
{
	// Constants
	
	public static final double DECOMPOSE_TIME = 1.0;
	public static final double RECYCLABLE = 0.02;
	public static final double BIO_COMPOST = 0.01;
	
	public static final double I_FACTOR = 0.10;
	public static final double D_FACTOR = 0.05;
	public static final double C_FACTOR = 0.08;
	public static final double M_FACTOR = 0.12;
	public static final double H_FACTOR = 0.15;
	
	public static final char INDUSTRIAL = 'I';
	public static final char DOMICILIARY = 'D';
	public static final char MUNICIPAL = 'M';
	public static final char CONSTRUCTION = 'C';
	public static final char HOSPITALARY = 'H'; 
	
	//Atributes
	
	private String id;
	private String name;
	private char precedence; 
	private String color; 
	private double decomposeTime;
	private double nociveEffect;
	
	// Associations
	
	private Product product;
	
	// Constructor
	
	/**
	*	Creates an instance of a residue
	* 	<b> pos: </b> A new residue is created
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	* 	@param nociveEffect Nocive effect of the residue to the planet
	*	@param product Product that generates this residue
	*/
	public Residue(String id, String name, char precedence, String  color, double decomposeTime, 
	double nociveEffect, Product product)
	{
		this.id = id;
		this.name = name;
		this.precedence = precedence;
		this.color = color;
		this.decomposeTime = decomposeTime;
		this.nociveEffect = nociveEffect;
		this.product = product; 
	}
	
	// Methods
	
	/**
	*	Creates an instance of a residue and updates the association
	* 	<b> pos: </b> A new residue is created
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	* 	@param nociveEffect Nocive effect of the residue to the planet
	*	@param product Product that generates this residue
	*/
	public void createResidue(String id, String name, char precedence, String  color, double decomposeTime, 
	double nociveEffect, Product product)
	{
		if(product.isSpace()) //Checks if there is space to create a new residue
		{
			Residue obj = new Residue(id, name, precedence, color, decomposeTime, nociveEffect, product);
		
			this.product.addResidue(obj);
		}
	}
	
	
	/**
	*	Displays all the information about the residue
	*	<b> pre: </b> The residue must be instanciated
	* 	@return String Constains all the information of the residue
	*/
	public String toString()
	{
		return "Id: " + id + "\nName: "+ name +"\nPrecedence: " + precedence +
		"\nDecompose Time: " + decomposeTime + "\nNocive Effect: " + nociveEffect;
	}
	
	//Getters
	
	public String getName()
	{
		return name;
	}
	
	public double getNociveEffect()
	{
		return nociveEffect;
	}
	
	public double getDecomposeTime()
	{
		return decomposeTime;
	}
}