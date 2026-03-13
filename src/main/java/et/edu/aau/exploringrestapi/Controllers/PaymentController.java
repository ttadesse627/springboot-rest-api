package et.edu.aau.exploringrestapi.Controllers;
import et.edu.aau.exploringrestapi.Models.PaymentDetail;
import et.edu.aau.exploringrestapi.Services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
    private final PaymentService _paymentService;
    public PaymentController(PaymentService paymentService) {
        _paymentService = paymentService;
    }

    @PostMapping()
    public ResponseEntity<?> makePayment() {
        PaymentDetail paymentDetail = _paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetail);
    }

}
