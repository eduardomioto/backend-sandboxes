package br.com.mioto.sandboxes;

import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

interface MovieRepository extends GraphRepository<Movie> {

	// derived finder
	Movie findByTitle(String title);

	@Query("MATCH (m:Movie)<-[rating:RATED]-(user) WHERE id(movie)={movie} return rating")
	List<Rating> getRatings(@Param("movie") Movie movie);

	// Co-Actors
	Set<Person> findByActorsMoviesActorName(String name);

	@Query("MATCH (movie:Movie)-[:HAS_GENRE]->(genre)<-[:HAS_GENRE]-(similar) WHERE id(movie) = {0} RETURN similar")
	List<Movie> findSimilarMovies(Movie movie);
	
}