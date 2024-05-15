import manifold.ext.delegation.rt.api.link;

public sealed interface I1 { void f1();}
public record R() implements I1 { public void f1() {}}
public record R2(@link R r) implements I1 { }

public static void main(String[] args) {
  System.out.println("Hello world!");
}