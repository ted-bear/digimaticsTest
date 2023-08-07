package org.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Companies")
public class Companies {
    private List<Company> companies;

    public Companies() {}

    public Companies(List<Company> companies) {
        this.companies = companies;
    }

    public void addCompany(Company company) {
        if (companies == null) {
            companies = new ArrayList<>();
        }
        companies.add(company);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @XmlElement(name = "company")
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
