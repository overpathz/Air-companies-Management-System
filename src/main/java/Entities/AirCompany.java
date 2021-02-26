package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirCompany {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    // ID SHOULD BE UNUSED. AND ONLY GETTER FOR HIM
    private Long ID;
    private Long foundedAt;
    private String name;
    private String companyType;
    private String type;

    protected AirCompany() {}

    public AirCompany(String name, String companyType, String type, Long foundedAt) {
        this.name = name;
        this.companyType = companyType;
        this.type = type;
        this.foundedAt = foundedAt;
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(Long foundedAt) {
        this.foundedAt = foundedAt;
    }

    @Override
    public String toString() {
        return "AirCompany{" +
                "name='" + name + '\'' +
                ", companyType='" + companyType + '\'' +
                ", type='" + type + '\'' +
                ", foundedAt=" + foundedAt +
                '}';
    }
}
