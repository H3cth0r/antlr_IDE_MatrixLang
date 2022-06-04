import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;



public class AntlrParser {

    public String getTranslation(CharStream charStream){

        // Create a lexer that feeds off input CharStream
        MLangLexer mLangLexer = new MLangLexer(charStream);
        mLangLexer.removeErrorListeners();
        mLangLexer.addErrorListener(ThrowingLexerErrorListener.INSTANCE);           // Adding custom lexical error thrower

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream commonTokenStream = new CommonTokenStream(mLangLexer);
        // This gives a list of the found tokens as a list
        commonTokenStream.fill();
        System.out.println(commonTokenStream.getTokens());

        // Create a parser that feeds off the tokens buffer
        MLangParser mLangParser = new MLangParser(commonTokenStream);
        mLangParser.removeErrorListeners();
        mLangParser.addErrorListener(ThrowingParserErrorListener.INSTANCE);         // Adding custom syntatic error thrower

        // Begin parsing at init rule
        ParseTree parseTree = mLangParser.programDeclaration();

        MyLangListener listener = new MyLangListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);
        return listener.translation;
        //System.out.println(listener.translation);
        // semantic analysis                                                        // Must write own semantics on listener

        //System.out.println();
        //System.out.println(parseTree.toStringTree(mLangParser));

    }
/*
    public static void main (String[] args) throws IOException{
        // Reads from the standard input
        CharStream charStream = CharStreams.fromFileName("./example.ml");

        // Create a lexer that feeds off input CharStream
        MLangLexer mLangLexer = new MLangLexer(charStream);
        mLangLexer.removeErrorListeners();
        mLangLexer.addErrorListener(ThrowingLexerErrorListener.INSTANCE);           // Adding custom lexical error thrower

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream commonTokenStream = new CommonTokenStream(mLangLexer);
        // This gives a list of the found tokens as a list
        commonTokenStream.fill();
        System.out.println(commonTokenStream.getTokens());

        // Create a parser that feeds off the tokens buffer
        MLangParser mLangParser = new MLangParser(commonTokenStream);
        mLangParser.removeErrorListeners();
        mLangParser.addErrorListener(ThrowingParserErrorListener.INSTANCE);         // Adding custom syntatic error thrower

        // Begin parsing at init rule
        ParseTree parseTree = mLangParser.programDeclaration();

        MyLangListener listener = new MyLangListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);
        System.out.println(listener.translation);
        // semantic analysis                                                        // Must write own semantics on listener

        //System.out.println();
        System.out.println(parseTree.toStringTree(mLangParser));
    }*/

}