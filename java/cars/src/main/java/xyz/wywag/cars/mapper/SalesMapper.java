package xyz.wywag.cars.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.wywag.cars.entity.response.KindSalesEntity;
import xyz.wywag.cars.entity.response.TotalSalesEntity;

import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/2/11 11:45
 */
@Mapper
public interface SalesMapper {
    /**
     * 获取所有月份汽车销量
     * @return
     */
    List<TotalSalesEntity> getTotal();

    /**
     * 获取区间月份汽车总销量
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    Integer getTotalWithMonth(@Param("startYear") Integer startYear, @Param("startMonth") Integer startMonth, @Param("endYear") Integer endYear, @Param("endMonth") Integer endMonth);

    /**
     * 获取区间各车型的销量数据总和
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    List<KindSalesEntity> getKind(@Param("startYear") Integer startYear, @Param("startMonth") Integer startMonth, @Param("endYear") Integer endYear, @Param("endMonth") Integer endMonth);

    /**
     * 根据车型是 SUV或者轿车 获取区间各车型的销量数据总和
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @param type
     * @return
     */
    List<KindSalesEntity> getKindWithType(@Param("startYear") Integer startYear, @Param("startMonth") Integer startMonth, @Param("endYear") Integer endYear, @Param("endMonth") Integer endMonth, @Param("type")String type);

    /**
     * 根据车名获取车辆的各月销量
     * @param name
     * @return
     */
    List<KindSalesEntity> getKindByName(@Param("name") String name);

}
