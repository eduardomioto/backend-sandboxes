package br.com.mioto.sandboxes;
import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class Neo4JNative {

	public static void main(String[] args) {
		exec();
	}
	
	public static void exec(){

		Driver driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "admin" ) );
		Session session = driver.session();

		session.run( "CREATE (a:Person {name: {name}, title: {title}})",
				parameters( "name", "Arthur", "title", "King" ) );

		StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = {name} " +
				"RETURN a.name AS name, a.title AS title",
				parameters( "name", "Arthur" ) );
		
		while ( result.hasNext() )
		{
			Record record = result.next();
			System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
		}

		session.close();
		driver.close();
	}
}
