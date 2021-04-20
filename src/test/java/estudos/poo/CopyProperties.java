package estudos.poo;


import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CopyProperties {

    private CopyProperties(){}

    public static <D> void copyFieldsToDestinationFromSources(D destination, Object... sources) {
        if (sources.length == 0 || destination == null) {
            throw new IllegalArgumentException("Source and Destination cannot be null!");
        }
        copyPopulatedFieldsType(destination, (Class<D>) destination.getClass(), sources);
    }

    private static <D> void copyPopulatedFieldsType(D destination, Class<D> classD, Object... sources) {
        Field[] fields = classD.getDeclaredFields();

        Arrays.stream(fields).forEach(fieldDestination -> {
            fieldDestination.setAccessible(true);
            var fieldName = fieldDestination.getName();
            for (Object sourceItem : sources) {
                var classS = sourceItem.getClass();
                try {

                    var methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                    Method declaredMethodGetterSource = classS.getMethod(methodName);
                    declaredMethodGetterSource.setAccessible(true);
                    var valueFound = declaredMethodGetterSource.invoke(sourceItem);


                    if (valueFound != null) {
                        var destinationType = fieldDestination.getType();
                        if (List.class.isAssignableFrom(destinationType) && List.class.isAssignableFrom(valueFound.getClass())) {
                            Class<?> destinationFieldClass = (Class<?>) ((ParameterizedType) fieldDestination.getGenericType()).getActualTypeArguments()[0];
                            var value = ((List) valueFound).stream().map(x -> copyObject(destinationFieldClass, x)).collect(Collectors.toList());
                            fieldDestination.set(destination, value);
                        } else {
                            fieldDestination.set(destination, copyObject(fieldDestination.getType(), valueFound));
                        }
                    }
                    return;
                } catch (RuntimeException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
                    throw new IllegalArgumentException("Erro ao copiar tipos de campos");
                }
            }
        });

        if (Objects.nonNull(classD.getSuperclass())) {
            copyPopulatedFieldsType(destination, (Class) classD.getSuperclass(), sources);
        }
    }

    private static Object copyObject(Class<?> targetType, Object valueFound) {
        try {
            if (!targetType.isInstance(valueFound)) {
                Constructor<?> constructor = null;

                constructor = targetType.getConstructor();
                Object destinationValue = null;
                destinationValue = constructor.newInstance();
                copyFieldsToDestinationFromSources(destinationValue, valueFound);
                return destinationValue;
            } else {
                return valueFound;
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Erro ao copiar objeto");
        }
    }
}