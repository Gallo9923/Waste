package model;

public class WasteCenter
{
	// Atributes
	
	private String name;
	
	// Associations
	
	private Product[] products;
	private Residue[] residues;
	
	// Constructor 
	
	/**
	*	Create a new Waste CenterLayout
	* 	<b> pos: </b> A new WasteCenter is instanciated
	* 	@param name Name of the Waste Center
	*/
	public WasteCenter(String name)
	{
		this.name = name; 
		
		products = new Product[5];
		residues = new Residue[3];
		
	}
	
	// Methods
	
	/**
	*	Displays the name and id of all the products
	* 	<b> pre: </b> the array products must be initialized
	*	@return String Constains the name and id of all the created products
	*/
	public String displayProductNameId()
	{
		String ans = "";
		
		for(int i=0; i<products.length; i++)
		{
			if(products[i] != null)
			{
				ans += "Name: " + products[i].getName() + " Id: " + products[i].getId() + "\n";
			}
		}
		
		return ans;
	}
	
	
	/**
	*	Displays the list of all the residues in descending order by nocive effect
	*	<b> pre: </b> the array residues must be initialized
	* 	@return String Information about all the residues
	*/
	public String listResiduesByNociveEffect()
	{
		Residue[] sorted = residues; 
		
		double max = 0.0;
		int pos = 0;
		Residue auxiliary = null;
		
		
		for(int i=0; i<sorted.length; i++)
		{
			
			if(sorted[i] != null)
			{
				max = sorted[i].getNociveEffect();
				pos = i;
				
				for(int c=i+1; c<sorted.length; c++)
				{
					if(sorted[c] != null && sorted[c].getNociveEffect() > max)
					{
						max = sorted[c].getNociveEffect();
						pos = c;
					}
				}
				
				auxiliary = sorted[i];
				sorted[i] = sorted[pos];
				sorted[pos] = auxiliary;
			
			}
		}
		
		String ans = ""; 
		
		for(int b=0; b<sorted.length; b++)
		{
			if(sorted[b] != null)
			{
				ans += sorted[b].toString() + "\n \n";
			}
		}
		
		return ans;
		
	}
	
	
	/**
	*	Search a residue by it's product Id 
	*	<b> pre: </b>  Array products must be initialized
	* 	@param id Id of the residue product to look for
	*	@return String Information about the residue
	*/
	public String searchResidueByProductId(String id)
	{
		boolean found = false;
		String info = ""; 
		
		for(int i=0; i<products.length && !found; i++)
		{
			if(products[i] != null && products[i].getId().equalsIgnoreCase(id))
			{
				Residue[] residues = products[i].getResidues();
				
				found = true;
				
				for (int c=0; c<residues.length; c++)
				{
					if(residues[c] != null)
					{
						info += residues[c].toString() + "\n";
					}
				}
				
			}
		}
	
		return info;
	}
	
	/**
	*	Search a residue by  its name
	* 	<b> pre: </b> the array residues must be initialized
	*	@param name Name of the residue to look for
	* 	@return String Information about the residue to look for
	*/
	public String searchResidueByName(String name)
	{
		boolean found = false;
		String info = "";
		
		for(int i=0; i<residues.length && !found; i++)
		{
			if(residues[i]  != null && residues[i].getName().equalsIgnoreCase(name))
			{	
				info = residues[i].toString();
			}
		}
		
		if(found == false)
		{
			info += "Does not exist a residue by that name";
		}
		
		return info;
	}
	
