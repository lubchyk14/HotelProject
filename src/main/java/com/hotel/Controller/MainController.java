package com.hotel.Controller;

import com.hotel.DAO.CountryDAO;
import com.hotel.DAO.Impl.CountryDAOImpl;
import com.hotel.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String login(){
        return "login";
    }
}
