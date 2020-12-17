package prototype.RegistrationHospitalSystem.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/prototype/")
public class PaymentController {

    @RequestMapping("/")
    String home() {
        return "<h1>Welcome to Registrar Hospital System | Payment</h1>";
    }
}
