package ui;

import model.*;
import java.util.Scanner;

public class Main
{
	//Associations
	
	private WasteCenter wasteCenter;
	private Scanner scNum;
	private Scanner scStr; 
	
	public static void main(String[] args)
	{
		// Inicialize main
		Main obj = new Main();
		
		// Creation of objects
		
		obj.createProduct("P1", "LAMP", "LIGHT SOURCE");
		obj.createResidue("R1", "POLVO",'D', "BLUE", 400, false, obj.wasteCenter.getProductByIndex(0));
		obj.createResidue("R2", "ASERRIN", 'I', "YELLOW", 256.5, false, obj.wasteCenter.getProductByIndex(0));
		
		
		//Menu 
		obj.menu(obj);  
		
	}
	
	public Main()
	{
		wasteCenter = new WasteCenter("RECICLAMOS");
		scNum = new Scanner(System.in);
		scStr = new Scanner(System.in);
	}
	
	public void menu(Main obj)
	{
		
		boolean menu = true;
		int input = 0;
		
		while(menu)
		{
			System.out.println("--- MENU --- \n1: Create a product \n2: Create a residue " +
			"\n3: Generate residues report \n4: Search residues by name" +
			"\n5: Search residue by product Id \n6: Display product list" + 
			"\n7: List residues by nocive effect \n8: Exit");
			
			input = scNum.nextInt();
			
			switch(input)
			{
				case 1: 
					obj.createProduct(); 
					break;
				case 2:
					obj.createResidue(obj); 
					break;
				case 3: 
					obj.residueReport();
					break;
				case 4:
					obj.searchResidueByName();
					break;
				case 5:
					obj.displayProductNameId();
					obj.searchResidueByProductId();
					break;
				case 6:
					obj.displayProductList();
					break;
				case 7:
					obj.listResiduesByNociveEffect();
					break; 
				case 8: 
					System.out.println("The program has finished");
					menu = false;
					break;
				default:
					System.out.println("Digit a valid option");
					break;
				
			}
			
		}
	}
	

	
	public void createProduct(String id, String name, String description)
	{
		wasteCenter.createProduct(id, name, description);
		
	}
	
	public void createProduct()
	{
		
		System.out.println("Product name:");
		String name = scStr.nextLine();
		
		System.out.println("Product Id:");
		String id = scStr.nextLine();
		
		System.out.println("Product description:");
		String description = scStr.nextLine();
		
		String output = wasteCenter.createProduct(id, name, description);
		
		System.out.println(output);
		
	}
	
	public void createResidue(String id, String name, char precedence, String color, 
	double decomposeTime, boolean isCompostable, Product product)
	{
		wasteCenter.createResidue(id, name, precedence, color, decomposeTime, isCompostable, product);
	}
	
	public void createResidue(Main obj)
	{
		
		
		if(!wasteCenter.isProduct())
		{
			System.out.println("\nError: Create a product first");
			obj.createProduct();
		} else
		{
		
			System.out.println("Residue Id:");
			String id = scStr.nextLine();
			
			System.out.println("Residue Name:");
			String name = scStr.nextLine();
			
			System.out.println("Residue Precedence: ");
			System.out.println("1: Industrial \n2: Domiciliary \n3: Municipal \n4: Construction" +
			"\n5: Hospitalary");
			int input = scNum.nextInt();
			char precedence = 'A';
			switch(input)
			{
				case 1: 
					precedence = Residue.INDUSTRIAL;
					break;
				case 2: 
					precedence = Residue.DOMICILIARY;
					break;
				case 3:
					precedence = Residue.MUNICIPAL;
					break;
				case 4: 
					precedence = Residue.CONSTRUCTION;
					break;
				case 5: 
					precedence = Residue.HOSPITALARY;
					break;
				default: 
					System.out.println("Digit a valid option");
			}
			
			System.out.println("Residue Color:");
			String color = scStr.nextLine();
			
			System.out.println("Residue Decompose time:");
			double decomposeTime = scNum.nextDouble();
			
			System.out.println("Residue Product: " + wasteCenter.displayProductList());
			input = scNum.nextInt();
			Product product = wasteCenter.getProductByIndex(input);
			
			System.out.println("Type of residue: \n1: Biodegradable \n2: Inert \n3: Recyclable");
			input = scNum.nextInt();
			String output = ""; 
			switch(input)
			{
				case 1: //Biodegradable
					System.out.println("Is it compostable? \n1: True \n2: False");
					boolean isCompostable = false;
					input = scNum.nextInt();
					switch(input)
					{
						case 1: 
							isCompostable = true;
							break;
						case 2:
							isCompostable = false;
							break;
					}
		
					output = wasteCenter.createResidue(id, name, precedence, color, 
					decomposeTime, isCompostable, product);
					
					break;
				case 2: //Inert
					System.out.println("Residue Advice:");
					String advice = scStr.nextLine();
					
					output = wasteCenter.createResidue(id, name, precedence, color, 
					decomposeTime, advice, product);
					
					System.out.println(output);
					
					
					break;
				case 3: //Recyclable
					
					System.out.println("Residue type: \n1:Paper \n2: Paperboard \n3: Glass " +
					"\n4: Metal \n5: Plastic");
					input = scNum.nextInt();
					char type = 'A'; 
					switch(input)
					{
						case 1: 
							type = Recyclable.PAPER;
							break;
						case 2: 
							type = Recyclable.PAPERBOARD;
							break;
						case 3: 
							type = Recyclable.GLASS;
							break;
						case 4:
							type = Recyclable.METAL;
							break;
						case 5:
							type = Recyclable.PLASTIC;
							break;
					}
					
					System.out.println("Residue Home Description: ");
					String homeDescription = scStr.nextLine();
					
					System.out.println("Residue Industrial Description");
					String industrialDescription = scStr.nextLine();
					
					output = wasteCenter.createResidue(id, name, precedence, color, 
					decomposeTime, type, homeDescription, industrialDescription, product);
					
					System.out.println(output);
					
					break;
			}
			
			System.out.println(output);
			
		}
		
	}
	
	public void residueReport()
	{
		String report = wasteCenter.residueReport();
		
		System.out.println(report);
		
	}
	
	public void searchResidueByName()
	{
		System.out.println("Residue name:");
		String name = scStr.nextLine();
		
		System.out.println(wasteCenter.searchResidueByName(name));
		
		
	}
	
	public void searchResidueByProductId()
	{
		System.out.println("Product Id:");
		String id = scStr.nextLine();
		
		String info = wasteCenter.searchResidueByProductId(id);
		System.out.println(info);
		
	}
	
	public void displayProductList()
	{
		System.out.println(wasteCenter.displayProductList());
		
	}
	
	public void listResiduesByNociveEffect()
	{
		System.out.println(wasteCenter.listResiduesByNociveEffect());
		
	}
	
	public void displayProductNameId()
	{
		System.out.println(wasteCenter.displayProductNameId());
		
	}
	
}
