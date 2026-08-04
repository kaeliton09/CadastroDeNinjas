package dev.kaeliton.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // listar missao por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    // criar nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    // deletar missao por id
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // alterar missao por id
    public MissoesModel alterarMissaoPorId(Long id, MissoesModel missao){
        missao.setId(id);
        return missoesRepository.save(missao);
    }
}
