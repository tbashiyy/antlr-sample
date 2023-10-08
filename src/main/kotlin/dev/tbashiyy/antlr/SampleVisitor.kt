package dev.tbashiyy.antlr

import MyParserBaseVisitor

class SampleVisitor : MyParserBaseVisitor<Double>() {
    override fun visitExp(ctx: MyParser.ExpContext?): Double {
        return when {
            ctx?.NUM() != null -> {
                println("Num: ${ctx.NUM().text}")
                ctx.NUM().text.toDouble()
            }
            ctx?.LR_BRACKET() != null && ctx.RR_BRACKET() != null -> {
                println("BRACKET: ${ctx.exp()}")
                visitExp(ctx.exp(0))
            }
            ctx?.PLUS() != null -> {
                println("plus: ${ctx.exp().map { it.text }}")
                visitExp(ctx.exp(0)) + visitExp(ctx.exp(1))
            }
            ctx?.MINUS() != null -> {
                println("minus: ${ctx.exp().map { it.text }}")
                visitExp(ctx.exp(0)) - visitExp(ctx.exp(1))
            }
            ctx?.MULTIPLE() != null -> {
                println("multiple: ${ctx.exp().map { it.text }}")
                visitExp(ctx.exp(0)) * visitExp(ctx.exp(1))
            }
            ctx?.DIVISION() != null -> {
                println("division: ${ctx.exp().map { it.text }}")
                visitExp(ctx.exp(0)) / visitExp(ctx.exp(1))
            }
            else -> throw Exception("UNKNOWN")
        }
    }
}