	/**
	*	Generates a repoort of all the residues created
	*	<b> pre: </b> The array residues must be initialized
	*	@return String Information of all the residues in the report
	*/
	public String residueReport()
	{
		String report = "--- Biodegradable --- \n";
		int count = 1; 
		
		
		for(int i=0; i<residues.length; i++)
		{
			if(residues[i] != null && residues[i] instanceof Biodegradable)
			{
				
				report +=  count + ". " + residues[i].toString() + "\n"; 
				count++;
			}
		}
		
		report += "\n --- Recyclable ---";
		for(int i=0; i<residues.length; i++)
		{
			if(residues[i] != null && residues[i] instanceof Recyclable)
			{
				
				report += residues[i].toString() + "\n"; 
			}
		}
		
		report += "\n --- Inert ---";
		for(int i=0; i<residues.length; i++)
		{
			if(residues[i] != null && residues[i] instanceof Inert)
			{
				
				report += residues[i].toString() + "\n"; 
			}
		}
		
		return report; 
	}
	
	/**
	*	Gets a product by an index of its array
	* 	<b> pre: </b> The array products must be initialized\
	*	@param index Index of the array products
	*	@return Product Product to be returned
	*/
	public Product getProductByIndex(int index)
	{
		Product product = null;
		
		if(index < products.length && index >= 0)
		{
			product = products[index];
		}
		
		return product; 
	}
	
	/**
	*	Displays the list of all the products created
	* 	<b> pre: </b> The array products must be instanciated
	* 	@return String Names of all the products 
	*/
	public String displayProductList()
	{
		String list = ""; 
		
		for(int i=0; i<products.length; i++)
		{
			if(products[i] != null)
			{
				list += "\n" + i + ": " + products[i].getName();
			}
		}
		
		return list;
	}
	
	/**
	*	Creates a new product
	* 	<b> pos: </b> A new product is instanciated
	* 	@param id Id of the product
	*	@param name Name of the product
	*	@param description Description of the product
	*	@return String Status of the process
	*/
	public String createProduct(String id, String name, String description)
	{
		boolean createProduct = false; //not created
		String output = "";
		
		for(int i=0; i<products.length && !createProduct; i++)
		{
			if(products[i] == null)
			{
				products[i] = new Product(id, name, description);
				createProduct = true;
				output = "Product has been created";
			} 
		}
		
		if(createProduct == false)
		{
			output += "\nError: Not enough space for more products";
		}
		
		return output;
	}
	
	/**
	*	Checks if a the array products is empty
	*	<b> pre: </b> The array products must be initialized
	*	@return boolean True if the array is not empty
	*/
	public boolean isProduct()
	{
		boolean found = false; 
		
		for(int i=0; i<products.length && !found; i++)
		{
			if(products[i] != null)
			{
				found = true;
			}
		}
		return found;
		
	}
	
	/**
	*	Calculates the nocive effect based on its precedence
	*	@param precedence Precedence of the residue
	*	@return double Nocive effect of the residue
	*/
	public double nociveEffect(char precedence)
	{
		double nociveEffect = 0.0;
		
		if(precedence == Residue.INDUSTRIAL)
		{
			nociveEffect = Residue.I_FACTOR * 100; 
		}else if(precedence == Residue.DOMICILIARY)
		{
			nociveEffect = Residue.D_FACTOR * 100;
		}else if(precedence == Residue.CONSTRUCTION)
		{
			nociveEffect = Residue.C_FACTOR * 100;
		}else if(precedence == Residue.MUNICIPAL)
		{
			nociveEffect = Residue.M_FACTOR * 100;
		}else if(precedence == Residue.HOSPITALARY)
		{
			nociveEffect = Residue.H_FACTOR * 100;
		}
		
		return nociveEffect;
	}
	
	/**
	*	Checks if the association residues of Product with Residue has space 
	*	<b> pre: </b> The array residues must be initialized
	*	@param product Product of the association
	*	@return boolean True if the array has empty spaces
	*/
	public boolean productHasSpace(Product product)
	{
		Residue[] residues = product.getResidues();
		boolean hasSpace = false; 
		
		for(int i=0; i<residues.length && !hasSpace; i++)
		{
			if(residues[i] == null)
			{
				hasSpace = true;
			}
		}
		
		return hasSpace;
	}
	
