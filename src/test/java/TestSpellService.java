import Framework.JaxbWorker;
import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.CheckTextResponse;
import net.yandex.speller.services.spellservice.SpellService;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Denis Krutikov on 21.10.2018.
 */

public class TestSpellService {
    SpellService spellService = new SpellService();
    CheckTextRequest request = new CheckTextRequest();
    CheckTextResponse response = new CheckTextResponse();
    JaxbWorker jaxbWorker = new JaxbWorker();



    @Test
    void testic() throws JAXBException, ParserConfigurationException, SAXException, IOException {
        request.setText("слнyце");
        request.setLang("ru");
        request.setFormat("html");
        request.setOptions(1);

        response = spellService.getSpellServiceSoap().checkText(request);


        File file = new File("C:\\test\\qwe.xml");


        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(CheckTextResponse.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(response, file);

        marshaller.marshal(response, writer);
        String result = writer.toString();
        System.out.println(result);


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element wrong = (Element) document.getElementsByTagName("s");
//        String spellResult = wrong.getAttribute("SpellResult");



    }

    @Test
    void asd(){
        File file = new File("C:\\test\\qwe.xml");
        request.setText("кaлас");
        response = spellService.getSpellServiceSoap().checkText(request);

        jaxbWorker.convertObjectToXml(CheckTextResponse.class, response, file);
    }


}
