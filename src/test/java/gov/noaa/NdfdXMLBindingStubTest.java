package gov.noaa;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest  {

    @Test
    void latLonListZipCode() throws Exception {

        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
        String response = binding.latLonListZipCode("53562");
        JAXBContext context = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
        assertEquals("43.1029,-89.5063", dwml.latLonList);
    }
}