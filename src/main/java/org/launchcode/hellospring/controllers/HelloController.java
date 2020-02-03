package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Static handler

    //handles request at path /hello
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //dynamic handler (excepts data)

    //handles request of the form /hello?name=LaunchCode
    //take query parameter called(key) name with a given value LaunchCode
    //and that value should be used in the response
    //lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String languages) {
        return createMessage(name, languages);
    }

    //handles requests of the form /hello/LaunchCode
    //now the piece of data (LaunchCode) is part of the path, not the query string
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello'>" + //submit a request to /hello
                "<input type= 'text' name= 'name'>" +
                "<select name= 'languages'>" +
                "<option value= 'English'>English</option>" +
                "<option value= 'Spanish'>Spanish</option>" +
                "<option value= 'German'>German</option>" +
                "<option value= 'French'>French</option>" +
                "<option value= 'Italian'>Italian</option>" +
                "</select>" +
                "<input type= 'submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String languages) {
        if (languages.equals("English")){
            return "<h1 style= 'color: pink'>Hello, " + name + "!</h1>";
        }else if (languages.equals("Spanish")){
            return "<h1 style= 'color: red'>Hola, " + name + "!</h1>";
        }else if (languages.equals("German")){
            return "<h1 style= 'color: green'>Guten Tag, " + name + "!</h1>";
        }else if (languages.equals("French")){
            return "<h1 style= 'color: blue'>Bonjour, " + name + "!</h1>";
        }else{
            return "<h1 style= 'color: brown'>Ciao, " + name + "!</h1>";
        }
    }
}
