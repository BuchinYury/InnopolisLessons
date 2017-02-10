package lesson5.samrab2.serializator;

import java.io.File;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by yuri on 10.02.17.
 */
public class XMLCreator {
//    private Object obj;

    private static String FILENAME;

    public static void createXML(Object obj, String fileName) {

        FILENAME = fileName;

        try {
            Class myClass = obj.getClass();;

            String className = myClass.getName();

            Field[] fields = myClass.getDeclaredFields();

            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();

            Element serialize = document.createElement("serialization");
            document.appendChild(serialize);

            Element object = document.createElement("object");
            serialize.appendChild(object);

            object.setAttribute("type", className);

            for (Field field : fields) {
                field.setAccessible(true);

                int modifiersCode = field.getModifiers();
                if (Modifier.isStatic(modifiersCode)) continue;

                Element fieldElem = document.createElement("field");
                object.appendChild(fieldElem);


                String typeField = field.getType().getName();
                fieldElem.setAttribute("type", typeField);

                String nameField = field.getName();
                fieldElem.setAttribute("id", nameField);

                String valueField = field.get(obj).toString();
                fieldElem.setAttribute("value", valueField);

            }

            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(
                    new File(System.getProperty("user.dir")
                            + File.separator + FILENAME));

            transformer.transform(source, result);

            System.out.println("Документ сохранен!");

        } catch (ParserConfigurationException
                | TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }
}
