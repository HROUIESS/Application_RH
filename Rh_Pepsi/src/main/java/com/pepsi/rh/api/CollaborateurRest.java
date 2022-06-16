package com.pepsi.rh.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.services.IService;

@RestController
@RequestMapping("Collaborateur")
public class CollaborateurRest {

	@Autowired
	IService service;
	
	@PostMapping("/add")
	public ResponseEntity<Collaborateur> save(@RequestBody Collaborateur c)
	{
		c=service.addcollaborateur(c);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Collaborateur>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/collaborateurs")
	public Page<Collaborateur> all(@RequestParam int page,@RequestParam int size)
	{
		return service.allcollaboraters(page, size);
	}
	
	
	@GetMapping("/collaborateurs/{idc}")
	public ResponseEntity<Collaborateur> all(@PathVariable long idc)
	{
		Collaborateur c = service.findCollaborateur(idc);
		if(c!=null)
		return new ResponseEntity<Collaborateur>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Collaborateur>(HttpStatus.NO_CONTENT);
		
	}
	
	
	@PostMapping("/colla/{idc}/absences")
	public Absences addabss(@RequestBody Absences ab,@PathVariable long idc)
	{
		return service.addAbsence(ab, idc);
	}
	
	
	
}
