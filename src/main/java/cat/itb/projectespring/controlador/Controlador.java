package cat.itb.projectespring.controlador;



import cat.itb.projectespring.model.Animal;
import cat.itb.projectespring.model.Usuari;
import cat.itb.projectespring.model.servei.AnimalService;
import cat.itb.projectespring.model.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controlador {

    String nom;
    @Autowired
    private UserService servei;
    @Autowired
    private AnimalService serveiAnimal;


    @GetMapping("/")
    public  String  inici(Model m){
        m.addAttribute("llistaAnimal",serveiAnimal.llistatPerNom());
        m.addAttribute("Animal",new Animal());
        return "home";
    }
    @GetMapping("/userList")
    public String llistar(Model m){
        m.addAttribute("llistaUsuaris",servei.llistat());
        return "llistatUsuaris";
    }

    @GetMapping("/home")
    public String llistarAnimal(Model m){
        m.addAttribute("llistaAnimal",serveiAnimal.llistat());
        m.addAttribute("Animal",new Animal());
        return "home";
    }
    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }
    @RequestMapping("/afegir")
    public String afegirAnimal(Model model) {
        model.addAttribute("Animal", new Animal());
        return "afegirAnimal";
    }
    @PostMapping("/afegirAnimal")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String AfegirAnimal(@ModelAttribute("Animal") Animal e){
        serveiAnimal.afegir(e);
        return "redirect:/";

    }
    @PostMapping("/registration")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.afegir(e);
        return "redirect:/";

    }
    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateAnimal(@PathVariable("name") String animal, Model m){
        nom = animal;
        m.addAttribute("Animal",serveiAnimal.consultaPerNom(animal));
        return "updateAnimal";
    }

    @PostMapping("/updateAnimal")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String updateAnimalpost(@ModelAttribute("Animal") Animal e){
        serveiAnimal.updateAnimal(e, nom);
        return "redirect:/";
    }

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeAnimal(@PathVariable("name") String animal){

        serveiAnimal.removeAnimalbyName(animal);
        return "redirect:/";
    }






}




