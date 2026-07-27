package dev.kaeliton.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes") // -> localhost:8080/"misseos"
public class MissoesController {

    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    public String criarMissao(){
        return "criando missao";
    }

    // Mostrar Missoes (READ)
    @GetMapping("/listar")
    public String listarMissoes(){
        return "listando missoes";
    }

    // Alterar Missao por ID (UPDATE)
    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "alterar missao por id";
    }

    // Deletar Missao por ID (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarMissaoPorId(){
        return "deletar missao por id";
    }
}
