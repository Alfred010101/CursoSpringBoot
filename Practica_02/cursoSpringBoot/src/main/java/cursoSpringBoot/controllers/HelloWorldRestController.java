package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController
{
    //@GetMapping("/hello")
    @GetMapping({"/hello", "/hw"})
    public String HelloWorld()
    {
        return "HelloWorld!";
    }
}
