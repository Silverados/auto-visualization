package xyz.wywag.cars.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wywag.cars.CarsApplication;

import static org.junit.Assert.*;

/**
 * @author weiyuwang
 * @since 2019/3/24 20:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarsApplication.class)
public class ParamServiceTest {

    @Autowired
    private ParamService paramService;

    @Test
    public void makeTree() {
        System.out.println(paramService.makeTree());
    }
}