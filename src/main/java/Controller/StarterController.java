package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StarterController {
    @GetMapping
    public String systemAwaked() {
        return "All settings are okay. You can create new AirCompany instance by using /crtAirCom";
    }
}
