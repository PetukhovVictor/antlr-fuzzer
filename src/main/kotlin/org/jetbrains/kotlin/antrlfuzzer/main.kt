package org.jetbrains.kotlin.antrlfuzzer

import org.jetbrains.kotlin.antrlfuzzer.generator.CodeGen
import org.jetbrains.kotlin.antrlfuzzer.generator.GrammarRulesCollector
import org.jetbrains.kotlin.antrlfuzzer.generator.loadGrammar
import java.io.File

fun main(args: Array<String>) {
    val (lexer, parser) = loadGrammar(
            lexerGrammarPath = "./grammar/KotlinLexer.g4",
            parserGrammarPath = "./grammar/KotlinParser.g4"
    )

    val rulesCollector = GrammarRulesCollector(lexer, parser)

    val (lexerRules, parserRules) = rulesCollector.getRules()

    println("!!!")
    println(lexerRules)

    val codegen = CodeGen(lexerRules, parserRules, rulesCollector.getBaseRule(), maxDepth = 30)

    val code = codegen.gen()

    File("get.kt").writeText(code)

//    val t = ((productionsLexerMap["AtIdentifier"]!!.children[0]!! as GrammarAST).children[1] as GrammarAST).text
//
//    println(productionsLexerMap[t])
//    println(((productionsMap["annotation"]!!.children[0]!! as GrammarAST).children[0] as GrammarAST).children)
}

//            print(" ".repeat(level))
//                println("${it.type} — ${it.text}")