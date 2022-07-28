package com.shop.demo.Controller;
import com.shop.demo.dao.Unit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class startController {
    @GetMapping("/")
    public String start() {
        return "ingredients/home";
    }

}
