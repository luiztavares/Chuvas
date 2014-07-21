import java.io.IOException;

import twitter4j.Status;

import com.rapidminer.Process;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.tools.XMLException;


public class Tweet {
	Status status;
	
	public Tweet(Status status) {
		this.status = status;
	}

	
public String classificaTweet(){
		
    	String classificacao = "";
    	
    	
    	
    	
    	try {
			Process process = new Process(Main.xml);
			Operator op = process.getOperator("Create Document");
			op.setParameter("text", status.getText());
//			process.setCurrentOperator(op);
			
			
			IOContainer resultado = process.run();
			ExampleSet resultado1 = null;
			
			if(resultado.getElementAt(0) instanceof ExampleSet)
				resultado1 = (ExampleSet)resultado.getElementAt(0);
			
			Attribute a = resultado1.getExample(0).getAttributes().getPredictedLabel();	
	
			for(Example exemplo : resultado1)
				classificacao = exemplo.getValueAsString(a);
    	
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (XMLException e) {
			e.printStackTrace();
			
		} catch (OperatorException e) {
			e.printStackTrace();
		}
    	
    	return classificacao;
    	
    }
	
}
