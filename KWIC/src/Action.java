import java.io.IOException;

public interface Action {
	public String execute(String[] arguments) throws IOException;
}
