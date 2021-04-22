package cat.itb.projectespring.model.repositoris;

import cat.itb.projectespring.model.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari,String> {
}

