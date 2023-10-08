import dev.tbashiyy.antlr.SampleVisitor
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream


fun main() {
    val cs = CharStreams.fromString("2/4*5 + (2 + 5)")
    val lexer = MyLexer(cs)
    val tokens = CommonTokenStream(lexer)
    val parser = MyParser(tokens)

    val tree = parser.exp()

    println("Result: ${SampleVisitor().visit(tree)}")
}