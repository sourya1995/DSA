package Algorithms.Strings.XMLToTree;

import java.util.ArrayList;
import java.util.List;

public class NodeXML {
    public String nodeName;
    public List<NodeXML> children;

    public NodeXML(String data){
        this.nodeName = data;
        children = new ArrayList<NodeXML>();
    }
}
