package ca.bc.gov.pssg.docmerge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:docmerge.properties")
@SpringBootApplication
public class DocumentMergeServiceApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DocumentMergeServiceApplication.class);
	} 

	public static void main(String[] args) {
		SpringApplication.run(DocumentMergeServiceApplication.class, args);
	}
}
