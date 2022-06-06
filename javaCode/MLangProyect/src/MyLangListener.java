// Generated from MLang.g4 by ANTLR 4.10.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.HashMap;
/**
 * This class provides an empty implementation of {@link MyLangListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class MyLangListener implements MLangListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	/*	Map for declaring variables and check for semantic errors
	 *	String		= variable name
	 *  String	= Value
	 */
	public HashMap<String, String> declared_int		= new HashMap<String, String>();
	public HashMap<String, String> declared_matrix	= new HashMap<String, String>();
	boolean is_matrix 		= false;
	boolean is_int 			= false;
	boolean is_declaration 	= false;
	boolean is_asignation 	= false;
	boolean is_expression 	= false;
	boolean is_write		= false;
	public String translation = "";
	public String to_asign_id = "";

	boolean in_matrix_expression_val = false;


	@Override public void enterProgramDeclaration(MLangParser.ProgramDeclarationContext ctx) {
		translation += "#include \"Matrix.h\" \n";
		translation += "int ";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProgramDeclaration(MLangParser.ProgramDeclarationContext ctx) {
		//System.out.println(translation);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInstructions(MLangParser.InstructionsContext ctx) {
		translation += "\t";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInstructions(MLangParser.InstructionsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInstruction(MLangParser.InstructionContext ctx) {
		translation += "\n";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInstruction(MLangParser.InstructionContext ctx) {
		is_int 			= false;
		is_matrix		= false;
		is_asignation	= false;
		is_expression	= false;
		is_write		= false;
		is_declaration	= false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaration(MLangParser.DeclarationContext ctx) {
		is_int 			= false;
		is_matrix		= false;
		is_asignation	= false;
		is_expression	= false;
		is_write		= false;
		is_declaration	= true;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration(MLangParser.DeclarationContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariable_list(MLangParser.Variable_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariable_list(MLangParser.Variable_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDataType(MLangParser.DataTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDataType(MLangParser.DataTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAsignation(MLangParser.AsignationContext ctx) {
		is_int 			= false;
		is_matrix		= false;
		is_asignation	= true;
		is_expression	= false;
		is_write		= false;
		is_declaration	= false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAsignation(MLangParser.AsignationContext ctx) {
		if(declared_matrix.containsKey(to_asign_id) && in_matrix_expression_val == false){
			throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". To Variable \"" + ctx.getText() + "\" Matrix object was not assigned.");
		}
		in_matrix_expression_val =false;

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(MLangParser.ExpressionContext ctx) {
		is_int 			= false;
		is_matrix		= false;
		is_asignation	= false;
		is_expression	= true;
		is_write		= false;
		is_declaration	= false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(MLangParser.ExpressionContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWrite(MLangParser.WriteContext ctx) {
		is_int 			= false;
		is_matrix		= false;
		is_asignation	= false;
		is_expression	= false;
		is_write		= true;
		is_declaration	= false;

		translation += "std::cout << ";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWrite(MLangParser.WriteContext ctx) {
		translation += " << std::endl";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMatrix(MLangParser.MatrixContext ctx) {
		if(declared_int.containsKey(to_asign_id)){
			throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". Variable \"" + to_asign_id + "\" can't get a matrix for assignation.");
		}
		declared_matrix.put(to_asign_id, ctx.columns().getText());
		in_matrix_expression_val = true;
		ctx.columns().getText();
		translation += "{";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMatrix(MLangParser.MatrixContext ctx) {
		translation += "}";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterColumns(MLangParser.ColumnsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitColumns(MLangParser.ColumnsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterColumn(MLangParser.ColumnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitColumn(MLangParser.ColumnContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInteger(MLangParser.IntegerContext ctx) {
		if(declared_int.containsKey(to_asign_id)){
			declared_int.put(to_asign_id, ctx.getText());
		}
		translation += ctx.getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInteger(MLangParser.IntegerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInstruction_semicolon(MLangParser.Instruction_semicolonContext ctx) {
		translation += ctx.getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInstruction_semicolon(MLangParser.Instruction_semicolonContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMatrix_semicolon(MLangParser.Matrix_semicolonContext ctx) {
		translation += "}, {";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMatrix_semicolon(MLangParser.Matrix_semicolonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_main(MLangParser.Tk_mainContext ctx) {
		translation += ctx.getText() + "()";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_main(MLangParser.Tk_mainContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_bracket_open(MLangParser.Tk_bracket_openContext ctx) {
		translation += "\n" + ctx.getText() + "\n";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_bracket_open(MLangParser.Tk_bracket_openContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_bracket_close(MLangParser.Tk_bracket_closeContext ctx) {
		translation += "\n" + ctx.getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_bracket_close(MLangParser.Tk_bracket_closeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_type_int(MLangParser.Tk_type_intContext ctx) {
		is_int = true;
		is_matrix = false;
		translation += "double ";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_type_int(MLangParser.Tk_type_intContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_type_matrix(MLangParser.Tk_type_matrixContext ctx) {
		is_int		=	false;
		is_matrix	= 	true;
		translation += 	"Matrix ";
		//System.out.println(">>>> " + ctx.getStart().getLine() + "." + ctx.getStart().getCharPositionInLine() + ":" + (ctx.getText().length() + ctx.getStart().getCharPositionInLine()));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_type_matrix(MLangParser.Tk_type_matrixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_id(MLangParser.Tk_idContext ctx) {
		translation += ctx.getText();


		if(is_declaration){
			if(is_matrix){
				declared_matrix.put(ctx.getText(), "");
			}
			if(is_int){
				declared_int.put(ctx.getText(), "");
			}
		}else if(is_asignation){
			/*	In case variable is not being declared, check if it was declared*/
			/* Here must also check if the variable type the type of value it should be assigned*/
			// Must also check here that the value that is being assigned is the type it should be assigned
			to_asign_id = ctx.getText();
			if(!declared_matrix.containsKey(ctx.getText()) && !declared_int.containsKey(ctx.getText())){
				// throw error
				throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". Variable \"" + ctx.getText() + "\" not declared.");
			}
		}else if(is_expression){
			// In case the var that expression is being assigned to is matrix and is assigned a Matrix type
			if(declared_matrix.containsKey(ctx.getText()) && declared_matrix.containsKey(to_asign_id)){
				in_matrix_expression_val = true;
			}

			// check if some of the hashmaps contain the key and add the token id
			if(declared_int.containsKey(to_asign_id)){
				if(declared_matrix.containsKey(ctx.getText())){
					throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ", " + ctx.start.getCharPositionInLine()+ ". Matrix variable \"" + ctx.getText() + "\" cant be assign integer.");
				}
			}
			if(declared_int.containsKey(ctx.getText())){
				if(declared_int.containsKey(to_asign_id)) {
					declared_int.put(to_asign_id, ctx.getText());
				}else if(declared_matrix.containsKey(to_asign_id)){
					declared_matrix.put(to_asign_id, ctx.getText());
				}
			}else if(declared_matrix.containsKey(ctx.getText())){
				if(declared_int.containsKey(to_asign_id)) {
					declared_int.put(to_asign_id, ctx.getText());
				}else if(declared_matrix.containsKey(to_asign_id)){
					declared_matrix.put(to_asign_id, ctx.getText());
				}
			}
			/*	In case variable is not being declared, check if it was declared and assigned a value */
			if(!declared_int.containsKey(ctx.getText()) &&  !declared_matrix.containsKey(ctx.getText())){
				// throw error
				throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". Variable \"" + ctx.getText() + "\" not declared.");
			}else if(declared_int.get(ctx.getText()) == "" ||  declared_matrix.get(ctx.getText()) == ""){
				throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". Variable \"" + ctx.getText() + "\" has no value assigned");
			}
		}else if(is_write) {
			/* Check if the variables was declared and assigned a value */
			if(!declared_int.containsKey(ctx.getText()) &&  !declared_matrix.containsKey(ctx.getText())){
				// throw error
				throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". Variable \"" + ctx.getText() + "\" not declared.");
			}else if(declared_int.get(ctx.getText()) == "" ||  declared_matrix.get(ctx.getText()) == ""){
				throw new java.lang.Error("Semantic error at line " + ctx.start.getLine() + ". Variable \"" + ctx.getText() + "\" has no value assigned");
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_id(MLangParser.Tk_idContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_semicolon(MLangParser.Tk_semicolonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_semicolon(MLangParser.Tk_semicolonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_colon(MLangParser.Tk_colonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_colon(MLangParser.Tk_colonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_comma(MLangParser.Tk_commaContext ctx) {
		translation += ctx.getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_comma(MLangParser.Tk_commaContext ctx) {
		translation += " ";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_bracket_o(MLangParser.Tk_bracket_oContext ctx) {
		translation += "{";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_bracket_o(MLangParser.Tk_bracket_oContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_bracket_c(MLangParser.Tk_bracket_cContext ctx) {
		translation += "}";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_bracket_c(MLangParser.Tk_bracket_cContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_asign(MLangParser.Tk_asignContext ctx) {
		translation += ctx.getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_asign(MLangParser.Tk_asignContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_add(MLangParser.Tk_addContext ctx) {
		translation += "+";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_add(MLangParser.Tk_addContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_sub(MLangParser.Tk_subContext ctx) {
		translation += "-";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_sub(MLangParser.Tk_subContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_prod(MLangParser.Tk_prodContext ctx) {
		translation += "*";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_prod(MLangParser.Tk_prodContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_tran(MLangParser.Tk_tranContext ctx) {
		translation += "++";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_tran(MLangParser.Tk_tranContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTk_write(MLangParser.Tk_writeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTk_write(MLangParser.Tk_writeContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}