package fr.eni.securingWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fr.eni.config.StringToDateConverter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(
					auth->{
						auth.requestMatchers("/monProfil").authenticated();
						auth.anyRequest().permitAll();
					})
				.formLogin( login->{
					login.loginPage("/login");
					login.failureUrl("/login?error=true");
					login.defaultSuccessUrl("/");
				})
				.logout( logout->{
					logout.logoutUrl("/logout");
					logout.logoutSuccessUrl("/?logout=true");
					logout.deleteCookies("JSESSIONID"); 
				})
				.build()
				;
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// Ajout du converter StringToDateConverter
		registry.addConverter(new StringToDateConverter());
	}
}