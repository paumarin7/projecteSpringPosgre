package cat.itb.projectespring.model.repositoris;

import cat.itb.projectespring.model.Animal;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoriAnimals extends CrudRepository<Animal, String> {


    Object findAll(Sort nomAnimal);
}
