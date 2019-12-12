package cn.bdqn.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		DaAn d1 = new DaAn(1, "a");
		DaAn d2 = new DaAn(2, "b");
		DaAn d3=  new DaAn(3, "d");
		DaAn d4 = new DaAn(4, "q");
		DaAn d5 = new DaAn(5, "e");
		
		ShiTi s1 = new ShiTi(1, "a");
		ShiTi s2 = new ShiTi(2, "b");
		ShiTi s3 = new ShiTi(3, "d");
		ShiTi s4 = new ShiTi(4, "c");
		ShiTi s5 = new ShiTi(5, "e");
		
		List<DaAn> daAns = new ArrayList<DaAn>();
		daAns.add(d1);
		daAns.add(d2);
		daAns.add(d3);
		daAns.add(d4);
		daAns.add(d5);
		
		List<ShiTi> shiTis = new ArrayList<ShiTi>();
		shiTis.add(s1);
		shiTis.add(s2);
		shiTis.add(s3);
		shiTis.add(s4);
		shiTis.add(s5);
		
		for (int i = 0; i < daAns.size(); i++) {
			if (daAns.get(i).getId()==shiTis.get(i).getId()) {
				if (daAns.get(i).getName()==shiTis.get(i).getName()) {
					System.out.println(daAns.get(i)+"+"+shiTis.get(i));
				}
			}
		}
		
		
		
		
		//new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
		
		/**new Thread(new Runnable() {
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
		List<DaAn> resultList = daAns.stream()
				.filter(item -> !shiTis.stream().map(e -> e.getId() + e.getName())
						.collect(Collectors.toList()).contains(item.getId() + item.getName()))
				.collect(Collectors.toList());

		System.out.println(resultList);*/
	}
}
