package dev.kaeliton.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "essa eh minha primeira mensagem";
    }


    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "ninja criado";
    }

    // Mostrar todos os Ninjas (Read)
    @GetMapping("/ninjas")
    public String mostrarNinjas(){
        return "sem ninjas no momento";
    }
    
    // Mostrar ninja por id (Read)
    @GetMapping("/ninjaID")
    public String mostrarNinjaPorID(){
        return "sem ninjas no momento (id)";
    }

    // Alterar dados do Ninja (Update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "alterar ninja por (id)";
    }

    // Deletar Ninjas (Delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "deletar ninja por (id)";
    }

}
