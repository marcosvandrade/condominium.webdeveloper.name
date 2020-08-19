package com.siscondominio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import com.nelioalves.cursomc.security.JWTAuthenticationFilter;
// import com.nelioalves.cursomc.security.JWTAuthorizationFilter;
// import com.nelioalves.cursomc.security.JWTUtil;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired
	// private UserDetailsService userDetailsService;
	
	// @Autowired
    // private Environment env;
	
	// @Autowired
	// private JWTUtil jwtUtil;
	
	private static final String[] PUBLIC_MATCHERS = {
			"/api/**"
	};

	// private static final String[] PUBLIC_MATCHERS_GET = {
	// 		"/produtos/**",
	// 		"/categorias/**",
	// 		"/estados/**"
	// };

	// private static final String[] PUBLIC_MATCHERS_POST = {
	// 		"/clientes/**",
	// 		"/auth/forgot/**"
	// };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
        //     http.headers().frameOptions().disable();
        // }
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			// .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			// .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();
			// .antMatchers("/*/admin/**").hasRole("ADMIN")
		// http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		// http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		   http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	// @Override
	// public void configure(AuthenticationManagerBuilder auth) throws Exception {
	// 	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	// }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		// configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
