package project.xmlproject;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.xmldb.api.base.XMLDBException;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
@Configuration
@EnableScheduling
public class XmlProjectApplication {

	public static void main(String[] args){
		SpringApplication.run(XmlProjectApplication.class, args);
	}

	@Scheduled(fixedDelay = 30000)
	public void schedule() throws IOException {
		try {
			FileUtils.cleanDirectory(new File("src/main/resources/static/html"));
		} catch (Exception e) {
			System.out.println("HTML File currently in use!");
		}

		try {
			FileUtils.cleanDirectory(new File("src/main/resources/static/pdf"));
		} catch (Exception e) {
			System.out.println("PDF File currently in use!");
		}

		try {
			FileUtils.cleanDirectory(new File("src/main/resources/static/rdf"));
		} catch (Exception e) {
			System.out.println("RDF File currently in use!");
		}
	}
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers", "responseType"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "responseType"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
