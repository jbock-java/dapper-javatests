package dagger.internal.codegen;

import com.google.auto.common.Equivalence;
import java.util.List;
import javax.lang.model.type.TypeMirror;

public class TreeDiffer {

  abstract static class MethodSignature {
    abstract String name();

    abstract List<Equivalence.Wrapper<TypeMirror>> parameterTypes();

  }
}
