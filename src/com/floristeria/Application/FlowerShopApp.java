package com.floristeria.Application;

import java.util.*;

import com.floristeria.Domain.Deco;
import com.floristeria.Domain.Flower;
import com.floristeria.Domain.Material;
import com.floristeria.Domain.Product;
import com.floristeria.Domain.Tree;
import com.floristeria.Persistence.FlowerShopRepository;
import com.floristeria.View.Console;

public class FlowerShopApp {

	private static FlowerShopRepository repository;
	public static Scanner dataEntry;
	
	public static void main(String[] args){
		
		boolean moreActions = true;
		int valInput;

		createFlowerShop();

		try {
			loadData();
		} catch (NullValueException e) {
			System.out.println(e.getMessage());
		}
		getAllProducts();
		
		while(moreActions == true) {
			
			Console.showConsole();

			try {
				valInput = dataEntry.nextInt();
			} catch (Exception e)
				{
					dataEntry.next();
					valInput= 5;
				}

			
			switch(valInput) {
				case 0:		
					moreActions = false;
					exit();
					break;
				case 1:
					// 1 Add Tree	    			
					try {
						addTree();
					} catch (NullValueException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					// 2 Add Flower
					try {
						addFlower();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					// 3 Add Deco
					try {
						addDeco();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					// 4 Products by Type
					getAllProductsByClass();
					break;				
				default:
					System.out.println("Option not valid.");
			}
		}			
		
	}
	
	public static void createFlowerShop() {
		repository = new FlowerShopRepository();
		dataEntry = new Scanner(System.in);
	}
	
	public static void loadData() throws NullValueException {
		repository.addProduct(new Tree("Algarrobo", 475.99, 1.9));
		repository.addProduct(new Tree("Pino", 375.99, 1.9));
		repository.addProduct(new Tree("Roble", 1075.99, 1.9));
		
		repository.addProduct(new Flower("Margarita", 1.49, "Amarillo"));
		repository.addProduct(new Flower("Geranio", 1.99, "Blanco"));
		repository.addProduct(new Flower("Rosa", 2.50, "Rosa"));
		
		repository.addProduct(new Deco("Maceta", 6.49, Material.plastico));
		repository.addProduct(new Deco("Celosia", 1.99, Material.plastico));
		repository.addProduct(new Deco("Cuenco", 2.50, Material.madera));		
	}
	
	public static void addTree() throws NullValueException {
		
		String name;
		Double price;
		Double height;
		
		System.out.println("++ Add Tree: ");
		System.out.println("Tree name: ");
			name = dataEntry.next();
		System.out.println("Tree price: ");
		if (dataEntry.hasNextDouble())
			{

			price = dataEntry.nextDouble();
			} else
				{
					dataEntry.next();
					price = null;
				}
		System.out.println("Tree height: ");
		if (dataEntry.hasNextDouble())
			{

				height = dataEntry.nextDouble();
				}else
					{
						dataEntry.next();
						height = null;
					}

			if (name.equals("")||price==null||height==null)
			{
				throw new NullValueException("Tienes un valor nulo o que no corresponde con lo solicitado, NO SE HA CREADO EL PRODUCTO");
			}else
				{
				repository.addProduct(new Tree(name, price, height));
				System.out.println(repository.getLastProduct().toString());
				}
	}
	
	public static void addFlower() throws NullValueException {
		
		String name;
		Double price;
		String color;
		
		System.out.println("++ Add Flower: ");
		System.out.println("Flower name: ");
			name = dataEntry.next();	    			
		System.out.println("Flower price: ");
		if (dataEntry.hasNextDouble())
		{
			price = dataEntry.nextDouble();
		} else
		{
			price = null;
			dataEntry.next();
		}
		System.out.println("Flower color: ");
			color = dataEntry.next();

		if (name.equals("")||price==null||color.equals(""))
		{
			throw new NullValueException("Tienes un valor nulo o que no corresponde con lo solicitado, NO SE HA CREADO EL PRODUCTO");
		}else
		{
			repository.addProduct(new Flower(name, price, color));
			System.out.println(repository.getLastProduct().toString());
		}
			
	}
	
	public static void addDeco() throws NullValueException {
		
		String name;
		Double price;
		Material material;
		
		System.out.println("++ Add Deco: ");
		System.out.println("Deco name: ");
			name = dataEntry.next();	    			
		System.out.println("Deco price: ");
		if (dataEntry.hasNextDouble())
		{
			price = dataEntry.nextDouble();
		} else
		{
			price = null;
			dataEntry.next();
		}
		System.out.println("Deco material ('madera' or 'plastico'): ");
			material = Material.valueOf(dataEntry.next());

			if (name.equals("")||price==null||material.equals(""))
			{
				throw new NullValueException("Tienes un valor nulo o que no corresponde con lo solicitado, NO SE HA CREADO EL PRODUCTO");
			}else{
				repository.addProduct(new Deco(name, price, material));
				System.out.println(repository.getLastProduct().toString());
			}

					
	}
	
	public static void getAllProducts()
	{
		
		List<Product> products = repository.getAllProducts();
				
		System.out.println("\n++ Stock...\n");
		
		for (Product product : products) {
			System.out.println(" - " + product.toString());
		}	
		
		System.out.println("");
	}
	
	public static void getAllProductsByClass()
	{
				
		List<Product> products = repository.getAllProducts();
		
		Collections.sort(products, new Comparator<Product>() {
			// Order by Class Type
			@Override
			public int compare(Product object1, Product object2) {
			    return object2.getClass().getName().compareTo(object1.getClass().getName());
			}
			
		});
		
		System.out.println("\n++ Stock...\n");
		
		for (Product product : products) {
			System.out.println(" - " + product.toString());
		}	
		
		System.out.println("");
	}
	
	public static void exit() {
    	
    	System.out.println("Exit.");
          
    }
	
}
