package dev.kaeliton.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/listar/{id}")
    public NinjaModel listaNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
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
