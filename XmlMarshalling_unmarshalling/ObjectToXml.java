import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class ObjectToXml {
    public static void main(String[] args) {
        //Initialize the employees list
        Tables tables = new Tables();

        private static void marshalingTables() throws JAXBException
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(employees, System.out);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(employees, new File("tables.xml"));
        }

        private static void unMarshalingTables() throws JAXBException
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //We had written this file in marshalling example
            Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("c:/temp/employees.xml") );

            for(Employee emp : emps.getEmployees())
            {
                System.out.println(emp.getId());
                System.out.println(emp.getFirstName());
            }
        }
    }
}
