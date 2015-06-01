package advanced.calculator;

import advanced.calculator.expression.ExpressionVisitor;
import advanced.calculator.expression.NumberExpression;
import advanced.calculator.expression.OperationExpression;

public class ExpressionRenderer implements ExpressionVisitor<String> {

	@Override
	public String visitNumber(NumberExpression expression) {
		return String.valueOf(expression.getValue());
	}

	@Override
	public String visitOperation(OperationExpression expression) {
		return String.format("(%s %s %s)", expression.getLhs().accept(this),
				expression.getOp(), expression.getRhs().accept(this));
	}

}
