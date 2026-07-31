package dev.kaeliton.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjasRepository ninjasRepository;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
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
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjasRepository.save(ninja);
    }
}
