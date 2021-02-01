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

    String programs[] = {"Network Engineer", "Computer Engineer", "System Analyst"};

    List<Student> students = new ArrayList<Student>();

    @GetMapping(value={"/", "/index.do"})
    public String index(Model model){

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("programs", programs);
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

        return ("redirect:http://www.google.ca"); //you can set a separate url to go to
    }

    @PostMapping("/processInput1")
    public ModelAndView display1(Model model, @ModelAttribute Student student){
        //  ^ obj that holds name of view page and pass attributes that needs to be shared

        students.add(student);
        ModelAndView modelAndView = new ModelAndView("output", "myStudentList", students);
        //                                                                   ^obj you want to share


        return modelAndView;
    }
}
