package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public void run() {

		Model model = new Model();
		model.creagrafo();
		System.out.print("Grafo creato");
//		System.out.print("vertici: "+ model.getnvertici());
//		System.out.print(" archi: "+ model.getnarchi());
	}
	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();
	}

}
