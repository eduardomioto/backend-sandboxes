package br.com.mioto.sandboxes;

import org.springframework.beans.factory.annotation.Autowired;

public class Business {

	@Autowired
     MovieRepository repo;

	public  void exec(){

		Iterable<Movie> movies = repo.findAll();
		//Movie movie = repo.findByTitle("The Matrix");
		//repo.save(movie);

		for (Movie mov : movies) {
			System.out.println(mov);
		} 

	}

}
