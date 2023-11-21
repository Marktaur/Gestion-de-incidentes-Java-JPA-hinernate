package entidades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table (name = "clientes")
public class clientes {
    @Id
    private int Cliente_ID;
    private String razonS;


}
