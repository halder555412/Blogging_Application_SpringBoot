//package com.codewithsajal.blog.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.codewithsajal.blog.security.CustomUserDetailService;
//import com.codewithsajal.blog.security.JwtAuthenticationEntryPoint;
//import com.codewithsajal.blog.security.JwtAuthenticationFilter;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Autowired
//	private CustomUserDetailService customUserDetailService;
//	
//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticatinEntryPoint;
//	
//	@Autowired
//	private JwtAuthenticationFilter authenticationFilter;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.
//		csrf().
//		disable().
//		authorizeHttpRequests().
//		antMatchers("api/v1/auth/login").permitAll().
//		anyRequest().
//		authenticated().
//		and().
//		exceptionHandling().authenticationEntryPoint(jwtAuthenticatinEntryPoint).
//		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {	
//		return super.authenticationManagerBean();
//	}
//	
//	
//	
//	
//}
