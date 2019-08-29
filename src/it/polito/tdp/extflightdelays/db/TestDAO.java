package it.polito.tdp.extflightdelays.db;

import java.util.List;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		List<String> stati=dao.loadAllStates();
		System.out.println(dao.loadAllStates());
		for(String s1: stati)
			for(String s2: stati)
				System.out.println(dao.numerovoli(s1,s2));

	}

}
