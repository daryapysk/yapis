package com.table;

import com.generated.tableBaseListener;
import com.generated.tableParser;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
public class Compiler extends tableBaseListener {

    static int scope = 0;
    Map<String, Variable> vars;
    Map<String,String> junk;
    STGroup group;
    ST ifStat;
    ST main;
    ST tmp;

    public Compiler() {
        vars = new HashMap<String, Variable>();
        junk = new HashMap<String,String>();
    }

    @Override public void enterMain(tableParser.MainContext ctx) {
        final String FILE_NAME = "templates";
        final String FILE_FORMAT = "stg";
        final String IN_FILE_PATH = System.getProperty("user.dir") + "/templates/" + FILE_NAME + "." + FILE_FORMAT;
        String templateGroupFile = IN_FILE_PATH;
        group = new STGroupFile(templateGroupFile);
        main = group.getInstanceOf("main");
        main.add("className","TableOutput");
    }

    @Override public void exitMain(tableParser.MainContext ctx) {
        try (PrintWriter writer = new PrintWriter(new File("TableOutput.java"))){
            writer.print(main.render());
        } catch (Exception e) {
            System.out.println("ERROR: couldn't generate java file...");
        }
        System.out.println(main.render());
    }

    @Override public void exitDeclaration(tableParser.DeclarationContext ctx) {
        String acType = ctx.variable().getText();
        String type = ctx.dataType().getText();
        String varName = ctx.ID().getText();
        Variable var = new Variable(type, null, acType);
        vars.put(varName, var);
        tmp = group.getInstanceOf("declaration");

        switch(type) {
            case "int":
                if(acType=="global")
                {
                    tmp.add("accessType","global");
                }
                else {
                    tmp.add("accessType", "");
                }
                tmp.add("dataType", "int");
                tmp.add("name", varName);
                if(scope == 0) main.add("stat", tmp.render());
                else ifStat.add("ifstat", tmp.render());
                break;
            case "double":
                if(acType=="global")
                {
                    tmp.add("accessType","global");
                }
                else {
                    tmp.add("accessType", "");
                }
                tmp.add("dataType", "double");
                tmp.add("name", varName);
                if(scope == 0) main.add("stat", tmp.render());
                else ifStat.add("ifstat", tmp.render());
                break;
            case "table":
                if(acType=="global")
                {
                    tmp.add("accessType","global");
                }
                else {
                    tmp.add("accessType", "");
                }
                tmp.add("dataType", "Table");
                tmp.add("name", varName);
                if(scope == 0) main.add("stat", tmp.render());
                else ifStat.add("ifstat", tmp.render());
                break;
            case "boolean":
                if(acType=="global")
                {
                    tmp.add("accessType","global");
                }
                else {
                    tmp.add("accessType", "");
                }
                tmp.add("dataType", "boolean");
                tmp.add("name", varName);
                if(scope == 0) main.add("stat", tmp.render());
                else ifStat.add("ifstat", tmp.render());
                break;
            case "string":
                if(acType=="global")
                {
                    tmp.add("accessType","global");
                }
                else {
                    tmp.add("accessType", "");
                }
                tmp.add("dataType", "String");
                tmp.add("name", varName);
                if(scope == 0) main.add("stat", tmp.render());
                else ifStat.add("ifstat", tmp.render());
                break;
            default:
                break;
        }

    }

