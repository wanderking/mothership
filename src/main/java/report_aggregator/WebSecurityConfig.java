package report_aggregator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers( "/api/**", "/js/**", "/images/**", "/css/**", "/vendor/**", "/fonts/**", "/favicon.ico").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		String myPassword = passwordEncoder().encode("");
//		System.out.println(myPassword + " AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		String myPassword = "$2a$10$I3ZdCyNvWhQXfjatuQtI.uWxGU2QPXUV/7HDbN4DFe7tNEqV50Fce";

		auth.inMemoryAuthentication()
				.passwordEncoder(passwordEncoder())
				.withUser("tester").password(myPassword).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}


//
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//				SecurityProperties.User.withDefaultPasswordEncoder()
//						.username("user")
//						.password("password")
//						.roles("USER")
//						.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
//

