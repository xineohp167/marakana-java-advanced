package advanced.calculator.expression;

public interface ExpressionVisitor<A> {
	A visitNumber(NumberExpression expression);
	A visitOperation(OperationExpression expression);
}
