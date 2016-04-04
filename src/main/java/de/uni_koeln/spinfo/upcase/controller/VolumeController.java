package de.uni_koeln.spinfo.upcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.uni_koeln.spinfo.upcase.mongodb.Constans;
import de.uni_koeln.spinfo.upcase.mongodb.util.DataBase;

@Controller()
@RequestMapping(value = "/drc")
public class VolumeController {
	
	@Autowired
	private DataBase db;

	@RequestMapping(value = "/volumes", method = RequestMethod.GET)
	public ModelAndView getVolumes() {
		return new ModelAndView(Constans.VOLUMES, "volumes", db.getVolumeRepository().findAll());
	}
	
	
	
	
	
	
	
	

}
