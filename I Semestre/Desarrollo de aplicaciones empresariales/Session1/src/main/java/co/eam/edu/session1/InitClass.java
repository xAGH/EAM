package co.eam.edu.session1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitClass {

    @GetMapping("/")
    public String greeting(){
        return "Hello world from SpringBoot";
    }
}
