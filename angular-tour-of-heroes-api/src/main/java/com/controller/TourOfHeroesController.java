package com.controller;

import com.domain.Heroes;
import com.service.TourOfHeroesService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@CrossOrigin
public class TourOfHeroesController {

	@NonNull private final TourOfHeroesService tourOfHeroesService;

	@Autowired
	public TourOfHeroesController(TourOfHeroesService tourOfHeroesService) {
		this.tourOfHeroesService = tourOfHeroesService;
	}

	@RequestMapping(value = "api/heroes", method = GET)
	public List<Heroes> get() {
		return tourOfHeroesService.get();
	}

	@RequestMapping(value = "api/heroes/search/{name}", method = GET)
	public List<Heroes> search(@PathVariable String name) {
		return tourOfHeroesService.search(name);
	}

	@RequestMapping(value = "api/heroes", method = POST)
	public Heroes add(@RequestBody Heroes hero) {
		return tourOfHeroesService.add(hero);
	}

	@RequestMapping(value = "api/heroes/{id}", method = GET)
	public Heroes getById(@PathVariable int id) {
		return tourOfHeroesService.getById(id).get();
	}

    @RequestMapping(value = "api/heroes", method = PUT)
    public Heroes update(@RequestBody Heroes hero) {
	    return tourOfHeroesService.update(hero);
    }

	@RequestMapping(value = "api/heroes/{id}", method = DELETE)
	public void delete(@PathVariable int id) {
		tourOfHeroesService.delete(id);
	}
}
