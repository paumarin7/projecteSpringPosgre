package cat.itb.projectespring.model.repositoris;

import cat.itb.projectespring.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriAnimals extends CrudRepository<Animal, String> {
}
