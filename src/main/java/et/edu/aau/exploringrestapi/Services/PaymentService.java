package et.edu.aau.exploringrestapi.Services;

import et.edu.aau.exploringrestapi.Exceptions.NotEnoughMoneyException;
import et.edu.aau.exploringrestapi.Models.PaymentDetail;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetail processPayment() {
        throw new NotEnoughMoneyException();
    }
}
