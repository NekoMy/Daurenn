package com.javarush.art;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // This means that this class is a Controller

public class UserrController {

    // This means to get the bean called userRepo
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private UserRepo userRepo;

    // Mapping for signup, redirects to the /add page
    @GetMapping("signup")
    public String showSignUpForm(Userr user) {
        return "add";
    }

    // Unused mapping for administrator login, can be extended in future
    @GetMapping(path="login")
    public String Login(@RequestParam String login, @RequestParam String password) {
        if ((login == "admin") && (password == "admin")) {
            return "index";
        }
        else return "login";
    }

    // Mapping for index page, returns main page which is "/index"
    @GetMapping("index")
    public String mainPage(Userr user) {
        return "index";
    }

    // Gets Mapping for "/add", to add new user
    @GetMapping(path="add") //Request parameters required for a new user
    public String addNewUser (@RequestParam String login, @RequestParam String password, @RequestParam String name
            , @RequestParam String surname, @RequestParam String email,@RequestParam String lastname, @RequestParam String phonenumber, @RequestParam String country, @RequestParam String city, Map<String, Object> model )
    // Map<String, Object> model allow us to put user to the model for mustache page to display it in user list
    {

        Userr n = new Userr();

        n.setLogin(login);
        n.setPassword(password);
        n.setName(name);
        n.setSurname(surname);
        n.setLastname(lastname);
        n.setPhonenumber(phonenumber);
        n.setEmail(email);
        n.setCountry(country);
        n.setCity(city);
        // Saving user to the repository
        userRepo.save(n);
        // Getting Iterable to put in model
        Iterable<Userr> users = userRepo.findAll();
        // Putting all user to the model to display immediately on "show" page
        model.put("users", users);
        // Moving to the "show" page
        return "show";
    }

    // Method to search user by name
    @GetMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Userr> users;
        // Finding user by name or showing all users if filter is empty
        if (filter != null && !filter.isEmpty()) {

            users = userRepo.findByName(filter);
        } else {
            users = userRepo.findAll();
        }
        model.put("users", users );
        // Staying on the "show" page
        return "show";
    }

    // Mapping to show the users table
    @GetMapping(path="show")
    public String showUsers(Map <String, Object > model) {
        // Finding all users
        Iterable<Userr> users = userRepo.findAll();
        // Putting them in a model
        model.put("users", users);
        // Moving to the "show" page
        return "show";
    }

    // Mapping to delete user
    @GetMapping("delete")
    public String deleteUser (@RequestParam int id, Map <String, Object > model) {
        // Finding the correct user
        Userr user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepo.delete(user);
        // Switching back to all users
            Iterable<Userr> users = userRepo.findAll();
        // Returning users to the model to display since we move back to "show" page
            model.put("users", users);
            // Staying on the "show" page
        return "show";
    }

    // Mapping for user editing
    @GetMapping("edit")
    public String editUser (@RequestParam int id, Map <String, Object > model) {
        // Finding user
        Userr user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        // Filling up the edit form with his current details
        model.put("users", user);
        // Deleting the previous cloned user, so we add a new same one
        userRepo.delete(user);
        // Moving to edit page
        return "edit";

    }

}