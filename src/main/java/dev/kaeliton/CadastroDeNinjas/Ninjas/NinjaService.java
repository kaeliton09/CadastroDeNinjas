package dev.kaeliton.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private NinjasRepository ninjasRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjasRepository ninjasRepository, NinjaMapper ninjaMapper) {
        this.ninjasRepository = ninjasRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjasRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // listar ninja por id
    public NinjaDTO listarNinjaPorId(Long  id){
        Optional<NinjaModel> ninjaPorId = ninjasRepository.findById(id);
        return ninjaPorId.stream().
                map(ninjaMapper::map).findAny().orElse(null);
    }

    // criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjasRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // deletar um ninja
    public void deletarNinjaPorId(Long id){
        ninjasRepository.deleteById(id);
    }

    // alterar ninja por id
    public NinjaDTO alterarNinjaPorId(Long id, NinjaDTO ninja){
        Optional<NinjaModel> ninjaExistente = ninjasRepository.findById(id);

        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjasRepository.save(ninjaAtualizado);

            return ninjaMapper.map(ninjaSalvo);
        }

        return null;
    }
}
