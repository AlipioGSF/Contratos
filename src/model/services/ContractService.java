package model.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import model.entitties.Contract;
import model.entitties.Installment;

public class ContractService {
	
	static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	private OnlinePaymentService paymentService;
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months){
		for(int i=1;i<=months;i++) {
			double interest = paymentService.interest(contract.getTotalValue()/months, i);
			double amount = paymentService.paymentFee(interest);
			contract.getInstallments().add(new Installment(contract.getDate().plusMonths(i), amount));
		}
	}
}
