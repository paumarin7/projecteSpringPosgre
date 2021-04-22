package cat.itb.projectespring.model.servei;

import cat.itb.projectespring.model.Animal;
import cat.itb.projectespring.model.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> repositori = new ArrayList<>();

    public void afegir(Animal e) {
        repositori.add(e);
    }
    public List<Animal> llistat() {
        return repositori;
    }

    @PostConstruct
    public void init() {
        repositori.addAll(
                Arrays.asList(
                        new Animal("Gos", "Blanc"),
                        new Animal("Gat", "Negre"),
                        new Animal("Cocodril", "verd")
                ));}


    public Animal consultaPerNom(String s) {
        Animal u = null;
        boolean encontrado = false;
        for (int i = 0; i < repositori.size() && !encontrado; i++) {
            if (s.equals(repositori.get(i).getNomAnimal())){

                u = repositori.get(i);
                encontrado=true;
            }
        }
        return  u;
    }

    public void removeAnimalbyName(String s){
        Animal u = null;
        boolean encontrado = false;
        for (int i = 0; i < repositori.size() && !encontrado; i++) {
            if (s.equals(repositori.get(i).getNomAnimal())){

                u = repositori.get(i);
                encontrado=true;
            }
        }
        repositori.remove(u);
    }

    public void updateAnimal(Animal e, String nombre ){
        Animal u = null;
        boolean encontrado = false;
        for (int i = 0; i < repositori.size() && !encontrado; i++) {
            if (nombre.equals(repositori.get(i).getNomAnimal())){


                repositori.get(i).setNomAnimal(e.getNomAnimal());
                repositori.get(i).setColorAnimal(e.getColorAnimal());

            }
        }

    }






}
