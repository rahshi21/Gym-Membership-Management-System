package com.gm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gm.security.JwtAuthenticationFilter;
import com.gm.security.JwtAuthorizationFilter;
import com.gm.security.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtUtil jwtUtil;
	
	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Bean
	public UserDetailsService userDetailsService(DataSource datasource) {
		JdbcDaoImpl jdbcDao=new JdbcDaoImpl();
		jdbcDao.setDataSource(datasource);
		jdbcDao.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username= ?");
		jdbcDao.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username= ?");
 
		return jdbcDao;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
			throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager, 
			UserDetailsService userDetailsService) throws Exception {
	 
		JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(authManager, jwtUtil);
		jwtAuthFilter.setFilterProcessesUrl("/login");
		
	    http
	    .csrf(csrf -> csrf.disable())
	    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	    .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/signup","/login").permitAll()
	            .requestMatchers("/api/admin/**").hasRole("ADMIN")
	            .requestMatchers("/api/trainer/**").hasAnyRole("TRAINER","ADMIN")
	            .requestMatchers("/api/member/**").hasAnyRole("MEMBER","ADMIN","TRAINER")
//	            .requestMatchers("/api/**").hasAnyRole("MEMBER","ADMIN","TRAINER")
	            .anyRequest().authenticated()
	        )
	        .addFilter(jwtAuthFilter)
	        .addFilterBefore(new JwtAuthorizationFilter(jwtUtil, userDetailsService), 
	        		UsernamePasswordAuthenticationFilter.class)
	        .logout(logout -> logout
	        		.logoutUrl("/logout")
	        		.permitAll());
	 
	    return http.build();
	}
}
