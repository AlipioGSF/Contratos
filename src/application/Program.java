package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entitties.Contract;
import model.entitties.Installment;
import model.services.ContractService;
import model.services.PaymentService;

public class Program {
	public static void main(String[] args) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data  (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate date = LocalDate.EPOCH.parse(sc.nextLine(), fmt);
		System.out.print("Valor do contrato: ");
		double valorContrato = sc.nextDouble();		
		System.out.print("Número de parcelas: ");
		int parcelas = sc.nextInt();
		
		Contract contract = new Contract(number, date, valorContrato);
		ContractService service = new ContractService(new PaymentService());
		
		service.processContract(contract, parcelas);
		
		System.out.println("Parcelas: ");
		for(Installment i : contract.getInstallments()) {
			System.out.println(i.toString());
		}
		
		
	}
}
