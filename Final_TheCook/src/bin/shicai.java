package bin;

public class shicai {
	private int id;
	private String name;
	private int []relation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getRelation() {
		return relation;
	}
	public void setRelation(int[] relation) {
		this.relation = relation;
	}
	public shicai(int id, String name, int[] relation) {
		super();
		this.id = id;
		this.name = name;
		this.relation = relation;
	}
	
}
