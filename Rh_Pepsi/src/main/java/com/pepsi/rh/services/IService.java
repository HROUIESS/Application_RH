package com.pepsi.rh.services;

import org.springframework.data.domain.Page;

import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Collaborateur;

public interface IService {

	public Collaborateur addcollaborateur(Collaborateur c);
	public Collaborateur findCollaborateur(long id);
	public Page<Collaborateur> allcollaboraters(int page, int size);
	public Absences addAbsence(Absences a, long idc);
	
	
}
