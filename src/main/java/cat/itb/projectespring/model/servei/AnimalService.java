package cat.itb.projectespring.model.servei;

import cat.itb.projectespring.model.Animal;
import cat.itb.projectespring.model.Usuari;
import cat.itb.projectespring.model.repositoris.RepositoriAnimals;
import cat.itb.projectespring.model.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private RepositoriAnimals repositori;

    public void afegir(Animal e) {
        repositori.save(e);
    }
    public List<Animal> llistat() {
        return (List<Animal>) repositori.findAll();
    }

    @PostConstruct
    public void init() {
        repositori.saveAll(
                Arrays.asList(
                        new Animal("Gos", "Blanc"),
                        new Animal("Gat", "Negre"),
                        new Animal("Cocodril", "verd")
                ));}


    public Animal consultaPerNom(String s) {

        return  repositori.findById(s).orElse(null);
    }

    public void removeAnimalbyName(String s){
        Animal animal = consultaPerNom(s);
        repositori.delete(animal);
    }

    public void updateAnimal(Animal e, String nombre ){
        Animal u = repositori.findById(nombre).orElse(null);
                u.setColorAnimal(e.getColorAnimal());
                u.setNomAnimal(e.getNomAnimal());
            }
        }

    }






}
