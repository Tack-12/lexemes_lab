import java.util.regex.*;
import java.util.*;

public class tokenizing {

    private static final Set<String> KEYWORDS = Set.of(
            "class", "constructor", "function", "method", "field", "static", "var",
            "int", "char", "boolean", "void", "true", "false", "null", "this",
            "let", "do", "if", "else", "while", "return"
    );

    // Define Jack symbols
    private static final Set<Character> SYMBOLS = Set.of(
            '{', '}', '(', ')', '[', ']', '.', ',', ';', '+', '-', '*', '/', '&', '|', '<', '>', '=', '~'
    );

    public static String tokenizeJackCode(String code) {

        StringBuilder xmlOutput = new StringBuilder("<tokens>\n");

        // Define regex for different token types
        String tokenRegex = "\"[^\"]*\"|\\d+|[a-zA-Z_][a-zA-Z0-9_]*|[{}()\\[\\].,;+\\-*/&|<>=~]";
        Pattern pattern = Pattern.compile(tokenRegex);
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String token = matcher.group();

            if (KEYWORDS.contains(token)) {
                xmlOutput.append("<keyword> ").append(token).append(" </keyword>\n");
            } else if (SYMBOLS.contains(token.charAt(0))) {
                String xmlSymbol = switch (token) {
                    default -> token;
                };
                xmlOutput.append("<symbol> ").append(xmlSymbol).append(" </symbol>\n");
            } else if (token.matches("\\d+")) { // Integer constant
                xmlOutput.append("<integerConstant> ").append(token).append(" </integerConstant>\n");
            } else if (token.startsWith("\"")) { // String constant
                xmlOutput.append("<stringConstant> ").append(token.replaceAll("\"", "")).append(" </stringConstant>\n");
            } else { // Identifiers
                xmlOutput.append("<identifier> ").append(token).append(" </identifier>\n");
            }
        }

        xmlOutput.append("</tokens>");
        return xmlOutput.toString();
    }
}

