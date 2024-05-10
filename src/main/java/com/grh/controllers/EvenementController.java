package com.grh.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.dao.services.EvenementService;
import com.grh.model.dto.EvenementDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EvenementController {
	private final EvenementService eventService;
	
	@GetMapping("/{id}")
    public ResponseEntity<EvenementDTO> getEvenementById(@PathVariable Long id) {
        EvenementDTO evenementDTO = eventService.getOneEvenet(id);
        return ResponseEntity.ok(evenementDTO);
    }

    @GetMapping
    public ResponseEntity<Page<EvenementDTO>> getAllEvenements(Pageable pageable) {
        Page<EvenementDTO> evenements = eventService.getAllEvents(pageable);
        return ResponseEntity.ok(evenements);
    }

    @PostMapping
    public ResponseEntity<EvenementDTO> createEvenement(@RequestBody EvenementDTO evenementDTO) {
        EvenementDTO createdEvenement = eventService.addOneEvent(evenementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvenement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvenementDTO> updateEvenement(@PathVariable Long id, @RequestBody EvenementDTO evenementDTO) {
        EvenementDTO updatedEvenement = eventService.updateEvenement(id, evenementDTO);
        return ResponseEntity.ok(updatedEvenement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvenement(@PathVariable Long id) {
        eventService.deleteOneEvent(id);
        return ResponseEntity.noContent().build();
    }

}
