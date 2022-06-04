import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ThrowingParserErrorListener extends BaseErrorListener {
    public static final ThrowingParserErrorListener INSTANCE = new ThrowingParserErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){

        throw new ParseCancellationException("Syntactic error at line " + line + " : " + charPositionInLine + " " + msg);

    }

}
