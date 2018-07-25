package report_aggregator;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/home").setViewName("home");
//		registry.addViewController("/").setViewName("home");
		registry.addViewController("/").setViewName("dashboard");
//		registry.addViewController("/dashboard").setViewName("dashboard");
		registry.addViewController("/login").setViewName("login");
	}


}



//
//	@GetMapping("/app/")
//	public String index(Model model) {
//		model.addAttribute("now", LocalDateTime.now());
//		return "index";
//	}
//
//	@GetMapping("/app/home")
//	public String index(Model model) {
//		model.addAttribute("now", LocalDateTime.now());
//		return "index";
//	}
//
//	@GetMapping("/app/login")
//	public String login() {
//		return "login";
//	}
//
//	@GetMapping("/app/dashboard")
//	public String dashboard() {
//		return "dashboard";
//	}