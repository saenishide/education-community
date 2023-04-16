package com.education.community.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// CSRF保護を有効
		http.csrf();
		// セキュリティヘッダーをレスポンスに追加
		http.headers(header -> {header.frameOptions().disable();});
		
		http.formLogin(login -> login
			.loginProcessingUrl("/login") // ユーザー名・パスワードの送信先URL
			.loginPage("/login") // ログイン画面のURL
			.defaultSuccessUrl("/") // ログイン成功時URL
			.failureUrl("login") // ログイン失敗時URL
			.permitAll() // ログイン画面は未ログインでもアクセス可能
		).logout(logout -> logout
			.logoutSuccessUrl("/logout") // ログアウト成功後URL
		).authorizeHttpRequests(auth -> auth
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
			.requestMatchers("/").permitAll()
			.requestMatchers("/topic").permitAll()
			.requestMatchers("/topic/detail").permitAll()
			.requestMatchers("/signup").permitAll()
			.requestMatchers("/admin").hasRole("ADMIN")
			.anyRequest().authenticated()
		)
		;

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
