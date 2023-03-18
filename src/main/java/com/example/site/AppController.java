package com.example.site;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private TheaterService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Theater> listTheater = service.listAll(keyword);
        model.addAttribute("ListTheater", listTheater);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/gist")
    public String index(Model model, @Param("keyword") String keyword){
        List<Theater> listTheater = service.listAll(keyword);
        model.addAttribute("ListTheater", listTheater);
        model.addAttribute("keyword", keyword);
        return "gist";
    }

    @RequestMapping("/new")
    public String showNewTypeForm(Model model){
        Theater type = new Theater();
        model.addAttribute("theater", type);
        return "new_theater";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveType(@ModelAttribute("type") Theater type){
        service.save(type);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTypeForm(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_theater");
        Theater type = service.get(id);
        mav.addObject("Type", type);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteType(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }


}
