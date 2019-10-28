package model;

public class Inert extends Residue
{
	// Atributes
	
	private String advice; 
	
	// Constructor
	
	/**
	*	Creates an instance of Inert residue
	* 	<b> pos: </b> A new Inert residue is created
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	* 	@param advice Advice of how to reduce the use of this residue
	* 	@param nociveEffect Nocive effect of the residue to the planet
	*	@param product Product that generates this residue
	*/
	public Inert(String id, String name, char precedence, String  color, 
	double decomposeTime,String advice, double nociveEffect, Product product)
	{
		super(id, name, precedence, color, decomposeTime, nociveEffect, product);
		
		this.advice = advice; 
		
	}
	
	// Methods
	
	/**
	*	Displays all the information about the residue
	*	<b> pre: </b> The residue must be instanciated
	* 	@return String Constains all the information of the residue
	*/
	@Override
	public String toString()
	{
		return super.toString() + "\nAdvice: " + advice; 
	}
}