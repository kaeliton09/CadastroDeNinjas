package dev.kaeliton.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjasRepository ninjasRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjasRepository ninjasRepository, NinjaMapper ninjaMapper) {
        this.ninjasRepository = ninjasRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjasRepository.findAll();
    }

    // listar ninja por id
    public NinjaModel listarNinjaPorId(Long  id){
        Optional<NinjaModel> ninjaPorId = ninjasRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = new ninjaMapper.map(ninjaDTO);
        ninja = ninjasRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // deletar um ninja
    public void deletarNinjaPorId(Long id){
        ninjasRepository.deleteById(id);
    }

    // alterar ninja por id
    public NinjaModel alterarNinjaPorId(Long id, NinjaModel ninja){
        ninja.setId(id);
        return ninjasRepository.save(ninja);
    }
}
