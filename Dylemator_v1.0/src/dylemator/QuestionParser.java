/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dylemator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;
/**
 *
 * @author a144899
 */
public class QuestionParser {
        
        
    private final List<Dilemma> dilemmaList = new ArrayList<Dilemma>(); 
    boolean xmlFileOk = true;
    private final List<Dilemma> warmupList = new ArrayList<Dilemma>();

    public boolean isXmlFileOk() {
        return xmlFileOk;
    }
    
    
    public QuestionParser(File fXmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;        
                
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList dilemmas = doc.getElementsByTagName("dilemma");
            for(int i = 0;i < dilemmas.getLength();i++){
                Node elem = dilemmas.item(i);
                NamedNodeMap attrs = elem.getAttributes();
                Node type = attrs.getNamedItem("type");
                Dilemma d = new Dilemma();
                d.setType(type.getTextContent());
                NodeList subElems = elem.getChildNodes();
                for(int j = 0; j < subElems.getLength();j++){
                   Node subElem = subElems.item(j);
                   if(subElem.getNodeType() != Node.ELEMENT_NODE)
                        continue;
                    
                    String name = subElem.getNodeName();
                    if(name.equals("name"))
                        d.setName(subElem.getTextContent());
                    else if(name.equals("description"))
                        d.setDescription(subElem.getTextContent());
                    else if(name.equals("problem"))
                        d.setProblem(subElem.getTextContent());
                    else if(name.equals("question"))
                        d.setQuestion(subElem.getTextContent());
                        
                }
                if(d.getType().equals("warmup"))
                   warmupList.add(d);
                else
                   dilemmaList.add(d);
                
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(QuestionParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QuestionParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(QuestionParser.class.getName()).log(Level.SEVERE, null, ex);
        }

            
       
    }

    /**
     * @return the dList
     */
    public List<Dilemma> getDilemmaList() {
        return dilemmaList;
    }

    public List<Dilemma> getWarmupList() {
        return warmupList;
    }
    
        
}
