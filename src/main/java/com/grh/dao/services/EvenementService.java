package com.grh.dao.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grh.model.dto.EvenementDTO;

public interface EvenementService {
	public EvenementDTO addOneEvent(EvenementDTO eventDto);
	public Page<EvenementDTO> getAllEvents(Pageable pageable );
	public EvenementDTO getOneEvenet(long id);
    public EvenementDTO updateEvenement(Long id, EvenementDTO evenementDTO);
	public void deleteOneEvent(long id);
}
