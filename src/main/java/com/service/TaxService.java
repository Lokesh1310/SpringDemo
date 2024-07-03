package com.service;

import com.Entity.TaxModel;

public class TaxService {

	
	public TaxModel computeTax( TaxModel taxModel) {
		
		
		int income=taxModel.getIncome();
		int age=taxModel.getAge();
		int tax = 0;
		int rebate = 0;
		int netTax = 0;
		if (income >= 500000) {

			tax = income * 20 / 100;
		} else {

			tax = income * 10 / 100;

		}

		if (age >= 60) {

			rebate = tax * 20 / 100;
		}

		netTax = tax - rebate;
		
		taxModel.setIncome(income);
		taxModel.setNetTax(netTax);
		taxModel.setRebate(rebate);
		
		return taxModel;
	}
}
