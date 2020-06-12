package com.floristeria.Domain;

public class Tree extends Product {
	
	private double height;

	public Tree() {}
	
	public Tree(String name, double price, double height) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Tree other = (Tree) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tree [" + super.toString() + "height=" + height + "]";
	}
	
}
