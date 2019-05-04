package xyz.wywag.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.wywag.cars.service.ParamService;

/**
 * @author weiyuwang
 * @since 2019/3/24 20:11
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/cars", produces = "application/json;charset=UTF-8")
public class ParamController {

    @Autowired
    ParamService paramService;

    @RequestMapping(value = "/tree", method = {RequestMethod.GET})
    public String getTreeOptionData() {
        return paramService.makeTree();
    }
}
