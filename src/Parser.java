import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String className;
    private String methodName;
    private String methodSignature;
    private String paramethers;
    private String problemStatement;
    private List<String> paramethersList;
    
    public String readBuffer() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String buffer = "";
        try {
            buffer = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;     
    }
    
    public void parseStatement(String statement) {
        
        String pattern_className = "Class:\n(.*?)\nMethod:";
        String pattern_methodSignature = "Method signature:\n(.*?)\n\nLimits";
        String pattern_methodName = "Method:\n(.*?)\nParameters:";
        String pattern_paramethers = "Parameters:\n(.*?)\nReturns:";
        Pattern r = Pattern.compile(pattern_className);
        Matcher m = r.matcher(statement);
        
        if (m.find( )) {
            this.setClassName(m.group(1));
        }

        r = Pattern.compile(pattern_methodSignature);
        m = r.matcher(statement);
        if (m.find( )) {
            this.setMethodSignature(m.group(1));
        }

        r = Pattern.compile(pattern_methodName);
        m = r.matcher(statement);
        if (m.find( )) {
            this.setMethodName(m.group(1));
        }
        
        r = Pattern.compile(pattern_paramethers);
        m = r.matcher(statement);
        if (m.find( )) {
            this.paramethers =  m.group(1);
            this.paramethers = this.paramethers.replaceAll("\\s","");
            this.setParamethersList(Arrays.asList(this.paramethers.split(",")));
        }
        System.out.println(this.getMethodSignature());
        System.out.println(this.getClassName());

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodSignature() {
        return methodSignature;
    }

    public void setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
    }

    public List<String> getParamethersList() {
        return paramethersList;
    }

    public void setParamethersList(List<String> paramethersList) {
        this.paramethersList = paramethersList;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }
}
