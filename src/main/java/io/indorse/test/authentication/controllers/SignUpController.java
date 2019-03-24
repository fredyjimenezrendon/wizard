package io.indorse.test.authentication.controllers;

import io.indorse.test.authentication.data.UserData;
import io.indorse.test.authentication.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @RequestMapping("/")
    public ModelAndView index(){
        return  new ModelAndView("index");
    }

    @RequestMapping("/sign-up")
    public ModelAndView signUp(Model model){
        UserData userData = new UserData();
        model.addAttribute("userForm", userData);
        return new ModelAndView("sign-up");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("userForm") UserData userData, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("sign-up-result");
            model.addObject("msg", signUpService.saveUser(userData));
            return model;
        } else {
            return new ModelAndView("sign-up");
        }

    }

    @RequestMapping("/confirm/{token}")
    public ModelAndView signUp(@PathVariable String token){
        signUpService.activateUser(token);
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/main")
    public ModelAndView main(){
        return  new ModelAndView("main");
    }

}

