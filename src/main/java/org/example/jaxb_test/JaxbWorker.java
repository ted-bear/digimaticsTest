package org.example.jaxb_test;

import org.example.model.Companies;
import org.example.model.Company;
import org.example.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JaxbWorker {

    public static void main(String[] args) {
        String fileName = "companies.xml";

        Employee employee = new Employee();
        employee.setBirthday(new Date());
        employee.setLastname("Smith");
        employee.setName("Tim");
        employee.setSurname("Lala");

        List<Employee> list = new ArrayList<>();
        list.add(employee);

        Company company1 = new Company();
        company1.setName("NN");
        company1.setDateOfCreation(new Date());
        company1.setStatus(true);
        company1.setEmployees(list);

        Company company2 = new Company();
        company2.setName("AA");
        company2.setDateOfCreation(new Date());
        company2.setStatus(false);
        company2.setEmployees(list);


        Companies companies = new Companies();
        companies.addCompany(company1);

        convertObjectToXml(companies, fileName);

        Companies unmarshCompany = fromXmlToObject(fileName);
        if (unmarshCompany != null) {
            for (Company company : unmarshCompany.getCompanies()) {
                if (company.isStatus()) {
                    System.out.println(company);
                }
            }
        }
    }


    private static Companies fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Companies.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Companies) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void convertObjectToXml(Companies company, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Companies.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(company, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}