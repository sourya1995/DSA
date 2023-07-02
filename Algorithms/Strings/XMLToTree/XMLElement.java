package Algorithms.Strings.XMLToTree;

import java.util.HashMap;

public class XMLElement {
    int elementType;
    String nodeName;
    public static HashMap<String, Integer> xmlElementType = new HashMap<String, Integer>();{
        {
            put("ELEMENT_UNKNOWN", 1);
            put("ELEMENT_OPENING_TAG", 2);
            put("ELEMENT_CLOSING_TAG", 3);
            put("ELEMENT_TEXT", 4);
        }
    };

    XmlElement(){
        elementType = xmlElementType.get("ELEMENT_UNKNOWN");
        nodeName = " ";
    }

}
