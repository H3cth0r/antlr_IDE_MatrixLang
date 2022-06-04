// Generated from MLang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MLangParser}.
 */
public interface MLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MLangParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProgramDeclaration(MLangParser.ProgramDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProgramDeclaration(MLangParser.ProgramDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(MLangParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(MLangParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(MLangParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(MLangParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#variable_list}.
	 * @param ctx the parse tree
	 */
	void enterVariable_list(MLangParser.Variable_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#variable_list}.
	 * @param ctx the parse tree
	 */
	void exitVariable_list(MLangParser.Variable_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(MLangParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(MLangParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#asignation}.
	 * @param ctx the parse tree
	 */
	void enterAsignation(MLangParser.AsignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#asignation}.
	 * @param ctx the parse tree
	 */
	void exitAsignation(MLangParser.AsignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(MLangParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(MLangParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(MLangParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(MLangParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#columns}.
	 * @param ctx the parse tree
	 */
	void enterColumns(MLangParser.ColumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#columns}.
	 * @param ctx the parse tree
	 */
	void exitColumns(MLangParser.ColumnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(MLangParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(MLangParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(MLangParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(MLangParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#instruction_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_semicolon(MLangParser.Instruction_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#instruction_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_semicolon(MLangParser.Instruction_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#matrix_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterMatrix_semicolon(MLangParser.Matrix_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#matrix_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitMatrix_semicolon(MLangParser.Matrix_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_main}.
	 * @param ctx the parse tree
	 */
	void enterTk_main(MLangParser.Tk_mainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_main}.
	 * @param ctx the parse tree
	 */
	void exitTk_main(MLangParser.Tk_mainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_bracket_open}.
	 * @param ctx the parse tree
	 */
	void enterTk_bracket_open(MLangParser.Tk_bracket_openContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_bracket_open}.
	 * @param ctx the parse tree
	 */
	void exitTk_bracket_open(MLangParser.Tk_bracket_openContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_bracket_close}.
	 * @param ctx the parse tree
	 */
	void enterTk_bracket_close(MLangParser.Tk_bracket_closeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_bracket_close}.
	 * @param ctx the parse tree
	 */
	void exitTk_bracket_close(MLangParser.Tk_bracket_closeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_type_int}.
	 * @param ctx the parse tree
	 */
	void enterTk_type_int(MLangParser.Tk_type_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_type_int}.
	 * @param ctx the parse tree
	 */
	void exitTk_type_int(MLangParser.Tk_type_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_type_matrix}.
	 * @param ctx the parse tree
	 */
	void enterTk_type_matrix(MLangParser.Tk_type_matrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_type_matrix}.
	 * @param ctx the parse tree
	 */
	void exitTk_type_matrix(MLangParser.Tk_type_matrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_id}.
	 * @param ctx the parse tree
	 */
	void enterTk_id(MLangParser.Tk_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_id}.
	 * @param ctx the parse tree
	 */
	void exitTk_id(MLangParser.Tk_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_semicolon}.
	 * @param ctx the parse tree
	 */
	void enterTk_semicolon(MLangParser.Tk_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_semicolon}.
	 * @param ctx the parse tree
	 */
	void exitTk_semicolon(MLangParser.Tk_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_colon}.
	 * @param ctx the parse tree
	 */
	void enterTk_colon(MLangParser.Tk_colonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_colon}.
	 * @param ctx the parse tree
	 */
	void exitTk_colon(MLangParser.Tk_colonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_comma}.
	 * @param ctx the parse tree
	 */
	void enterTk_comma(MLangParser.Tk_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_comma}.
	 * @param ctx the parse tree
	 */
	void exitTk_comma(MLangParser.Tk_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_bracket_o}.
	 * @param ctx the parse tree
	 */
	void enterTk_bracket_o(MLangParser.Tk_bracket_oContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_bracket_o}.
	 * @param ctx the parse tree
	 */
	void exitTk_bracket_o(MLangParser.Tk_bracket_oContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_bracket_c}.
	 * @param ctx the parse tree
	 */
	void enterTk_bracket_c(MLangParser.Tk_bracket_cContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_bracket_c}.
	 * @param ctx the parse tree
	 */
	void exitTk_bracket_c(MLangParser.Tk_bracket_cContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_asign}.
	 * @param ctx the parse tree
	 */
	void enterTk_asign(MLangParser.Tk_asignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_asign}.
	 * @param ctx the parse tree
	 */
	void exitTk_asign(MLangParser.Tk_asignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_add}.
	 * @param ctx the parse tree
	 */
	void enterTk_add(MLangParser.Tk_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_add}.
	 * @param ctx the parse tree
	 */
	void exitTk_add(MLangParser.Tk_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_sub}.
	 * @param ctx the parse tree
	 */
	void enterTk_sub(MLangParser.Tk_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_sub}.
	 * @param ctx the parse tree
	 */
	void exitTk_sub(MLangParser.Tk_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_prod}.
	 * @param ctx the parse tree
	 */
	void enterTk_prod(MLangParser.Tk_prodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_prod}.
	 * @param ctx the parse tree
	 */
	void exitTk_prod(MLangParser.Tk_prodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_tran}.
	 * @param ctx the parse tree
	 */
	void enterTk_tran(MLangParser.Tk_tranContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_tran}.
	 * @param ctx the parse tree
	 */
	void exitTk_tran(MLangParser.Tk_tranContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLangParser#tk_write}.
	 * @param ctx the parse tree
	 */
	void enterTk_write(MLangParser.Tk_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLangParser#tk_write}.
	 * @param ctx the parse tree
	 */
	void exitTk_write(MLangParser.Tk_writeContext ctx);
}