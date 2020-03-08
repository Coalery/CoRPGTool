package org.coalery.manager;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class LanguageManager {

    private static HashMap<String, String> languageMap;
    private static Language language;

    public static void init(Language language, String languageFilePath) {
        LanguageManager.language = language;
        languageMap = new HashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc;
        BufferedReader br = null;

        String languageXML;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(languageFilePath + language.name() + ".xml"), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null)
                sb.append(line.trim());
            languageXML = sb.toString();
            InputSource is = new InputSource(new StringReader(languageXML));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expr = xPath.compile("/string");
            NodeList nodeList = ((NodeList)expr.evaluate(doc, XPathConstants.NODESET)).item(0).getChildNodes();
            for(int i=0; i<nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                languageMap.put(node.getNodeName(), node.getTextContent());
            }
        } catch(IOException | ParserConfigurationException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        } finally {
            if(br != null) try { br.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }

    public static String getString(String key) {
        return languageMap.get(key);
    }

}
