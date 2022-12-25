package project.xmlproject.dto.creationDto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReportDatesDto {
    private String startDate;
    private String endDate;

    public ReportDatesDto() {

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
