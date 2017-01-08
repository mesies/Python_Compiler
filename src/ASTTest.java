import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.Start;


public class ASTTest
{
  public static void main(String[] args)
  {
    try
    {
      Parser parser = 
        new Parser(
        new Lexer(
        new PushbackReader(
        new FileReader("example.py"), 1024)));

      Start ast = parser.parse();
      PreVisitor p = new PreVisitor();
      ast.apply(new ASTPrinter());
      ast.apply(p);
      ast.apply(new PostVisitor(p.getSymTable()));
      
//      System.out.println(ast);
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}

