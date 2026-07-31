package dev.kaeliton.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
