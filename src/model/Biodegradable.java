package model;

public class Biodegradable extends Residue
{
	// Atributes
	private boolean isCompostable;
	private boolean isUsable;
	
	// Constructor
	
	/**
	*	Creates an instance of biodegradable residue
	* 	<b> pos: </b> A new biodegradable residue is created
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	* 	@param isCompostable True if the residue is compostable
	* 	@param nociveEffect Nocive effect of the residue to the planet
	*	@param product Product that generates this residue
	*/
	public Biodegradable(String id, String name, char precedence, String  color, double decomposeTime,
    boolean isCompostable, double nociveEffect, Product product)
	{
		super(id, name, precedence, color, decomposeTime, nociveEffect, product);
		this.isCompostable = isCompostable;
		this.isUsable = isUsable();
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
		return super.toString() + "\nCompostable: " + isCompostable + "\nIs Usable: " + isUsable; 
	}
	
	/**
	*	Determinas if a the residue is usable or not
	* 	<b> pre: </b> The residue must be instanciated
	* 	@return boolean True if the residue is usable
	*/
	public boolean isUsable()
	{
		boolean isUsable = false;
		
		if(super.getDecomposeTime() < 365 && this.isCompostable == true)
		{
			isUsable = true;
		}
		
		return isUsable;
	}
	
	//Getters
	
	/**
	*	Gets the value of isUsable of the residue
	* 	<b> pre: </b> the residue must be instanciated
	*	@return boolean value of the variable isUsable
	*/
	public boolean getIsUsable()
	{
		return isUsable;
	}
}