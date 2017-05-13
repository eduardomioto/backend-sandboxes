package br.com.mioto.sandboxes;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Movie {

  @GraphId Long id;
  String title;

  Person director;

  @Relationship(type="ACTS_IN", direction = Relationship.INCOMING)
  Set<Person> actors;

  @Relationship(type = "RATED")
  List<Rating> ratings;
  
}