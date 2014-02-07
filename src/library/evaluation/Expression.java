package library.evaluation;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private Double value;
    private List<Expression> expressions = new ArrayList<>();
    private List<String> operators;

    public Expression() {
    }

    public Expression(Double value) {
        this.value = value;
    }

    public Expression(List<Expression> expressions, List<String> operators){
        this.expressions = expressions;
        this.operators = operators;
    }

    public Expression evaluate(){
        Operators calculator = new Operators();
        double result = calculator.operate(expressions.get(0).getValue(),
                operators.get(0), expressions.get(1).getValue());
        for (int i = 1; i < operators.size(); i++) {
            result = calculator.operate(result, operators.get(i),
                    expressions.get(i + 1).getValue());
        }
        this.value = result;
        return this;
    }

    public Double getValue() {
        return (value!=null)? value: this.evaluate().getValue() ;
    }


}
