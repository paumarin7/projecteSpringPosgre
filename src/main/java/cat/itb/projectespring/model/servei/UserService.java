package cat.itb.projectespring.model.servei;



import cat.itb.projectespring.model.Usuari;
import cat.itb.projectespring.model.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


        @Autowired
        private RepositoriUsuaris repositori;
        public void afegir(Usuari e) {
            e.setPassword(passwordEncoder(e.getPassword()));
            repositori.save(e);
        }
        public List<Usuari> llistat() {
            return (List<Usuari>) repositori.findAll();
        }

        @PostConstruct
        public void init() {
            repositori.saveAll(
                    Arrays.asList(
                            new Usuari("user1", passwordEncoder("user1"), "user1"),
                            new Usuari("user2", passwordEncoder("user2"), "user2"),
                            new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN","ADMIN")
                    ));}


    public Usuari consultaPerId(String s) {

        return  repositori.findById(s).orElse(null);
    }


    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}
