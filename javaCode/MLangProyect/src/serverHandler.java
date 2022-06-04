import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import py4j.*;

import java.util.List;

/*
*   This handler is in charger of applying some methods and sending data to python
* */

public class serverHandler {

    public int addition(int first, int second) {
        return first + second;
    }

    // Methods that gets the tokens from python text input and
    public List<Integer> getTokens(String txt_code){
        TokenReader tokenReader = new TokenReader();
        CharStream charStream = null;
        charStream = CharStreams.fromString(txt_code);
        List<Integer> res = tokenReader.get_tokens(charStream);
        return res;
    }
    public String getTranslation(String txt_code){
        AntlrParser antlrParser = new AntlrParser();
        CharStream charStream = null;
        charStream = CharStreams.fromString(txt_code);
        return antlrParser.getTranslation(charStream);
    }


    public static void main(String[] args) {
        serverHandler app = new serverHandler();
        // app is now the gateway.entry_point
        GatewayServer server = new GatewayServer(app);
        server.start();
        System.out.println("ServerRunning");
    }
}
