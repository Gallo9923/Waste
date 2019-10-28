package model;

public class Recyclable extends Residue
{
	// Constants 
	
	public static final char PAPER = 'P';
	public static final char PAPERBOARD = 'B'; 
	public static final char GLASS = 'G'; 
	public static final char PLASTIC = 'P';
	public static final char METAL = 'M'; 
	
	// Atributes
	
	private char type;
	private String homeDescription;
	private String industrialDescription;
	private boolean isUsable; 	
	
	// Constructor
	
	/**
	*	Creates an instance of Recyclable residue
	* 	<b> pos: </b> A new recyclable residue is created
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	*	@param type Type of recyclable residue
	*	@param homeDescription Home description of the residue
	* 	@param industrialDescription Industrial description of the residue
	* 	@param nociveEffect Nocive effect of the residue to the planet
	*	@param product Product that generates this residue
	*/
	public Recyclable(String id, String name, char precedence, String  color, double decomposeTime, 
	char type, String homeDescription, String industrialDescription, double nociveEffect, 
	Product product)
	{
		super(id, name, precedence, color, decomposeTime, nociveEffect, product);
		
		this.type = type;
		this.homeDescription = homeDescription;
		this.industrialDescription = industrialDescription;
		this.isUsable = isUsable();
	}	
	
	//Methods
	
	/**
	*	Displays all the information about the residue
	*	<b> pre: </b> The residue must be instanciated
	* 	@return String Constains all the information of the residue
	*/
	@Override
	public String toString()
	{
		return super.toString() + "\nType: " + type + "\nHome Description: " + homeDescription
		+ "\nIndustrial Description: " + industrialDescription + "\nIs Usable: " + isUsable; 
		
	}
	
	/**
	*	Determinas if a the residue is usable or not
	* 	<b> pre: </b> The residue must be instanciated
	* 	@return boolean True if the residue is usable
	*/
	public boolean isUsable()
	{
		boolean isUsable = false;
		
		if(homeDescription.length() > 1 && industrialDescription.length() > 1)
		{
			isUsable = true;
		}
		
		return isUsable;
	}

}