package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkLevel;

public class Work {
	private String name;
	private WorkLevel level;
	private Double baseSalary;

	private Department department;
	private List<Contract> contracts = new ArrayList<>();

	public Work() {

	}

	public Work(String name, WorkLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	public void addContract(Contract contract) {
		contracts.add(contract);
		
	}
	
	public void removeContract(Contract contract) {
		contracts.remove(contract);
		
	}
	
	public double  income(int year ,int month) {
		double soma = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(Contract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
		    int c_month = 1 + cal.get(Calendar.MONTH);

			if(year == c_year && month == c_month	) {
				soma = soma + c.totalValue();		
			}
		}
		return soma;	
	}
}
