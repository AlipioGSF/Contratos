package model.services;

public class PaymentService implements OnlinePaymentService {

	@Override
	public double paymentFee(double amount) {
		return amount + (amount * 0.02);
	}

	@Override
	public double interest(double amount, int month) {
		return amount + (amount * 0.01 * month);
	}
	
}
