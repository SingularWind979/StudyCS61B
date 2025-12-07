import java.util.function.Function;

public class HOFDemo {
    public int doTwice(Function<Integer, Integer> f, int x) {
        return f.apply(f.apply(x));
    }

    // stage 1
    static class TenX implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer x) {
            return x * 10;
        }
    }
    public void namedFuncClass() {
        Function<Integer, Integer> f = new TenX();
    }

    // stage 2
    @SuppressWarnings("Convert2Lambda")
    public void anonymousFuncClass() {
        Function<Integer, Integer> f = new Function<>() {
            @Override
            public Integer apply(Integer x) {
                return x * 10;
            }
        };
    }

    // stage 3
    public void lambdaFuncClass() {
        Function<Integer, Integer> f = x -> x * 10;
    }
}