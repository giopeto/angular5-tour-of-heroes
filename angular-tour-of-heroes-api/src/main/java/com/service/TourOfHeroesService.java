package com.service;

import com.domain.Heroes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourOfHeroesService {

	private List<Heroes> heroes = getStaticHeroes();

	public List<Heroes> get() {
		return heroes;
	}

	public Optional<Heroes> getById(int id) {
		return heroes.stream().filter(hero -> hero.getId() == id).findFirst();
	}

	public Heroes add(Heroes hero) {
		Heroes newHero = new Heroes(heroes.get(heroes.size() - 1).getId() + 1, hero.getName());
		heroes.add(newHero);
		return newHero;
	}

	public Heroes update(Heroes hero) {
		heroes.forEach(staticHero-> {
			if(staticHero.getId() == hero.getId()) {
				heroes.set(heroes.indexOf(staticHero), hero);
			}
		});

		return hero;
	}

	private List<Heroes> getStaticHeroes() {
		ArrayList<Heroes> list = new ArrayList<>();
		list.add(new Heroes(11, "Mr. Nice" ));
		list.add(new Heroes(12, "Narco" ));
		list.add(new Heroes(13, "Bombasto" ));
		list.add(new Heroes(14, "Celeritas" ));
		list.add(new Heroes(15, "Magneta" ));
		list.add(new Heroes(16, "RubberMan"));
		list.add(new Heroes(17, "Dynama"));
		list.add(new Heroes(18, "Dr IQ"));
		list.add(new Heroes(19, "Magma"));
		list.add(new Heroes(20, "Tornado"));

		return list;
	}

	public void delete(int id) {
		Optional<Heroes> hero = getById(id);
		heroes.remove(hero.get());
	}

	public List<Heroes> search(String name) {
		return heroes.stream().filter(hero -> hero.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
	}
}
