package com.hive.transportadora;

import com.hive.transportadora.services.ModalService;
import com.hive.transportadora.services.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
public class TransportadoraApplication implements CommandLineRunner {

	@Autowired
	private UFService ufService;

	@Autowired
	private ModalService modalService;

	public static void main(String[] args) {
		SpringApplication.run(TransportadoraApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("*")
				;
			}
		};
	}

	@Bean
	CorsConfigurationSource configurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedOrigin("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		return source;
	}

	@Override
	public void run(String... args) throws Exception {
		// Descomente as chamadas para gerar instâncias de Modal e Uf automaticamente no banco de dados
		// Após criar as instâncias comente novamente para não criá-las de novo

		//this.ufService.instanciarUfs();
		//this.modalService.instanciarModals();
	}
}