    @Override public void exitAssignment(tableParser.AssignmentContext ctx) {
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            tmp = group.getInstanceOf("assignment");
            tmp.add("name", ctx.ID().getText());
            tmp.add("value", ctx.expr().getText());
            if(scope == 0) main.add("stat", tmp.render());
            else ifStat.add("ifstat", tmp.render());
            var.setValue(tmp.render());
        } else {
            System.out.println("ERROR: variable \"" + ctx.ID().getText() + "\" is not declared...");
        }
    }

    @Override public void exitPrintExpr(tableParser.PrintExprContext ctx) {
        tmp = group.getInstanceOf("print");
        tmp.add("expression", ctx.expr().getText());
        if(scope == 0) main.add("stat", tmp.render());
        else ifStat.add("ifstat", tmp.render());

    }

    @Override public void exitPrintVar(tableParser.PrintVarContext ctx) {
        if(vars.containsKey(ctx.ID().getText())) {
            tmp = group.getInstanceOf("printVar");
            tmp.add("var", ctx.ID().getText());
            if(scope == 0) {	//main scope
                main.add("stat", tmp.render());
            } else {			//if scope
                ifStat.add("ifstat", tmp.render());
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void enterIfStatement(tableParser.IfStatementContext ctx) {
        scope = 1;
        ifStat = group.getInstanceOf("ifStatement");
    }

    @Override public void exitIfStatement(tableParser.IfStatementContext ctx) {
        ifStat.add("condition", ctx.boolExpr().getText());
        main.add("stat", ifStat.render());
        scope = 0;
    }

    @Override public void enterElseIfList(tableParser.ElseIfListContext ctx) {
        scope = 1;
        ifStat = group.getInstanceOf("elseIfList");
    }

    @Override public void exitElseIfList(tableParser.ElseIfListContext ctx) {
        ifStat.add("condition", ctx.boolExpr().getText());
        main.add("stat", ifStat.render());
        scope = 0;
    }

    @Override public void enterElseStatement(tableParser.ElseStatementContext ctx) {
        scope = 1;
        ifStat = group.getInstanceOf("elseStatement");
    }

    @Override public void exitElseStatement(tableParser.ElseStatementContext ctx) {
        main.add("stat", ifStat.render());
        scope = 0;
    }

    @Override public void exitPar(tableParser.ParContext ctx) {
        ctx.value = ctx.numExpr().getText();
    }

    @Override public void exitArithm(tableParser.ArithmContext ctx) {
        ctx.value = ctx.e1.getText() + ctx.op.getText() + ctx.e2.getText();
    }
    @Override public void exitVar(tableParser.VarContext ctx) {
        ctx.value = ctx.ID().getText();
    }

    @Override public void exitDouble(tableParser.DoubleContext ctx) {
        ctx.value = ctx.DOUBLE().getText();
    }

    @Override public void exitInt(tableParser.IntContext ctx) {
        ctx.value = ctx.INTEGER().getText();
    }
    @Override public void enterTableExpr(tableParser.TableExprContext ctx) { }
    @Override public void exitTableExpr(tableParser.TableExprContext ctx) { }

    @Override public void exitNewTable(tableParser.NewTableContext ctx) {
        tmp = group.getInstanceOf("newTable");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("file", "\"" + ctx.file().getText() + "\"");
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitAddRow(tableParser.AddRowContext ctx) {
        tmp = group.getInstanceOf("addRow");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("row", ctx.STRING().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitAddRowFrom(tableParser.AddRowFromContext ctx) {
        tmp = group.getInstanceOf("addRowFrom");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("row", ctx.STRING().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitRemoveRow(tableParser.RemoveRowContext ctx) {
        tmp = group.getInstanceOf("removeRow");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitGetValue(tableParser.GetValueContext ctx) {
        tmp = group.getInstanceOf("getValue");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("row", ctx.x.getText());
                tmp.add("col", ctx.y.getText());
                main.add("stat", tmp.render());
                junk.put("getValue", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitSetValue(tableParser.SetValueContext ctx) {
        tmp = group.getInstanceOf("setValue");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("row", ctx.x.getText());
                tmp.add("col", ctx.y.getText());
                tmp.add("value", ctx.expr().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitClearRow(tableParser.ClearRowContext ctx) {
        tmp = group.getInstanceOf("clearRow");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitAddCol(tableParser.AddColContext ctx) {
        tmp = group.getInstanceOf("addCol");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("col", ctx.STRING().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitAddColFrom(tableParser.AddColFromContext ctx) {
        tmp = group.getInstanceOf("addColFrom");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("col", ctx.STRING().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitRemCol(tableParser.RemColContext ctx) {
        tmp = group.getInstanceOf("removeCol");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitClearField(tableParser.ClearFieldContext ctx) {
        tmp = group.getInstanceOf("clearField");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("row", ctx.x.getText());
                tmp.add("col", ctx.y.getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitNumColumns(tableParser.NumColumnsContext ctx) {
        tmp = group.getInstanceOf("numColumns");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitNumRows(tableParser.NumRowsContext ctx) {
        tmp = group.getInstanceOf("numRows");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitUniqueCol(tableParser.UniqueColContext ctx) {
        tmp = group.getInstanceOf("getUnique");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitGetCol(tableParser.GetColContext ctx) {
        tmp = group.getInstanceOf("getColumn");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                tmp.add("header", ctx.boolExpr().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitGetRow(tableParser.GetRowContext ctx) {
        tmp = group.getInstanceOf("getRow");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitGetHeaderIndex(tableParser.GetHeaderIndexContext ctx) {
        tmp = group.getInstanceOf("getHeaderIndex");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("str", ctx.stringExpr().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitSubTableCol(tableParser.SubTableColContext ctx) {
        tmp = group.getInstanceOf("subTableCol");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("start", ctx.s.getText());
                tmp.add("end", ctx.e.getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitSubTableCol2(tableParser.SubTableCol2Context ctx) {
        tmp = group.getInstanceOf("subTableCol2");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("start", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitSubTableRow(tableParser.SubTableRowContext ctx) {
        tmp = group.getInstanceOf("subTableRow");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("start", ctx.s.getText());
                tmp.add("end", ctx.e.getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitSubTableRow2(tableParser.SubTableRow2Context ctx) {
        tmp = group.getInstanceOf("subTableRow2");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("start", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitAdd(tableParser.AddContext ctx) {
        tmp = group.getInstanceOf("addTable");
        if(vars.containsKey(ctx.var1.getText()) && vars.containsKey(ctx.var2.getText())) {
            Variable var1 = vars.get(ctx.var1.getText());
            Variable var2 = vars.get(ctx.var2.getText());
            if(var1.getType().equals("table") && var2.getType().equals("table")) {
                tmp.add("var1", ctx.var1.getText());
                tmp.add("var2", ctx.var2.getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variables are not table type...");
            }
        } else {
            System.err.println("ERROR: Some of the variables are not declared...");
        }
    }

    @Override public void exitSub(tableParser.SubContext ctx) {
        tmp = group.getInstanceOf("subTable");
        if(vars.containsKey(ctx.var1.getText()) && vars.containsKey(ctx.var2.getText())) {
            Variable var1 = vars.get(ctx.var1.getText());
            Variable var2 = vars.get(ctx.var2.getText());
            if(var1.getType().equals("table") && var2.getType().equals("table")) {
                tmp.add("var1", ctx.var1.getText());
                tmp.add("var2", ctx.var2.getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variables are not table type...");
            }
        } else {
            System.err.println("ERROR: Some of the variables are not declared...");
        }
    }

    @Override public void exitSort(tableParser.SortContext ctx) {
        tmp = group.getInstanceOf("sort");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitSortDesc(tableParser.SortDescContext ctx) {
        tmp = group.getInstanceOf("sortDesc");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }


    @Override public void exitEquals(tableParser.EqualsContext ctx) {
        tmp = group.getInstanceOf("isEqual");
        if(vars.containsKey(ctx.var1.getText()) && vars.containsKey(ctx.var2.getText())) {
            Variable var1 = vars.get(ctx.var1.getText());
            Variable var2 = vars.get(ctx.var2.getText());
            if(var1.getType().equals("table") && var2.getType().equals("table")) {
                tmp.add("var1", ctx.var1.getText());
                tmp.add("var2", ctx.var2.getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variables are not table type...");
            }
        } else {
            System.err.println("ERROR: Some of the variables are not declared...");
        }
    }

    @Override public void exitExport(tableParser.ExportContext ctx) {
        tmp = group.getInstanceOf("export");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("file", "\"" + ctx.file().getText() + "\"");
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitPrintTable(tableParser.PrintTableContext ctx) {
        tmp = group.getInstanceOf("printTable");
        assert vars.containsKey(ctx.ID().getText()) : "ERROR: variable not declared...";
        Variable var = vars.get(ctx.ID().getText());
        assert var.getType().equals("table") : "ERROR: variable types mismatch...";
        tmp.add("var", ctx.ID().getText());
        main.add("stat", tmp.render());
    }

    @Override public void exitPrintFirst(tableParser.PrintFirstContext ctx) {
        tmp = group.getInstanceOf("printFirst");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }

    @Override public void exitPrintLast(tableParser.PrintLastContext ctx) {
        tmp = group.getInstanceOf("printLast");
        if(vars.containsKey(ctx.ID().getText())) {
            Variable var = vars.get(ctx.ID().getText());
            if(var.getType().equals("table")) {
                tmp.add("var", ctx.ID().getText());
                tmp.add("idx", ctx.INTEGER().getText());
                main.add("stat", tmp.render());
            } else {
                System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not table type...");
            }
        } else {
            System.err.println("ERROR: variable \"" + ctx.ID().getText() + "\" not declared...");
        }
    }
}
