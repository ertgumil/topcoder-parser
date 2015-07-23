import java.io.PrintWriter;

public class PythonCode {

	public void generateCode(Parser parser) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(parser.getClassName() + ".py", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		writer.println("class " + parser.getClassName() + ":");
		writer.println("\t" + parser.getMethodSignature() + "\n");
		writer.println("if __name__ == '__main__':");
		writer.println("\tobj = " + parser.getClassName() + "()");
		writer.println("\tobj." + parser.getMethodName() + "()");
		writer.close();
	}
}
