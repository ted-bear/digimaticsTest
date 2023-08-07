package org.example.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String lastname;
    private String surname;
    private Date birthday;
    private List<Company> companyIds = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    public Employee() {}

    public Employee(String name, String lastname, String surname, Date birthday) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement(name = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement(name = "companyIds")
    public void setCompanyIds(List<Company> companyIds) {
        this.companyIds = companyIds;
    }

    public List<Company> getCompanyIds() {
        return companyIds;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    @XmlElement(name = "lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", companyIds=" + companyIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(lastname, employee.lastname) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(birthday, employee.birthday) &&
                Objects.equals(companyIds, employee.companyIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, surname, birthday, companyIds);
    }
}
