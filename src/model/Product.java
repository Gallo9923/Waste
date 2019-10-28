package model;

public class Product
{
	
	// Atributes
	
	private String id;
	private String name;
	private String description; 
	
	// Associations
	private Residue[] residues; 
	
	
	// Constructor
	
	/**
	*	Creates a new product
	* 	<b> pos: </b> A new product is instanciated
	* 	@param id Id of the product
	*	@param name Name of the product
	*	@param description Description of the product
	*/
	public Product(String id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		
		residues = new Residue[3];
	}
	
	// Methods
	
	/**
	*	Displays all the information about the residue
	*	<b> pre: </b> The residue must be instanciated
	* 	@return String Constains all the information of the residue
	*/
	public String toString()
	{
		return "Id: " + id + "\nName: " + name + "\nDescription: " + description;
	}
	
	/**
	*	Updates the association residues of the class Product with a new residue
	* 	<b> pre: </b> The association residue must be initialized 
	* 	@param residue The residue to update
	*/
	public void addResidue(Residue residue)
	{
		boolean addResidue = false; 
		
		for(int i=0; i<residues.length && !addResidue; i++)
		{
			Residue obj = residues[i];
			if(obj == null)
			{
				residues[i] = residue;
				addResidue = true; 
			}
		}
		
	}
	
	/**
	*	Checks if the array is full
	* 	<b> pre: </b> The array residues must be initialized
	* 	@return boolean True if the array is not full
	*/
	public boolean isSpace()
	{
		boolean isSpace = false;  //Array is full
		
		for(int i=0; i<residues.length && !isSpace; i++)
		{
			if(residues[i] == null)
			{
				isSpace = true;
			}
		}
		
		return isSpace;
	}
	
	// Getters
	
	/**
	* 	Gets the array residues of the product
	*	<b> pre: </b> the array residues must be initialized
	*	@return Residue[] Array of residues
	*/
	public Residue[] getResidues()
	{
		return this.residues;
	}
	
	/**
	* 	Gets the name of the product
	*	@return String Name of the product
	*/
	public String getName()
	{
		return this.name;
	}
	
	/**
	* 	Gets the id of the product
	*	@return String Id of the product
	*/
	public String getId()
	{
		return id; 
	}
	
}