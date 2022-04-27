package com.nz.kiwi.service;

import com.nz.kiwi.dto.*;
import com.nz.kiwi.model.Bird;
import java.util.Collection;

public interface BirdService {

    Bird create(Bird bird);
    Collection<Bird> list();
    Bird get(Long id);
    Bird update(Bird bird);
    void delete(Long id);
    BirdDTO getBirdDTO(Long id);
    Collection<BirdDTO> getBirdListDTO();
    BirdViewDTO getBirdViewDTO(Long id);

    Bird getBirdTextXML();
}
