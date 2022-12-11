import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class A4_EscrituraDOM {

        public static void main(String[] args) {

            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.newDocument();

                //root element
                Element rootElement = document.createElement("CATALOG");
                document.appendChild(rootElement);

                Element Element = document.createElement("CD");
                rootElement.appendChild(Element);

                Attr cdIdAttr = document.createAttribute("ID");
                cdIdAttr.setValue("1");
                Element.setAttributeNode(cdIdAttr);

                //CD information
                Element titleElement = document.createElement("TITLE");
                titleElement.appendChild(document.createTextNode("PARAÍSO"));
                Element.appendChild(titleElement);

                Element artistElement = document.createElement("ARTIST");
                artistElement.appendChild(document.createTextNode("MORA"));
                Element.appendChild(artistElement);

                Element countryElement = document.createElement("COUNTRY");
                countryElement.appendChild(document.createTextNode("PUERTO RICO"));
                Element.appendChild(countryElement);

                Element companyElement = document.createElement("COMPANY");
                companyElement.appendChild(document.createTextNode("MESSI"));
                Element.appendChild(companyElement);

                Element priceElement = document.createElement("PRICE");
                priceElement.appendChild(document.createTextNode("FREE"));
                Element.appendChild(priceElement);

                Element yearElement = document.createElement("YEAR");
                yearElement.appendChild(document.createTextNode("2022"));
                Element.appendChild(yearElement);

                //creation xml
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File("escrituraDOM.xml"));

                transformer.transform(source,result);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

