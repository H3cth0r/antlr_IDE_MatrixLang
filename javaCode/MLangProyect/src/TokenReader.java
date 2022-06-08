
/*
*   Token intended to read the tokens on the charstream
*
* */

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenReader {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Method for getting back the array with the tokens to highlight
    public List<Integer> get_tokens(CharStream charStream){
        // Create a lexer that feeds off input CharStream
        MLangLexer mLangLexer = new MLangLexer(charStream);
        mLangLexer.removeErrorListeners();

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream commonTokenStream = new CommonTokenStream(mLangLexer);
        // This gives a list of the found tokens as a list
        commonTokenStream.fill();
        List the_tokens = commonTokenStream.getTokens();

        //System.out.println(the_tokens);                 // all the tokens
        //System.out.println(the_tokens.size());

        // creating iterator to get each CommonToken from the list
        CommonToken iterator = (CommonToken) the_tokens.get(0);

        List<Integer> toks = new ArrayList<Integer>();

        String token_name_iterator = "";
        for(Integer i = 1; i < the_tokens.size(); i++){
            token_name_iterator = iterator.getText();
            if("main".equals(token_name_iterator)){
                toks.add(Integer.valueOf(iterator.getLine()));                      // line
                toks.add(Integer.valueOf(iterator.getCharPositionInLine()));        // char pos
                toks.add(0);                                                        // type
                toks.add(4);                                                        // number of chars
            }else if ("matrix".equals(token_name_iterator)){
                toks.add(Integer.valueOf(iterator.getLine()));                      // line
                toks.add(Integer.valueOf(iterator.getCharPositionInLine()));        // char pos
                toks.add(1);                                                        // type
                toks.add(6);                                                        // number of chars
            }else if ("int".equals(token_name_iterator)){
                toks.add(Integer.valueOf(iterator.getLine()));                      // line
                toks.add(Integer.valueOf(iterator.getCharPositionInLine()));        // char pos
                toks.add(2);                                                        // type
                toks.add(3);                                                        // number of chars
            }else if ("write".equals(token_name_iterator)){
                toks.add(Integer.valueOf(iterator.getLine()));                      // line
                toks.add(Integer.valueOf(iterator.getCharPositionInLine()));        // char pos
                toks.add(3);                                                        // type
                toks.add(5);                                                        // number of chars
            }else if(isNumeric(token_name_iterator)){
                toks.add(Integer.valueOf(iterator.getLine()));                      // line
                toks.add(Integer.valueOf(iterator.getCharPositionInLine()));        // char pos
                toks.add(4);                                                        // type
                toks.add(iterator.getText().length());                              // number of chars
            }
            iterator = (CommonToken) the_tokens.get(i);
        }

        return toks;
    }
}
