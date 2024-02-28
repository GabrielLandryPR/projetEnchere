package fr.eni.securingWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity
				.authorizeHttpRequests(
					auth->{
						auth.requestMatchers("/formLog").authenticated();
						auth.requestMatchers("/monProfil").authenticated();
						auth.anyRequest().permitAll();
					})
				.formLogin( login->{
					login.loginPage("/login");
					login.failureUrl("/login-error");
					login.defaultSuccessUrl("/monProfil");
				})
				.logout( logout->{
					logout.logoutUrl("/logout");
					logout.logoutSuccessUrl("/");
				})
				.build()
				;
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}