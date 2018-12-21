package edu.ceng;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.paukov.combinatorics3.Generator;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



/**
 * Main class
 */
public class Main {

    @Option(name = "-p", required = true, usage="Required")
    public String path;

    @Option(name = "-n", required = true, usage="Required")
    public int number;

   public static void main(String[] args) {
       //

       System.exit(new Main().run(args));

    }

    private int run(String[] args) {
        CmdLineParser par = new CmdLineParser(this);

        try {
            par.parseArgument(args);
           // run();

           data();
            return 0;
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            par.printUsage(System.err);
            return 1;
        }
    }

    public void data() {
        if (number < 2) throw new IllegalArgumentException();
        else if (number > 81) throw new IllegalArgumentException();
        else {
            try {
                String text = this.path.toUpperCase();
                P p = P.valueOf(text);
                find(number, p);
            } catch (IllegalArgumentException e) {
                System.exit(1);
            }
        }
    }



    private static Route find(int n, P p) {

        switch (p) {
            case SHORTEST:
                return findShortest(n);
            case LONGEST:
                return findLongest(n);
            default:
                throw new AssertionError(p);
        }

    }

    static Route findLongest(int n) {
        Optional<Route> max = Generator.combination(IntStream.rangeClosed(0, 80).boxed().collect(Collectors.toList()))
                .simple(n)
                .stream()
                .map(Route::new)
                .max((c1, c2) -> c1.distance() - c2.distance());
        return max.get();
    }

    static Route findShortest(int n) {
        Optional<Route> max = Generator.combination(IntStream.rangeClosed(0, 80).boxed().collect(Collectors.toList()))
                .simple(n)
                .stream()
                .map(Route::new)
                .min((c1, c2) -> c1.distance() - c2.distance());
        return max.get();
    }
}
