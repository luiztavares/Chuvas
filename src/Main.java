import java.io.File;
import java.io.IOException;

import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.tools.XMLException;


public class Main {

	
	static final File xml = new File("C:\\Users\\luizandré\\Desktop\\ComModelo.xml");
	
	public static void main(String[] args) {
		

		RapidMiner.init();
		
		
		Monitoramento monitoramento = new Monitoramento();	

	}

}
