import twitter4j.Status;


public class modeloTemporal implements Runnable{

	int sensores = 0;
	long tempoInicial = System.currentTimeMillis();
	long tempoAtual;
	
	public void run() {
		
		
	}

	public void addSensor(Status status) {
		this.sensores++; 
		
	}

//	public double formulaOcorrencia(){
		
//		double expoente = Constante.n0 * (1- Math.pow(Constante.e, -Constante.lambda*(t+1)));
		
		
//		return 1- Math.pow(Constante.falsosPositivos, expoente);
		
		
//	}
	
	
}
