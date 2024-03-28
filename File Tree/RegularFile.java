
import java.nio.file.Path;
import java.util.Iterator;

public class RegularFile extends File {

	public RegularFile(Path path) {
		super(path);
	}

	@Override
	public Iterator<File> iterator() {
	return new Iterator<File>() {
			boolean visited = false;
			@Override
			public File next() {
				if (visited) {
					throw new NoSuchElementException();
				}
				visited = true;
				return RegularFile.this;
			}
			@Override
			public boolean hasNext() {
				return !visited;
			}
		};
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isRegularFile() {
		return true;
	}

}
