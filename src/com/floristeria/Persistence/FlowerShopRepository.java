package com.floristeria.Persistence;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.Application.NullValueException;
import com.floristeria.Domain.Product;

public class FlowerShopRepository {

	private static List<Product> products = new ArrayList<Product>();
	
	public FlowerShopRepository() {}
	
	public void addProduct(Product product) throws NullValueException
	{
		if(product == null)
		{
			throw new NullValueException(" ALGUN PRODUCTO CREADO TIENE VALOR NULO O INCOMPATIBLE");
		}else
			{
				products.add(product);
			}

	}
	
	public List<Product> getAllProducts()
	{
		return new ArrayList<>(products);		
	}
	
	public Product getLastProduct()
	{
		return new ArrayList<>(products).get(products.size() - 1);		
	}
	
	public List<Product> getAllProductsByClass()
	{
		return new ArrayList<>(products);		
	}
	
}
