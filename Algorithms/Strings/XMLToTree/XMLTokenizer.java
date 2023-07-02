package Algorithms.Strings.XMLToTree;

public class XMLTokenizer {
    String xml;
    int currentIndex;

    XMLTokenizer(String xmlStr) {
        xml = xmlStr;
        currentIndex = 0;
    }

    Boolean getNextElement(XMLElement element) {
        int i = this.xml.substring(currentIndex).indexOf('<');
        if (i == -1)
            return false;

        i += currentIndex;

        String temp = this.xml.substring(currentIndex, i);
        temp = temp.trim();

        if (!temp.isEmpty()) {
            element.nodeName = temp;
            element.elementType = XMLElement.xmlElementType.get("ELEMENT_TEXT");
            currentIndex = i;
            return true;
        }

        int j = this.xml.substring(i).indexOf('>');
        if (j == -1)
            return false;

        j += i;

        if (this.xml.charAt(i + 1) == '/') {
            element.nodeName = this.xml.substring(i + 2, j);
            element.elementType = XMLElement.xmlElementType.get("ELEMENT_CLOSING_TAG");
        } else {
            element.nodeName = this.xml.substring(i + 1, j);
            element.elementType = XMLElement.xmlElementType.get("ELEMENT_OPENING_TAG");
        }

        this.currentIndex = j + 1;
        return true;
    }
}
