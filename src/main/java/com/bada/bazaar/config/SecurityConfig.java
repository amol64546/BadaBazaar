//package com.bada.bazaar.config;
//
//import com.bada.bazaar.service.Impl.SellerServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//  private final SellerServiceImpl sellerService;
//  private final JwtAuthFilter jwtAuthFilter;
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
//    return http
//        .cors(AbstractHttpConfigurer::disable)
//        .csrf(AbstractHttpConfigurer::disable)
//        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .authorizeHttpRequests(auth -> auth
////            .requestMatchers(HttpMethod.POST, "/sellers/**").permitAll()
////            .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
////            .requestMatchers(HttpMethod.GET, "/swagger/**").permitAll()
////            .anyRequest().authenticated())
//            .anyRequest().permitAll())
//        .authenticationManager(authenticationManager)
//      .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//      .build();
//  }
//
//  @Bean
//  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//    authenticationManagerBuilder.userDetailsService(sellerService).passwordEncoder(passwordEncoder());
//    return authenticationManagerBuilder.build();
//  }
//}