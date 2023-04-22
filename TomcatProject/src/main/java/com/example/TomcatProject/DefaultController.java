package com.example.TomcatProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
        @GetMapping("/helloWorld")
        public String helloWorld() {
            return "Hello World!";
        }

}
