package xyz.wywag.cars.service;

import org.springframework.stereotype.Service;

/**
 * @author weiyuwang
 * @since 2019/2/11 11:43
 */
@Service
public interface SalesService {
    String getTotal();

    String getKind(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth);

    String getKindWithType(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth, String type);

    String getSalesWithName(String name);
}

