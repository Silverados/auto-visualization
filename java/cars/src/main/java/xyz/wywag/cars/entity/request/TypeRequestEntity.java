package xyz.wywag.cars.entity.request;

/**
 * @author weiyuwang
 * @since 2019/2/21 11:44
 */
public class TypeRequestEntity {
    private Integer startYear;
    private Integer startMonth;
    private Integer endYear;
    private Integer endMonth;
    private String type;

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
