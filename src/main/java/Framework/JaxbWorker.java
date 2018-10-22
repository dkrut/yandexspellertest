package Framework;

import net.yandex.speller.services.spellservice.CheckTextResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Denis Krutikov on 21.10.2018.
 */

public class JaxbWorker {




    public void convertObjectToXml(Class className, CheckTextResponse response, File file) {

        try {
            JAXBContext context = JAXBContext.newInstance(className);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(response, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}