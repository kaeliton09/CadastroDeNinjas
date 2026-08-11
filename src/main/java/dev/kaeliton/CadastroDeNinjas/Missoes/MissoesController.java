package dev.kaeliton.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes") // -> localhost:8080/"misseos"
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    // Mostrar Missoes (READ)
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    // Mostrar Missoes por Id(READ)
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // Alterar Missao por ID (UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missao){
        return missoesService.alterarMissaoPorId(id, missao);
    }

    // Deletar Missao por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }
}
