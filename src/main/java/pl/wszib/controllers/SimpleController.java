package pl.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController() {

        listPerson = generateList();
    }

    @GetMapping("basic")
    public String basic(Model model){

        String firstName = "Jan";
        String lastName = "Kowalska";

        model.addAttribute("fName" , firstName);
        model.addAttribute("lName", lastName);

        Person person = new Person();
        person.setFirstName("Jacek");
        person.setLastName("Nowak");
        person.setPhoneNumber("43434343");
        person.setSalary(1000.00);
        person.setVisible(true);

        model.addAttribute("person", person);

        return "basicTemplate";
    }

    @GetMapping("iteration")
    public String iteration(Model model){
      //  List<Person> list = generateList();
        model.addAttribute("list", listPerson);
        return "iterationTemplate";
    }

    @GetMapping("links")
    public String links(Model model){

        return "linksTemplate";
    }

    @GetMapping("inter")
    public String inter (Model model){
        return "interTemplate";
    }

    @GetMapping("forms")
    public String forms(Model model){

        model.addAttribute("person", new Person());
        return "formsTemplate";
    }

    @PostMapping("formsSave")
    public String formsSave(Person person, Model model){
        listPerson.add(person);

        return "successTemplate";

    }


    private List<Person> generateList(){
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Jacek1");
        person1.setLastName("Nowak");
        person1.setPhoneNumber("43434343");
        person1.setSalary(1000.00);
        person1.setVisible(true);
        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Andrzej");
        person2.setLastName("Kowalski");
        person2.setPhoneNumber("7676");
        person2.setSalary(20.00);
        person2.setVisible(false);
        list.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Dawid");
        person3.setLastName("Cos");
        person3.setPhoneNumber("4389083");
        person3.setSalary(3000.00);
        person3.setVisible(true);
        list.add(person3);

        return list;
    }

}
