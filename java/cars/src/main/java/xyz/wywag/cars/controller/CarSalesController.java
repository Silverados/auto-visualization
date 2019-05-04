package xyz.wywag.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import xyz.wywag.cars.entity.request.KindRequestEntity;
import xyz.wywag.cars.entity.request.TypeRequestEntity;
import xyz.wywag.cars.service.SalesService;

/**
 * @author weiyuwang
 * @since 2019/2/1 00:21
 */
@RestController
@EnableAspectJAutoProxy
@CrossOrigin
@RequestMapping(value = "/sales", produces = "application/json;charset=UTF-8")
public class CarSalesController {

    @Autowired
    SalesService salesService;

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public String getTotal() {
        return salesService.getTotal();
    }

    @RequestMapping(value = "/kind", method = RequestMethod.POST)
    public String getKind(KindRequestEntity entity) {
        return salesService.getKind(entity.getStartYear(), entity.getStartMonth(), entity.getEndYear(), entity.getEndMonth());
    }

    @RequestMapping(value = "/type", method = RequestMethod.POST)
    public String getType(TypeRequestEntity entity) {
        return salesService.getKindWithType(entity.getStartYear(), entity.getStartMonth(), entity.getEndYear(), entity.getEndMonth(), entity.getType());
    }

    @RequestMapping(value = "/name={name}", method = RequestMethod.GET)
    public String getName(@PathVariable String name) {
        return salesService.getSalesWithName(name);
    }

}
