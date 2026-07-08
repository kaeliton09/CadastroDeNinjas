package dev.kaeliton.CadastroDeNinjas.Missoes;

import dev.kaeliton.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
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

    public MissoesModel(String nome, String dificuldade, String descricao) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
    }

    public MissoesModel(String nome, String dificuldade, String descricao, List<NinjaModel> ninjas) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.ninjas = ninjas;
    }

    public MissoesModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
