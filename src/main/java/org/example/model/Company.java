package org.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@XmlType(propOrder = { "name", "dateOfCreation", "status", "employees" })
public class Company {

    private String name;
    private Date dateOfCreation;
    private boolean status;
    private List<Employee> employees  = new ArrayList<>();

    public Company() {}

    public Company(String name, Date dateOfCreation, boolean status) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String id) {
        this.name = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    @XmlElement(name = "dateOfCreation")
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public boolean isStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @XmlElement(name = "employees")
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return status == company.status && Objects.equals(name, company.name) && Objects.equals(dateOfCreation, company.dateOfCreation) && Objects.equals(employees, company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfCreation, status, employees);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", status=" + status +
                ", employees=" + employees +
                '}';
    }
}
