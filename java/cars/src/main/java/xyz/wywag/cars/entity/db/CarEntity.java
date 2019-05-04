package xyz.wywag.cars.entity.db;

/**
 * @author weiyuwang
 * @since 2019/3/24 18:20
 */
public class CarEntity {
    private String carName;
    private String factoryName;
    private String brandName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
