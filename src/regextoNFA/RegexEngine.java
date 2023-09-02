package regextoNFA;

import java.util.Stack;

public class RegexEngine {
    private String regex = "";
    private Stack operatorStack;
    private Stack operandStack;

    public RegexEngine() {
        regex = "";
        operatorStack = new Stack();
        operandStack = new Stack();
    }

    public RegexEngine(String _regex) {
        regex = "";
        operatorStack = new Stack();
        operandStack = new Stack();
        prepareString(_regex);
    }


    public String getRegex() {
        return regex;
    }

    public void setRegex(String _regex) {
        prepareString(_regex);
    }

    /**
     * Before constructing the NFA, it's necessary to preprocess the regular expression.
     * This involves evaluating the current character type and the preceding character to obtain the string with added concatenation symbols.
     * For example, (a|b)*abb becomes (a|b)*&a&b&b after adding the symbols.
     */

    private void prepareString(String _regex) {
        char[] regexs = _regex.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < regexs.length; i++) {
            if (i == 0)
                regex += regexs[i];
            else {
                if (regexs[i] == '|' || regexs[i] == '*' || regexs[i] == ')') {
                    regex += regexs[i];
                } else {
                    if (regexs[i - 1] == '(' || regexs[i - 1] == '|')
                        regex += regexs[i];
                    else
                        regex += ("&" + regexs[i]);
                }
            }
        }
    }

    public Graph transformNFA() {

    }

}
