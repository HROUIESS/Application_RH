package com.pepsi.rh.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.repo.IAbsence;
import com.pepsi.rh.repo.ICollaborateur;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ServiceImpl implements IService{

	@Autowired
	ICollaborateur crepo;
	@Autowired
	IAbsence arepo;
	@Autowired

	
	@Override
	public Collaborateur addcollaborateur(Collaborateur c) {
		Collaborateur C=crepo.save(c);
		
		return C;
	}

	@Override
	public Collaborateur findCollaborateur(long id) {
		
		Optional<Collaborateur> o = crepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}

	@Override
	public Page<Collaborateur> allcollaboraters(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return crepo.findAll(pageable);
		
	}

	@Override
	public Absences addAbsence(Absences a, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		a.setCollaborateur(c);
		a=arepo.save(a);
		return a;
	}

	
}
