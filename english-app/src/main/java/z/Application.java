package z;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("z.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class Application extends SpringBootServletInitializer {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
