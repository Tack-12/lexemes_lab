

public class formattingString {


    public  String removeComments(String code) {
// Regex pattern to remove Javadoc, multi-line, and single-line comments
        // Remove multi-line and Javadoc comments (non-greedy match)
        code = code.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");

        // Remove single-line comments
        code = code.replaceAll("//.*", "");

        return code.trim();
    }
}


