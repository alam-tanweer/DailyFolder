package unit04;

public class OuterClass {
    public class InnerClass {
        private String name;

        public InnerClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @SuppressWarnings("unused")
    private InnerClass inner;

    public OuterClass() {
        inner = new InnerClass("Inside");
    }
}
