package dev.kaeliton.CadastroDeNinjas.Missoes;

import dev.kaeliton.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    private String descricao;

    // @OneToMany 1 missao tem 1 ou n ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
