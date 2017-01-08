import java.util.ArrayList;

public class FunctionArgs {
	private String name;
	private String type;
	private ArrayList<String> nameArgs;
	private ArrayList<String> arguments;
	
	public FunctionArgs(String nam){
		name = nam;
		arguments = new ArrayList<String>();
		nameArgs = new ArrayList<String>();
	}
	
	public void addArg(String arg){
		arguments.add(arg);
	}
	
	public void addNameArg(String name){
		nameArgs.add(name);
	}
	
	public int getSize(){
		return arguments.size();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getArguments() {
		return arguments;
	}
	public void setArguments(ArrayList<String> arguments) {
		this.arguments = arguments;
	}

	public ArrayList<String> getNameArgs() {
		return nameArgs;
	}

	public void setNameArgs(ArrayList<String> nameArgs) {
		this.nameArgs = nameArgs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
