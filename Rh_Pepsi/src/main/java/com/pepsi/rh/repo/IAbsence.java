package com.pepsi.rh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pepsi.rh.entities.Absences;

public interface IAbsence extends JpaRepository<Absences, Long>{

}
