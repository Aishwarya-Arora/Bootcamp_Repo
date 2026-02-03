// Demonstrate the use of repeat(), strip(), isBlanck(), indent(), transform(), stripIndent(), translateEscapes(), tripleQuotes and formatted() methods
public class Ques4 {

    public static void main(String[] args) {

        // repeat() is used to repeat a particular string the no of times we specify
        String r = "Hi ".repeat(3);
        System.out.println("repeat(): " + r);

        // strip() is used to remove unwanted whitespace from a string.It removes the tabs,new lines etc.
        String s1 = "   Java String   ";
        System.out.println("strip(): '" + s1.strip() + "'");

        // isBlank() is used to check whether the string is blank or not
        String s2 = "   ";
        System.out.println("isBlank(): " + s2.isBlank());

        // indent() is used to indent the code with the no. of spaces specified
        String s3 = "Line1\nLine2";
        System.out.println("indent():\n" + s3.indent(4));

        // transform() is a string method which is used to create a new transformed string
        String t = "java";
        String result = t.transform(x -> x.toUpperCase());
        System.out.println("transform(): " + result);

        // stripIndent() with text block
        //stripIndent() is used to remove common leading indentation from all lines of a multi-line string
        String block1 = """
                A
                    B
                    C
                """;
        System.out.println("stripIndent():\n" + block1.stripIndent());

        // translateEscapes() is used to convert escape sequences written as text into their actual characters
        String esc = "Hello\\nWorld";
        System.out.println("translateEscapes():");
        System.out.println(esc.translateEscapes());

        // triple quotes (Text Block)
        String textBlock = """
                This is a
                multi-line
                text block
                """;
        System.out.println("Triple Quotes Text Block:\n" + textBlock);

        // formatted() is more readable as compared to String.format
        String name = "Sonu";
        int marks = 90;
        String msg = "Name: %s, Marks: %d".formatted(name, marks);
        System.out.println("formatted(): " + msg);
    }
}