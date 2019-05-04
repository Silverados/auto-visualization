package xyz.wywag.cars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wywag.cars.entity.response.KindSalesEntity;
import xyz.wywag.cars.entity.response.TotalSalesEntity;
import xyz.wywag.cars.mapper.SalesMapper;
import xyz.wywag.cars.service.SalesService;
import xyz.wywag.cars.util.JsonUtil;

import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/2/11 11:43
 */
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    SalesMapper salesMapper;

    @Override
    public String getTotal() {
        List<TotalSalesEntity> list = salesMapper.getTotal();
        return JsonUtil.toJson(list);
    }

    @Override
    public String getKind(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth) {
        List<KindSalesEntity> list = salesMapper.getKind(startYear,startMonth,endYear,endMonth);
        return JsonUtil.toJson(list);
    }

    @Override
    public String getKindWithType(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth, String type) {
        List<KindSalesEntity> list = salesMapper.getKindWithType(startYear,startMonth,endYear,endMonth,type);
        return JsonUtil.toJson(list);
    }

    @Override
    public String getSalesWithName(String name) {
        List<KindSalesEntity> list = salesMapper.getKindByName(name);
        return JsonUtil.toJson(list);
    }
}
