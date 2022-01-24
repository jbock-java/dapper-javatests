package dagger.internal.codegen;

import com.sun.source.tree.CompilationUnitTree;
import java.util.Set;

public class JavaSourcesSubject {

  abstract static class TypedCompilationUnit {
    abstract CompilationUnitTree tree();

    abstract Set<String> types();

  }
}
