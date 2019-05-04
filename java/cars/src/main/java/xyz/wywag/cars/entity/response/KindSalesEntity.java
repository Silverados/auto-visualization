package xyz.wywag.cars.entity.response;

/**
 * @author weiyuwang
 * @since 2019/2/20 17:44
 */
public class KindSalesEntity {
    private String carName;
    private Integer year;
    private Integer month;
    private Integer sales;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
