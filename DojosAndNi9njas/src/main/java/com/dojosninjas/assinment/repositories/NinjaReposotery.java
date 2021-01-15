package com.dojosninjas.assinment.repositories;

import com.dojosninjas.assinment.models.Dojo;
import com.dojosninjas.assinment.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinjaReposotery extends CrudRepository<Ninja,Long> {
//List<Ninja> findNinjasByDojoContains(Optional<Dojo> dojo);
}
