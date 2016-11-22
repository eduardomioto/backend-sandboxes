package br.com.mioto.sandboxes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class App {

	 /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args ) {
        SpringApplication.run( App.class, args );
    }
}
