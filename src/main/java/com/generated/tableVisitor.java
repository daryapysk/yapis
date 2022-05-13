// Generated from com\table\table.g4 by ANTLR 4.2.2
package com.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tableParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tableVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tableParser#Par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(@NotNull tableParser.ParContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#printTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintTable(@NotNull tableParser.PrintTableContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#printLast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintLast(@NotNull tableParser.PrintLastContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#Var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull tableParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#uniqueCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueCol(@NotNull tableParser.UniqueColContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(@NotNull tableParser.MainContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#stringExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(@NotNull tableParser.StringExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#tableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableExpr(@NotNull tableParser.TableExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#subTableCol2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTableCol2(@NotNull tableParser.SubTableCol2Context ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#export}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExport(@NotNull tableParser.ExportContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#printExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(@NotNull tableParser.PrintExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(@NotNull tableParser.CompareExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#addRowFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRowFrom(@NotNull tableParser.AddRowFromContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull tableParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#Arithm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm(@NotNull tableParser.ArithmContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(@NotNull tableParser.DataTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#conditionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBlock(@NotNull tableParser.ConditionBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#addCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddCol(@NotNull tableParser.AddColContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#addColFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColFrom(@NotNull tableParser.AddColFromContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#sort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSort(@NotNull tableParser.SortContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#getRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetRow(@NotNull tableParser.GetRowContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#Double}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(@NotNull tableParser.DoubleContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull tableParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(@NotNull tableParser.ElseStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#getHeaderIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetHeaderIndex(@NotNull tableParser.GetHeaderIndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#printVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintVar(@NotNull tableParser.PrintVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#clearField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearField(@NotNull tableParser.ClearFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(@NotNull tableParser.SubContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#getCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetCol(@NotNull tableParser.GetColContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#numRows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumRows(@NotNull tableParser.NumRowsContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#subTableCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTableCol(@NotNull tableParser.SubTableColContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#sortDesc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortDesc(@NotNull tableParser.SortDescContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal(@NotNull tableParser.GlobalContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#addRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRow(@NotNull tableParser.AddRowContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#remCol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemCol(@NotNull tableParser.RemColContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#Int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull tableParser.IntContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull tableParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#clearRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearRow(@NotNull tableParser.ClearRowContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#removeRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveRow(@NotNull tableParser.RemoveRowContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull tableParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#elseIfList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfList(@NotNull tableParser.ElseIfListContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull tableParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#printFirst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintFirst(@NotNull tableParser.PrintFirstContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull tableParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull tableParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull tableParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#getValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetValue(@NotNull tableParser.GetValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#subTableRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTableRow(@NotNull tableParser.SubTableRowContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#setValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetValue(@NotNull tableParser.SetValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#equals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(@NotNull tableParser.EqualsContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull tableParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#newTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewTable(@NotNull tableParser.NewTableContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull tableParser.BoolExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#subTableRow2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTableRow2(@NotNull tableParser.SubTableRow2Context ctx);

	/**
	 * Visit a parse tree produced by {@link tableParser#numColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumColumns(@NotNull tableParser.NumColumnsContext ctx);
}