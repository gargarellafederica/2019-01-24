package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
	private DefaultDirectedWeightedGraph<String ,DefaultWeightedEdge> grafo; 
	private List<String> stati;
	
	public Model() {
	}
	public void creagrafo() {
		int peso=0;
		stati= this.dao.loadAllStates();
		this.grafo= new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo,stati);
		for (String s1: stati) {
			for(String s2: stati) {
				peso=this.dao.numerovoli(s1, s2);
				DefaultWeightedEdge e = grafo.getEdge(s1, s2);
				if(e==null)
					Graphs.addEdgeWithVertices(this.grafo, s1, s2, peso);
			}
		}
	}
	public List<String> getvertici() {
		Collections.sort(stati);;
		return stati;
	}
	public int getnarchi() {
		return grafo.edgeSet().size();
	}
	public List<Uscenti> stampastatiuscenti(String stato) {
		List<Uscenti> uscenti= new ArrayList<>();
		for(DefaultWeightedEdge e: this.grafo.outgoingEdgesOf(stato)) {
			if (e!=null)
				if(this.grafo.getEdgeWeight(e)>0)
					uscenti.add(new Uscenti(this.grafo.getEdgeTarget(e),(int) this.grafo.getEdgeWeight(e)));
		}
		Collections.sort(uscenti);
		return uscenti;
	}
	
}
