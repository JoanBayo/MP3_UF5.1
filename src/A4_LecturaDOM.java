import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class A4_LecturaDOM {
    public static void main(String[] args) {


        //LLEGIR EL DOCUMENT XML
        try {
            //Get document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Build Document
            Document document = builder.parse(new File("cd_catalog.xml"));

            //Normalize the XML Structure; It's just to important!
            document.getDocumentElement().normalize();

            //Here comes the road Nodepublic class
            NodeList nList = document.getElementsByTagName("CD's");

            //Get the CD
            System.out.println("===========================");
            System.out.println("CD Number: " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                System.out.println("");
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    //Print each CD's details
                    Element eElement = (Element) node;
                    System.out.println("TITLE: " + eElement.getElementsByTagName("TITLE").item(0).getTextContent());
                    System.out.println("ARTIST: " + eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
                    System.out.println("COUNTRY: " + eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
                    System.out.println("COMPANY: " + eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
                    System.out.println("PRICE: "+ eElement.getElementsByTagName("PRICE").item(0).getTextContent());
                    System.out.println("YEAR: "+ eElement.getElementsByTagName("YEAR").item(0).getTextContent());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
