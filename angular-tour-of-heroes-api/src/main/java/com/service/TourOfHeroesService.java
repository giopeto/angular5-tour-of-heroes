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
		int id = 1;
		if (heroes.size() > 0) {
			id = heroes.get(heroes.size() - 1).getId() + 1;
		}
		Heroes newHero = new Heroes(id, hero.getName(), hero.getPower(), hero.getAlterEgo());
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
		list.add(new Heroes(11, "Mr. Nice", "Really Smart", "a"));
		list.add(new Heroes(12, "Narco", "Really Smart", "a"));
		list.add(new Heroes(13, "Bombasto", "Really Smart", "a"));
		list.add(new Heroes(14, "Celeritas", "Really Smart", "a"));
		list.add(new Heroes(15, "Magneta", "Really Smart", "a"));
		list.add(new Heroes(16, "RubberMan", "Really Smart", "a"));
		list.add(new Heroes(17, "Dynama", "Really Smart", "a"));
		list.add(new Heroes(18, "Dr IQ", "Really Smart", "a"));
		list.add(new Heroes(19, "Magma", "Really Smart", "a"));
		list.add(new Heroes(20, "Tornado", "Really Smart", "a"));

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
