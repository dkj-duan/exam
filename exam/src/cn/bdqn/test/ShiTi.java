package cn.bdqn.test;

public class ShiTi {

	private Integer id;
	
	private String name;

	public ShiTi(Integer id,String name){
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ShiTi [id=" + id + ", name=" + name + "]";
	}
	
	
}
