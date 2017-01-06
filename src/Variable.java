import java.util.InputMismatchException;

/**
 * Variables are compared based on name 
 * Type = ['void','int','str','list']
 */
public class Variable {
	String name = "null";
	String type = "void";	
	public Variable(){
		
	}

	public Variable(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		try{
			if (!(type.equals("string") || type.equals("int"))){
				throw new InputMismatchException();
			}									
		}
		catch (InputMismatchException e){
			System.out.println("Invalid Variable Type This Shouldn't Happen");
		}
		this.type = type;
	}
}
