package model;

import java.text.NumberFormat;
import java.util.ArrayList;

public class InterestTable {
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	private double principal;
	private double rate;
	private int years;
	
	public InterestTable(double principal, double rate, int years) {
		this.principal = principal;
		this.rate = rate;
		this.years = years;
	}
	
	public String simpleInterest() {
		String str = "";
		
		str += "Principal: " + formatDollar(principal) + ", Rate: " + rate;
		str += "\nYear, Simple Interest Amount";
		
		ArrayList<Double> values = getSimpleInterestValues();
		
		for(int i = 0; i < values.size(); i++){
			str += "\n" + (i + 1) + "-->" + formatDollar(values.get(i));
		}
		
		return str;
	}
	
	public String compoundInterest() {
		String str = "";
		
		str += "Principal: " + formatDollar(principal) + ", Rate: " + rate;
		str += "\nYear, Compound Interest Amount";
		
		ArrayList<Double> values = getCompoundInterestValues();
		
		for(int i = 0; i < values.size(); i++){
			str += "\n" + (i + 1) + "-->" + formatDollar(values.get(i));
		}
		
		return str;
	}
	
	public String bothInterest() {
		String str = "";
		
		str += "Principal: " + formatDollar(principal) + ", Rate: " + rate;
		str += "\nYear, Simple Interest Amount, Compound Interest Amount";
		
		ArrayList<Double> simpleValues = getSimpleInterestValues();
		ArrayList<Double> compoundValues = getCompoundInterestValues();
		
		for(int i = 0; i < compoundValues.size(); i++){
			str += "\n" + (i + 1) + "-->" + formatDollar(simpleValues.get(i)) + "-->" + formatDollar(compoundValues.get(i));
		}
		
		return str;
	}
	
	private ArrayList<Double> getSimpleInterestValues() {
		ArrayList<Double> interests = new ArrayList<Double>();
		
		for(int i = 1; i <= years; i++) {
			double value = principal + ( principal * (rate/100) * i);
			interests.add(value);
		}
		
		return interests;
	}	
	
	private ArrayList<Double> getCompoundInterestValues() {
		ArrayList<Double> interests = new ArrayList<Double>();
		
		for(int i = 1; i <= years; i++) {
			double value = principal * Math.pow(1 + (rate/100), i);
			interests.add(value);
		}
		
		return interests;
	}
	
	private String formatDollar(double value){
		return formatter.format(value);
	}
}