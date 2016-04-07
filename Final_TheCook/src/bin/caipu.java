package bin;

public class caipu {
	public int id;
	public String name;
	public String procdure;
	public caipu(int id, String name, String procdure) {
		super();
		this.id = id;
		this.name = name;
		this.procdure = procdure;
	}
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
	public String getProcdure() {
		return procdure;
	}
	public void setProcdure(String procdure) {
		this.procdure = procdure;
	}
}
