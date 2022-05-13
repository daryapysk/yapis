// Generated from com\table\table.g4 by ANTLR 4.2.2
package com.table;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tableParser}.
 */
public interface tableListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tableParser#Par}.
	 * @param ctx the parse tree
	 */
	void enterPar(@NotNull tableParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#Par}.
	 * @param ctx the parse tree
	 */
	void exitPar(@NotNull tableParser.ParContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#printTable}.
	 * @param ctx the parse tree
	 */
	void enterPrintTable(@NotNull tableParser.PrintTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#printTable}.
	 * @param ctx the parse tree
	 */
	void exitPrintTable(@NotNull tableParser.PrintTableContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#printLast}.
	 * @param ctx the parse tree
	 */
	void enterPrintLast(@NotNull tableParser.PrintLastContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#printLast}.
	 * @param ctx the parse tree
	 */
	void exitPrintLast(@NotNull tableParser.PrintLastContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#Var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull tableParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#Var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull tableParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#uniqueCol}.
	 * @param ctx the parse tree
	 */
	void enterUniqueCol(@NotNull tableParser.UniqueColContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#uniqueCol}.
	 * @param ctx the parse tree
	 */
	void exitUniqueCol(@NotNull tableParser.UniqueColContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(@NotNull tableParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(@NotNull tableParser.MainContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#stringExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(@NotNull tableParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#stringExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(@NotNull tableParser.StringExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#tableExpr}.
	 * @param ctx the parse tree
	 */
	void enterTableExpr(@NotNull tableParser.TableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#tableExpr}.
	 * @param ctx the parse tree
	 */
	void exitTableExpr(@NotNull tableParser.TableExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#subTableCol2}.
	 * @param ctx the parse tree
	 */
	void enterSubTableCol2(@NotNull tableParser.SubTableCol2Context ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#subTableCol2}.
	 * @param ctx the parse tree
	 */
	void exitSubTableCol2(@NotNull tableParser.SubTableCol2Context ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#export}.
	 * @param ctx the parse tree
	 */
	void enterExport(@NotNull tableParser.ExportContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#export}.
	 * @param ctx the parse tree
	 */
	void exitExport(@NotNull tableParser.ExportContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(@NotNull tableParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(@NotNull tableParser.PrintExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(@NotNull tableParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(@NotNull tableParser.CompareExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#addRowFrom}.
	 * @param ctx the parse tree
	 */
	void enterAddRowFrom(@NotNull tableParser.AddRowFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#addRowFrom}.
	 * @param ctx the parse tree
	 */
	void exitAddRowFrom(@NotNull tableParser.AddRowFromContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull tableParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull tableParser.AddContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#Arithm}.
	 * @param ctx the parse tree
	 */
	void enterArithm(@NotNull tableParser.ArithmContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#Arithm}.
	 * @param ctx the parse tree
	 */
	void exitArithm(@NotNull tableParser.ArithmContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(@NotNull tableParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(@NotNull tableParser.DataTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#conditionBlock}.
	 * @param ctx the parse tree
	 */
	void enterConditionBlock(@NotNull tableParser.ConditionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#conditionBlock}.
	 * @param ctx the parse tree
	 */
	void exitConditionBlock(@NotNull tableParser.ConditionBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#addCol}.
	 * @param ctx the parse tree
	 */
	void enterAddCol(@NotNull tableParser.AddColContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#addCol}.
	 * @param ctx the parse tree
	 */
	void exitAddCol(@NotNull tableParser.AddColContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#addColFrom}.
	 * @param ctx the parse tree
	 */
	void enterAddColFrom(@NotNull tableParser.AddColFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#addColFrom}.
	 * @param ctx the parse tree
	 */
	void exitAddColFrom(@NotNull tableParser.AddColFromContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#sort}.
	 * @param ctx the parse tree
	 */
	void enterSort(@NotNull tableParser.SortContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#sort}.
	 * @param ctx the parse tree
	 */
	void exitSort(@NotNull tableParser.SortContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#getRow}.
	 * @param ctx the parse tree
	 */
	void enterGetRow(@NotNull tableParser.GetRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#getRow}.
	 * @param ctx the parse tree
	 */
	void exitGetRow(@NotNull tableParser.GetRowContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#Double}.
	 * @param ctx the parse tree
	 */
	void enterDouble(@NotNull tableParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#Double}.
	 * @param ctx the parse tree
	 */
	void exitDouble(@NotNull tableParser.DoubleContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull tableParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull tableParser.ConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(@NotNull tableParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(@NotNull tableParser.ElseStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#getHeaderIndex}.
	 * @param ctx the parse tree
	 */
	void enterGetHeaderIndex(@NotNull tableParser.GetHeaderIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#getHeaderIndex}.
	 * @param ctx the parse tree
	 */
	void exitGetHeaderIndex(@NotNull tableParser.GetHeaderIndexContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#printVar}.
	 * @param ctx the parse tree
	 */
	void enterPrintVar(@NotNull tableParser.PrintVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#printVar}.
	 * @param ctx the parse tree
	 */
	void exitPrintVar(@NotNull tableParser.PrintVarContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#clearField}.
	 * @param ctx the parse tree
	 */
	void enterClearField(@NotNull tableParser.ClearFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#clearField}.
	 * @param ctx the parse tree
	 */
	void exitClearField(@NotNull tableParser.ClearFieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(@NotNull tableParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(@NotNull tableParser.SubContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#getCol}.
	 * @param ctx the parse tree
	 */
	void enterGetCol(@NotNull tableParser.GetColContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#getCol}.
	 * @param ctx the parse tree
	 */
	void exitGetCol(@NotNull tableParser.GetColContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#numRows}.
	 * @param ctx the parse tree
	 */
	void enterNumRows(@NotNull tableParser.NumRowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#numRows}.
	 * @param ctx the parse tree
	 */
	void exitNumRows(@NotNull tableParser.NumRowsContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#subTableCol}.
	 * @param ctx the parse tree
	 */
	void enterSubTableCol(@NotNull tableParser.SubTableColContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#subTableCol}.
	 * @param ctx the parse tree
	 */
	void exitSubTableCol(@NotNull tableParser.SubTableColContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#sortDesc}.
	 * @param ctx the parse tree
	 */
	void enterSortDesc(@NotNull tableParser.SortDescContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#sortDesc}.
	 * @param ctx the parse tree
	 */
	void exitSortDesc(@NotNull tableParser.SortDescContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobal(@NotNull tableParser.GlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobal(@NotNull tableParser.GlobalContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#addRow}.
	 * @param ctx the parse tree
	 */
	void enterAddRow(@NotNull tableParser.AddRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#addRow}.
	 * @param ctx the parse tree
	 */
	void exitAddRow(@NotNull tableParser.AddRowContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#remCol}.
	 * @param ctx the parse tree
	 */
	void enterRemCol(@NotNull tableParser.RemColContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#remCol}.
	 * @param ctx the parse tree
	 */
	void exitRemCol(@NotNull tableParser.RemColContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#Int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull tableParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#Int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull tableParser.IntContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull tableParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull tableParser.FileContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#clearRow}.
	 * @param ctx the parse tree
	 */
	void enterClearRow(@NotNull tableParser.ClearRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#clearRow}.
	 * @param ctx the parse tree
	 */
	void exitClearRow(@NotNull tableParser.ClearRowContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#removeRow}.
	 * @param ctx the parse tree
	 */
	void enterRemoveRow(@NotNull tableParser.RemoveRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#removeRow}.
	 * @param ctx the parse tree
	 */
	void exitRemoveRow(@NotNull tableParser.RemoveRowContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull tableParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull tableParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#elseIfList}.
	 * @param ctx the parse tree
	 */
	void enterElseIfList(@NotNull tableParser.ElseIfListContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#elseIfList}.
	 * @param ctx the parse tree
	 */
	void exitElseIfList(@NotNull tableParser.ElseIfListContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull tableParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull tableParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#printFirst}.
	 * @param ctx the parse tree
	 */
	void enterPrintFirst(@NotNull tableParser.PrintFirstContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#printFirst}.
	 * @param ctx the parse tree
	 */
	void exitPrintFirst(@NotNull tableParser.PrintFirstContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull tableParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull tableParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull tableParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull tableParser.IfStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull tableParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull tableParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#getValue}.
	 * @param ctx the parse tree
	 */
	void enterGetValue(@NotNull tableParser.GetValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#getValue}.
	 * @param ctx the parse tree
	 */
	void exitGetValue(@NotNull tableParser.GetValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#subTableRow}.
	 * @param ctx the parse tree
	 */
	void enterSubTableRow(@NotNull tableParser.SubTableRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#subTableRow}.
	 * @param ctx the parse tree
	 */
	void exitSubTableRow(@NotNull tableParser.SubTableRowContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#setValue}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(@NotNull tableParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#setValue}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(@NotNull tableParser.SetValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#equals}.
	 * @param ctx the parse tree
	 */
	void enterEquals(@NotNull tableParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#equals}.
	 * @param ctx the parse tree
	 */
	void exitEquals(@NotNull tableParser.EqualsContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull tableParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull tableParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#newTable}.
	 * @param ctx the parse tree
	 */
	void enterNewTable(@NotNull tableParser.NewTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#newTable}.
	 * @param ctx the parse tree
	 */
	void exitNewTable(@NotNull tableParser.NewTableContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull tableParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull tableParser.BoolExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#subTableRow2}.
	 * @param ctx the parse tree
	 */
	void enterSubTableRow2(@NotNull tableParser.SubTableRow2Context ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#subTableRow2}.
	 * @param ctx the parse tree
	 */
	void exitSubTableRow2(@NotNull tableParser.SubTableRow2Context ctx);

	/**
	 * Enter a parse tree produced by {@link tableParser#numColumns}.
	 * @param ctx the parse tree
	 */
	void enterNumColumns(@NotNull tableParser.NumColumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableParser#numColumns}.
	 * @param ctx the parse tree
	 */
	void exitNumColumns(@NotNull tableParser.NumColumnsContext ctx);
}