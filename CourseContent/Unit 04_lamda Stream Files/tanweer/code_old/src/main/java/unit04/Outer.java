package unit04;

public class Outer {
    private final int x;
    private String OuterVar = "Outer var";

    public Outer(int x) {
        this.x = x;
    }

    public void ClassMethod() {
        String abc = "&&&&&&&&&&&&asdfasdfasdf";
        //Don't have public
        class MethodInner {
            private String name;

            public MethodInner(String name) {
                this.name = name;
                System.out.println(abc);    
                // abc = "asdf";
            }
        }

        new MethodInner("abc");
    }

    public class Inner {
        private String name;

        public Inner(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name + ": " + x;
        }

        public class InnerInner {
            private String name;

            public InnerInner(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return name + ": " + x;
            }
        }
    }

    public static class StaticInner {
        private String name;

        public StaticInner(String name) {
            this.name = name;
        }
    }

}
