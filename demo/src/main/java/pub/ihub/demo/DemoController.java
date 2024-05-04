package pub.ihub.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liheng
 * @since 2024/5/4
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/hello")
	public String sayHello() {
		log.info("say hello");
		return "hello,world";
	}

}
