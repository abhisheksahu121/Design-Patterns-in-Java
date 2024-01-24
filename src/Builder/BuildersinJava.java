package Builder;

import java.util.ArrayList;
import java.util.Collections;
class HtmlElement
{
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {

    }

    public HtmlElement(String name, String text)
    {
        this.name = name;
        this.text = text;
    }

private String toStringImpl(int indent)
{
StringBuilder sb = new StringBuilder();
String i = String.join("", Collections.nCopies(indent * indentSize, " "));
sb.append(String.format("%s<%s>%s", i, name, newLine));
if (text != null && !text.isEmpty())
{
  sb.append(String.join("", Collections.nCopies(indentSize*(indent+1), " ")))
    .append(text)
    .append(newLine);
}

for (HtmlElement e : elements)
  sb.append(e.toStringImpl(indent + 1));

sb.append(String.format("%s</%s>%s", i, name, newLine));
return sb.toString();
}
@Override
public String toString()
{
return toStringImpl(0);
}
}

class HtmlBuilder
{
private String rootName;
private HtmlElement root = new HtmlElement();

public HtmlBuilder(String rootName)
{
    this.rootName = rootName;
    root.name = rootName;
}

public void addChild(String childName, String childText)
{
    HtmlElement e = new HtmlElement(childName, childText);
    root.elements.add(e);
}

public void clear()
{
    root = new HtmlElement();
    root.name = rootName;
}

@Override
public String toString() {
    return root.toString();
}
}
// so lets suppose we are making some sort of application for serving web pages.
public class BuildersinJava {
   
    public static void main(String[] args) {
        //so lets suppose we are output a string as a paragraph
        // String hello = "hello";
        // System.out.println("<p>" + hello + "</p>");
        // now lets imagine that the situation become more complicated
        //suppose we have a list and we want to output a list of words.
        // so if you do this by creating array of string and print them or concatinate them, its became more complicated
        // so for simplicity we use Blider called a string builder.

        //stringBuilder - the string builder is used for building string out of different components.
        //and the key point about builder is that the construction of an object the builder build happens not in a single call,
        //but through several functions, several operations so it is a piecewise process of construction.
        //Builder allow you to build up your object piece by piece.

        // String [] words = {"hello", "world"};
        // StringBuilder sb = new StringBuilder();
        // sb.append("<ul>\n");
        // for(String word : words)
        // {
        //     sb.append(String.format("<li>%s</li>\n", word));
        // }
        // sb.append("</ul>");
        // System.out.println(sb);

        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);

    }
}
