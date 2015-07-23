
public class Main {

	public static void main(String[] args) throws Exception {

		Parser parser = new Parser();
		String statement = parser.readBuffer();
		parser.parseStatement(statement);
		CppCode pyCode = new CppCode();
		pyCode.generateCode(parser);
	}
}