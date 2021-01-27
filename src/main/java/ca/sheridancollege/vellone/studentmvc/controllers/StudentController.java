package ca.sheridancollege.vellone.studentmvc.controllers;

import ca.sheridancollege.vellone.studentmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    List<Student> students = new ArrayList<Student>();

    @GetMapping("/")
    public String index(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "input";
    }

    @PostMapping("/processInput")
    public String display(Model model, @ModelAttribute Student student){ //@RequestParam int id, @RequestParam String fullName

        //Student student = new Student();
        //student.setId(id);
        //student.setName(fullName);

        students.add(student);
        model.addAttribute("myStudents", students);

        return "output";
    }

    @RequestMapping("/helloAll")
    public String greet()
    {
        return ("redirect:/StudentAPI/greeting");
    }

    @GetMapping("/google")
    public String test() {

        return ("redirect:http://www.google.ca"); //you can set a seperate url to go to
    }

    @PostMapping("/processInput1")
    public ModelAndView display1(Model model, @ModelAttribute Student student){

        ModelAndView modelAndView = new ModelAndView("output");
        students.add(student);
        modelAndView.addObject("myStudents", "student");

        return modelAndView;
    }
}
