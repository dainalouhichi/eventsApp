package com.grh.dao.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.grh.dao.repositeries.EventRepository;
import com.grh.model.dto.EvenementDTO;
import com.grh.model.entities.Evenement;
import com.grh.model.mappers.EvenementMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImplementation implements EvenementService {
	private final EventRepository eventRepo;
	
	@Override
	public EvenementDTO addOneEvent(EvenementDTO eventDto) {
		// TODO Auto-generated method stub
	Evenement event = EvenementMapper.toEntity(eventDto);
	Evenement savedEvent = eventRepo.save(event);
	return EvenementMapper.toDTO(savedEvent);
	}

	@Override
	public Page<EvenementDTO> getAllEvents(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Evenement> events = eventRepo.findAll(pageable);

		return events.map(EvenementMapper::toDTO);
	}

	@Override
	public EvenementDTO getOneEvenet(long id) {
		// TODO Auto-generated method stub
		return EvenementMapper.toDTO(eventRepo.findById(id).orElse(null));
	}

	@Override
	public void deleteOneEvent(long id) {
		// TODO Auto-generated method stub
		eventRepo.deleteById(id);
		
	}

	@Override
	public EvenementDTO updateEvenement(Long id, EvenementDTO evenementDTO) {
		// TODO Auto-generated method stub
		Evenement saved=eventRepo.findById(id).orElse(null);
		return EvenementMapper.toDTO(saved);
	}

}
