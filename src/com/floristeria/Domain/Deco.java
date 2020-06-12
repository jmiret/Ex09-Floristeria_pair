package com.floristeria.Domain;

public class Deco extends Product {

	private Material material;
	
	public Deco() {}

	public Deco(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	public Deco(String name, double price, Material material) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deco other = (Deco) obj;
		if (material != other.material)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deco [" + super.toString() + "material=" + material + "]";
	}
	
}
