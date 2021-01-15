package com.dojosninjas.assinment.services;

import com.dojosninjas.assinment.models.Dojo;
import com.dojosninjas.assinment.models.Ninja;
import com.dojosninjas.assinment.repositories.DojoReposotery;
import com.dojosninjas.assinment.repositories.NinjaReposotery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoNinjaService {
    private final DojoReposotery dojoRepo;
    private final NinjaReposotery ninjaRepo;
    public DojoNinjaService(DojoReposotery dojoRepo, NinjaReposotery ninjaRepo) {
        this.dojoRepo = dojoRepo;
        this.ninjaRepo = ninjaRepo;
    }
public Dojo CreateDojo(Dojo d){
        return dojoRepo.save(d);
}
public List<Dojo> getDojos(){
    return dojoRepo.findAll();

}
public Ninja createNewNinja(Ninja ninja){
        return ninjaRepo.save(ninja);
}
public Dojo getSingleDojo(Long id) {
    Optional<Dojo> dojo = dojoRepo.findById(id);
    if (dojo.isPresent()) {
        return dojo.get();
    } else {
        return null;
    }
}
//    public List<Ninja> getDojoNinjas(Dojo dojo){
//        return

//       Optional<Dojo> dojo1=dojoRepo.findById(dojo.getId());
//        if (dojo1.isPresent()){
//            List<Ninja> allNinjas=ninjaRepo.findNinjasByDojoContains(dojo1);
//            return allNinjas;
//        }
//        else{
//            return null;
//        }
    //}
}

