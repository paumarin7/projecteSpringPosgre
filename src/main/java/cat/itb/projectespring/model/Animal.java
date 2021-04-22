package cat.itb.projectespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @NotNull
    @NotEmpty
    private String nomAnimal;
    @NotNull
    @NotEmpty
    private String colorAnimal;








}
