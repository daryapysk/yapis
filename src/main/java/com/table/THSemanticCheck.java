package com.table;

import org.antlr.v4.runtime.tree.*;
import com.generated.*;

public class THSemanticCheck extends tableBaseVisitor<Boolean> {
    
    private ParseTreeProperty<TYPE> typeNode = new ParseTreeProperty<>();

    public enum TYPE {NUMBER, BOOLEAN, STRING, DOUBLE};

    @Override public Boolean visitPrintExpr(tableParser.PrintExprContext ctx) {
        boolean res = visit(ctx.expr());
        if(res && typeNode.get(ctx.expr()) != TYPE.NUMBER)
        {
            ErrorHandling.printError(ctx, "type expression " + ctx.expr().getText() + " is not a number!");
            res = false;
        }
        else if(res && typeNode.get(ctx.expr()) != TYPE.BOOLEAN)
        {
            ErrorHandling.printError(ctx, "type expression " + ctx.expr().getText() + " is not a boolean!");
            res = false;
        }
        else if(res && typeNode.get(ctx.expr()) != TYPE.STRING)
        {
            ErrorHandling.printError(ctx, "type expression " + ctx.expr().getText() + " is not a string!");
            res = false;
        }
        return res;
    }

    @Override public Boolean visitBoolExpr(tableParser.BoolExprContext ctx) { 
        typeNode.put(ctx, TYPE.BOOLEAN);
        return true;
    }

    @Override public Boolean visitIfStatement(tableParser.IfStatementContext ctx) { 
        typeNode.put(ctx, TYPE.BOOLEAN);
        boolean res = visit(ctx.boolExpr());
        if (res && typeNode.get(ctx.boolExpr()) != TYPE.BOOLEAN)
        {
            ErrorHandling.printError(ctx, "condition "+ctx.boolExpr().getText()+" is not a boolean!");
            res = false;
        }
        res = visit(ctx.conditionBlock()) && res;

        return res;
    }

    @Override public Boolean visitElseIfList(tableParser.ElseIfListContext ctx) {
        typeNode.put(ctx, TYPE.BOOLEAN);
        boolean res = visit(ctx.boolExpr());
        if (res && typeNode.get(ctx.boolExpr()) != TYPE.BOOLEAN)
        {
            ErrorHandling.printError(ctx, "condition "+ctx.boolExpr().getText()+" is not a boolean!");
            res = false;
        }
        res = visit(ctx.conditionBlock()) && res;

        return res;
    }

    @Override public Boolean visitArithm(tableParser.ArithmContext ctx) {
        typeNode.put(ctx, TYPE.NUMBER);
        boolean res = true;
        for(int i = 0; i <= 1; i++) {
            res = visit(ctx.numExpr(i)) && res;
            if (res && typeNode.get(ctx.numExpr(i)) != TYPE.NUMBER)
            {
                ErrorHandling.printError(ctx, "condition "+ctx.numExpr(i).getText()+" is not a number!");
                res = false;
            }
        }

        return res;
    }

    @Override public Boolean visitPar(tableParser.ParContext ctx) {
        typeNode.put(ctx, TYPE.NUMBER);
        boolean res = visit(ctx.numExpr());
        if (res)
            typeNode.put(ctx, typeNode.get(ctx.numExpr()));
        return res;
    }

    @Override public Boolean visitInt(tableParser.IntContext ctx) { 
        typeNode.put(ctx, TYPE.NUMBER);
        return true;
    }

    @Override public Boolean visitDouble(tableParser.DoubleContext ctx) { 
        typeNode.put(ctx, TYPE.NUMBER);
        return true;
    }

    @Override public Boolean visitVar(tableParser.VarContext ctx) {
        typeNode.put(ctx, TYPE.NUMBER);
        return true;
    }

    @Override public Boolean visitCompareExpr(tableParser.CompareExprContext ctx) {
        typeNode.put(ctx, TYPE.BOOLEAN);
        boolean res = visit(ctx.numExpr(0));
        res = visit(ctx.numExpr(1)) && res;
        if (res && typeNode.get(ctx.numExpr(0)) != typeNode.get(ctx.numExpr(1))) {
            ErrorHandling.printError(ctx, "operands of different type!");
            res = false;
        }
        else if (res && typeNode.get(ctx.numExpr(0)) == TYPE.BOOLEAN && !("==".equals(ctx.op.getText()) || "!=".equals(ctx.op.getText()))) {
            ErrorHandling.printError(ctx, "operator "+ctx.op.getText()+" not applicable to boolean expressions!");
            res = false;
        }

        return res;
    }

    @Override public Boolean visitNewTable(tableParser.NewTableContext ctx) {
        boolean res = visit(ctx.file());
        if(res && typeNode.get(ctx.file()) != TYPE.STRING)
        {
            ErrorHandling.printError(ctx, " type expression " + ctx.file().getText() + " is not defined!");
            res = false;
        }
        return res;
    }

    @Override public Boolean visitStringExpr(tableParser.StringExprContext ctx) {
        typeNode.put(ctx, TYPE.STRING);
        return true;
    }

    @Override public Boolean visitFile(tableParser.FileContext ctx) { 
        typeNode.put(ctx, TYPE.STRING);
        return true;
    }

    @Override public Boolean visitSetValue(tableParser.SetValueContext ctx) {
        boolean res = visit(ctx.expr());
        if(res && typeNode.get(ctx.expr()) != TYPE.STRING)
        {
            ErrorHandling.printError(ctx, " type expression " + ctx.expr().getText() + " is not defined!");
            res = false;
        }
        return res;
    }

    @Override public Boolean visitExport(tableParser.ExportContext ctx) { 
        boolean res = visit(ctx.file());
        if(res && typeNode.get(ctx.file()) != TYPE.STRING)
        {
            ErrorHandling.printError(ctx, " type expression " + ctx.file().getText() + " is not defined!");
            res = false;
        }
        return res;
    }

    @Override public Boolean visitConditionBlock(tableParser.ConditionBlockContext ctx) {
        return false;
    }
}
