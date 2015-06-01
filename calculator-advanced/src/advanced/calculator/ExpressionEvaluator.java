package advanced.calculator;

import advanced.calculator.expression.ExpressionVisitor;
import advanced.calculator.expression.NumberExpression;
import advanced.calculator.expression.OperationExpression;

public class ExpressionEvaluator implements ExpressionVisitor<Integer> {

	@Override
	public Integer visitNumber(NumberExpression expression) {
		return expression.getValue();
	}

	@Override
	public Integer visitOperation(OperationExpression expression) {
		return expression.getOp().operate(expression.getLhs().accept(this), expression.getRhs().accept(this));
	}

}