	/**
	*	Creates an instance of biodegradable residue
	* 	<b> pos: </b> A new biodegradable residue is created and nociveEffect is calculated
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	* 	@param isCompostable True if the residue is compostable
	*	@param product Product that generates this residue
	* 	@return String Status of the process
	*/
	public String createResidue(String id, String name, char precedence, String color, 
	double decomposeTime, boolean isCompostable, Product product)
	{
		boolean createResidue = false; //Not created
		String output = "";
		
		if(!isProduct())
		{
			output += "\nError: Create a product first";
		} else if(isProduct() && !productHasSpace(product))
		{
			output += "\nError: The product has the maximum number of residues";
		}
		
		if(isProduct() && productHasSpace(product))
		{
			for(int i=0; i<residues.length && !createResidue; i++)
			{
				if(residues[i] == null)
				{
					double nociveEffect = nociveEffect(precedence);
					
					if(isCompostable)
					{
						nociveEffect -= Residue.BIO_COMPOST * 100;
					}
					
					
					residues[i] = new Biodegradable(id, name, precedence, color, 
					decomposeTime, isCompostable, nociveEffect, product);
					
					product.addResidue(residues[i]);
					createResidue = true;
					
					output += "A residue has been created successfully";
				}
			}
		}
		
		
	
		return output;
	}
	
	/**
	*	Creates an instance of Inert residue
	* 	<b> pos: </b> A new Inert residue is created and nociveEffect is calculated
	*	@param id Id of the residue
	*	@param name Name of the residue
	*	@param precedence Precedence of the residue
	*	@param color Color of the residue
	*	@param decomposeTime Time of decomposition of the residue
	* 	@param advice Advice of how to reduce the use of this residue
	*	@param product Product that generates this residue
	* 	@return String Status of the process
	*/
	public String createResidue(String id, String name, char precedence, String color,
	double decomposeTime, String advice, Product product)
	{
		
		
		boolean createResidue = false; //Not created
		String output = "";
		
		if(!isProduct())
		{
			output += "\nError: Create a product first";
		} else if(isProduct() && !productHasSpace(product))
		{
			output += "\nError: The product has the maximum number of residues";
		}
		
		if(isProduct() && productHasSpace(product))
		{
			for(int i=0; i<residues.length && !createResidue; i++)
			{
				if(residues[i] == null)
				{
					double nociveEffect = 0.0;
					nociveEffect = nociveEffect(precedence);
					
					residues[i] = new Inert(id, name, precedence, color, decomposeTime,
					advice, nociveEffect, product);
					
					product.addResidue(residues[i]);
					createResidue = true;
					
					output += "\nA residue has been created successfully";
				}
			}
		}
		
		
	
		return output;
	}
	
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
	*	@param product Product that generates this residue
	* 	@return String Status of the process
	*/
	public String createResidue(String id, String name, char precedence, String color, 
	double decomposeTime, char type, String homeDescription, 
	String industrialDescription, Product product)
	{
		
		boolean createResidue = false; //Not created
		String output = "";
		
		if(!isProduct())
		{
			output += "\nError: Create a product first";
		} else if(isProduct() && !productHasSpace(product))
		{
			output += "\nError: The product has the maximum number of residues";
		}
		
		if(isProduct() && productHasSpace(product)) 
		{
			for(int i=0; i<residues.length && !createResidue; i++)
			{
				if(residues[i] == null)
				{
					double nociveEffect = nociveEffect(precedence);
					
					nociveEffect -= Residue.RECYCLABLE * 100;
					
					
					residues[i] = new Recyclable(id, name, precedence, color, decomposeTime,
					type, homeDescription, industrialDescription, nociveEffect, product);
					
					product.addResidue(residues[i]);
					createResidue = true;
					
					output += "A residue has been created successfully";
				}
			}
		}
		
		
	
		return output;
	}
	
}