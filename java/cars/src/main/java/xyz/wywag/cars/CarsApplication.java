package xyz.wywag.cars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.wywag.cars.util.LogUtil;

/**
 * @author wyw
 */
@SpringBootApplication
@ComponentScan(basePackages = {"xyz.wywag.cars"})
@MapperScan("xyz.wywag.cars.mapper")
public class CarsApplication {

    public static void main(String[] args) {
        LogUtil.info("Start CarsApplication...");
        SpringApplication.run(CarsApplication.class, args);
        LogUtil.info("CarsApplication is running...");
    }

}

