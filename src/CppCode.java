import java.io.PrintWriter;


public class CppCode {

    public void generateCode(Parser parser) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(parser.getClassName() + ".cpp", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.println("class " + parser.getClassName() + " {");
        writer.println("public:");
        writer.println("\t" + parser.getMethodSignature() + " {");
        writer.println("\t}");
        writer.println("};");
        writer.close();
    }
}
