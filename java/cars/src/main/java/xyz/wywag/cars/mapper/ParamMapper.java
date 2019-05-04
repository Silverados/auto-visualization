package xyz.wywag.cars.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.wywag.cars.entity.db.CarEntity;

import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/3/24 17:27
 */
public interface ParamMapper {

    @Select({"SELECT `car_name`,`factory_name`,`brand_name` FROM `car_param` order BY brand_name,factory_name"})
    List<CarEntity> listCars();
}
