package xyz.wywag.cars.entity.response;

/**
 * @author weiyuwang
 * @since 2019/2/11 11:46
 */
public class TotalSalesEntity {
    private Integer year;
    private Integer month;
    private Integer sales;

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
