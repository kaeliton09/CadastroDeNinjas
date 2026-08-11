package dev.kaeliton.CadastroDeNinjas.Missoes;

import dev.kaeliton.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // listar todas as missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // listar missao por id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.stream()
                .map(missoesMapper::map)
                .findAny().orElse(null);
    }

    // criar nova missao
    public MissoesDTO criarMissao(MissoesDTO missao){
        MissoesModel missaoNova = missoesMapper.map(missao);
        missaoNova = missoesRepository.save(missaoNova);
        return missoesMapper.map(missaoNova);
    }

    // deletar missao por id
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // alterar missao por id
    public MissoesDTO alterarMissaoPorId(Long id, MissoesDTO missao){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);

        if(missaoExiste.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missao);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }

        return null;
    }
}
