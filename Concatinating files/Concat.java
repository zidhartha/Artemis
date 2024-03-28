;

public class Concat {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: concat in1 in2 out");
            return;
        }

        Path in1 = Paths.get(args[0]);
        Path in2 = Paths.get(args[1]);

        if (!Files.isRegularFile(in1) || !Files.isRegularFile(in2)) {
            System.out.println("input files not existent/readable!");
            return;
        }

        Path out = Paths.get(args[2]);

        if (Files.exists(out)) {
            System.out.println("output file already exists!");
            return;
        }

        try {
            out = Files.createFile(out);
        } catch (IOException e) {
            System.out.println("output file could not be created!");
        }

        try {
            Files.write(out, Stream.concat(Files.lines(in1), Files.lines(in2))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("could not read/write!");
        }
    }
}
