
public class Signature {
	String name = "null";
	int noOfArguments = -1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfArguments() {
		return noOfArguments;
	}
	public void setNoOfArguments(int noOfArguments) {
		this.noOfArguments = noOfArguments;
	}
	public Signature(String name, int noOfArguments) {
		super();
		this.name = name;
		this.noOfArguments = noOfArguments;
	}
	public Signature(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + noOfArguments;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Signature other = (Signature) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfArguments != other.noOfArguments)
			return false;
		return true;
	}
	
}
