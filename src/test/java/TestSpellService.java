import Framework.JaxbWorker;
import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.CheckTextResponse;
import net.yandex.speller.services.spellservice.SpellService;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by Denis Krutikov on 21.10.2018.
 */

public class TestSpellService {
    SpellService spellService = new SpellService();
    CheckTextRequest request = new CheckTextRequest();
    CheckTextResponse response = new CheckTextResponse();
    JaxbWorker jaxbWorker = new JaxbWorker();



    @Test
    void testTest() throws JAXBException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        request.setText("малк");
        request.setLang("ru");
//        request.setFormat("html");
//        request.setOptions(1);

        response = spellService.getSpellServiceSoap().checkText(request);

        File file = new File("src/test/resources/response.xml");

        jaxbWorker.convertObjectToXml(CheckTextResponse.class, response, file);

//        StringWriter writer = new StringWriter();
//
//        JAXBContext context = JAXBContext.newInstance(CheckTextResponse.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(response, writer);
//        String result = writer.toString();
//        System.out.println(result);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document xmlDocument = builder.parse(file);

        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//s";

//Выбрать только первый элемент
//        String s = xPath.compile(expression).evaluate(xmlDocument);
//        System.out.println(s);

//Выбрать все элементы
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        List<String> list = new LinkedList<String>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            list.add(nodeList.item(i).getFirstChild().getNodeValue());
        }

        assertThat(list, hasItems("Марк", "мал"));

    }
}