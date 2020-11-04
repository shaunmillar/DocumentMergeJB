package ca.bc.gov.pssg.docmerge.swagger2;
 
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application.properties")
public class SwaggerConfig {
	
	@Value("${docmerge.service.version}")
	private String version;
    
    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ca.bc.gov.pssg.docmerge"))
                .paths(Predicates.not(PathSelectors.regex("/\\*\\*/.*/\\*\\*"))) // Ignore default path mappings
                .build();
    }
    
    @SuppressWarnings({ "unchecked", "unused" })
	private Predicate<String> postPaths() {
		return or(regex("/questions.*"), 
				regex("/companies.*"),
				regex("/question-types.*")); 
	}

    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder()
                .title("Document Merge RESTful Service")
                .description("Document Merge API")
                .version(version)
                .build();
    }
}