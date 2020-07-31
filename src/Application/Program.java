package Application;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Department;
import entities.Work;
import entities.enums.WorkLevel;



public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department name: ");
		String dep = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();

		Work worker = new Work(workerName, WorkLevel.valueOf(workerLevel), baseSalary, new Department(dep));
		
		System.out.println("Quantos contratos esse trabalhador tem: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Entre com os dados do contrato #" +i + " data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dt = sdf.parse(sc.next());
			
			System.out.println();
			System.out.println("Valor por hora: ");
			double valorHora = sc.nextDouble();
			
			
			System.out.println("Quantidade de horas: ");
			int qtdHrs = sc.nextInt();
			
			Contract contract = new Contract(dt, valorHora, qtdHrs);
			worker.addContract(contract);

			
			
		}
		
		System.out.println();
		System.out.print("Entre com mês e ano.. para valcular o salário (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Salario no mês: " + mesAno + ": " + String.format("%.2f", worker.income(ano, mes)));
		


		
		sc.close();

	}

}
