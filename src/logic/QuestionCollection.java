package logic;

import java.util.ArrayList;

public class QuestionCollection {
	private ArrayList<Question> Questions = new ArrayList<Question>();
	
	public void Add(Question q) {
		Questions.add(q);
	}
	////test questions
	public QuestionCollection() {
		Questions.add(new Question("Para que dos figuras sean isométricas, es necesario que sean congruentes.", true));
		
		Questions.add(new Question("Una isometría es directa si se obtiene empleando traslaciones o rotaciones con una simetría axial.", false));
		
		Questions.add(new Question("Si tengo una recta paralela al eje de simetría axial, el eje es paralela media de ella y su imágen.", true));
		
		Questions.add(new Question("la recta u es el eje de simetría axial entre los dos triángulos.", false, "src/Images/antitraslacion.png"));
		
		Questions.add(new Question("Toda recta del plano que pase por el centro de simetría, tiene por imágen otra recta paralela con ella y tal que el centro de simetría equidista de ambas.", false));
		
		Questions.add(new Question("En la siguiente imágen, sabemos que el cuadrado rojo es imágen del cuadrado azul con la recta r como eje de simetría axial.¿Podemos tambien decir que existe simetría central entre ambos cuadrados, con el punto O como centro de simetría?", false, "src/Images/preguntaCuadrados.png"));
		
		Questions.add(new Question("Sabemos que A'B'C'D' es imágen de ABCD con el punto E como centro de simetría.¿Podemos decir que  el segmento BC' es paralelo al segmento CB'?", true, "src/Images/preguntaCentral.png"));
		
		Questions.add(new Question("En la siguiente imágen, sabemos que A'B'C' es la imágen de trasladar ABC por el vector u.\\n¿Podemos también decir que existe algún tipo de simetría entre ABC y A'B'C?", true, "src/Images/preguntaTraslacion.png"));
		
		Questions.add(new Question("Si rotamos una figura 180º, se produce una simetría central entre ella y su imágen\r\n", true));
		
		
	}
	public ArrayList<Question> GetAll(){
		return Questions;
	}
}
