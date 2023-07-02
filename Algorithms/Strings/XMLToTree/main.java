// Importing required functions
import java.util.*;

class XmlTree {
	public static NodeXml createXmlTree(String xml) {
		// parse the received string for XML tokens
		XmlTokenizer tok = new XmlTokenizer(xml);

		XmlElement element = new XmlElement();
		if (!tok.getNextElement(element)) {
			// return null if no tokens are found in parsing
			return null;
		}
		List<NodeXml> st = new ArrayList<NodeXml>();

		// set up the tree root
		NodeXml root = new NodeXml(element.nodeName);

		// push it on to the stack
		st.add(root);

		while (tok.getNextElement(element)) {
			NodeXml n = null;
			// if the current element is an opening tag or a text node
			if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG")
					|| element.elementType == XmlElement.xmlElementType.get("ELEMENT_TEXT")) {
				// set up a node for the tree and...
				n = new NodeXml(element.nodeName);
				// add it to the list of children of the node last pushed on the stack
				st.get(st.size() - 1).children.add(n);
			}
			if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG")) {
				// if the current element is an opening tag, set it up as a tree node on the stack
				// (as it may have children)
				st.add(n);
			} else if (element.elementType == XmlElement.xmlElementType
					.get("ELEMENT_CLOSING_TAG")) {
				// else if the current element is a closing tag, pop from the tag as it has been
				// processed
				st.remove(st.size() - 1);
			}
		}

		// return the root node
		return root;
	}

	// function for printing the tree
	public static void printTree(NodeXml root, int depth, int parentOffset) {
		if (root == null)
			return;

		String spaces = String.join("", Collections.nCopies(parentOffset, " "));
		String underscores = "__";
		parentOffset += 2;

		if (depth > 0) {
			System.out.println(spaces + "|");
			System.out.println(spaces + "|" + underscores + root.nodeName);
		} else {
			System.out.println(root.nodeName + "___");
		}

		for (int x = 0; x < root.children.size(); x++) {
			printTree(root.children.get(x), depth + 1, (parentOffset + 1) + root.nodeName.length());
		}
	}

	public static void main(String[] args) {
		String[] xml = {String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
				"<html>", "    <body>", "        <div>", "            <h1>CodeRust</h1>",
				"                <a>http://coderust.com</a>", "        </div>", "        <div>",
				"            <h2>Chapter 1</h2>", "        </div>", "        <div>",
				"            <h3>Chapter 2</h3>", "            <h4>Chapter 2.1</h4>",
				"        </div>", "    </body>", "</html>"),
				String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", "<xml>",
						"    <data>hello world   </data>", "        <a>", "            <b></b>",
						"            <b>", "                <c></c>", "            </b>",
						"        </a>", "</xml>")};

		for (int i = 0; i < xml.length; i++) {
			System.out.println((i + 1) + ". XML example # " + (i + 1));
			System.out.println(xml[i]);
			System.out.println();
			System.out.println("Tree of example # " + (i + 1));
			NodeXml head = createXmlTree(xml[i]);
			printTree(head, 0, 0);
			System.out.println(
					"\n---------------------------------------------------------------------\n");
		}
	}
}